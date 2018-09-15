package com.hit.cost.interceptors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hit.cost.bean.LoggerEntity;
import com.hit.cost.jpa.LoggerJPA;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:
 * @Date：2018/9/5 15:27
 * <p>
 * Created By IDEA
 * ==========================
 */
public class LoggerInterceptor implements HandlerInterceptor{
    private  static  final String LOGGER_SEND_TIME="_send_time";

    private  static final  String LOGGER_ENTITY ="_logger_entity";
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        LoggerEntity loggerEntity = new LoggerEntity();
        BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
//        System.out.println(sb);
        JSONObject requestbody = (JSONObject) JSON.parse(sb.toString());
//        String requestBody = JSON.toJSONString(sb.toString(),
//////                SerializerFeature.DisableCircularReferenceDetect,
//////                SerializerFeature.WriteMapNullValue);
        Map<String,Object> map = new HashMap<>();
        map.put("parameter",request.getParameterMap());
        map.put("body",requestbody);
        String sessionId = request.getRequestedSessionId();
        String uri = request.getRequestURI();
        String paramData = JSON.toJSONString(map,
                SerializerFeature.DisableCircularReferenceDetect,
        SerializerFeature.WriteMapNullValue);
        loggerEntity.setClientIp(getClientIP(request));
        loggerEntity.setParamData(paramData);
        loggerEntity.setSessionId(sessionId);
        loggerEntity.setUri(uri);
        loggerEntity.setTime(new Timestamp(System.currentTimeMillis()));
        loggerEntity.setHttpStatusData(response.getStatus()+"");
        loggerEntity.setMethod(request.getMethod());
        request.setAttribute(LOGGER_SEND_TIME,System.currentTimeMillis());
        request.setAttribute(LOGGER_ENTITY,loggerEntity);
        return true;
    }

    /**
     * 获取客户端IP
     * @param request
     * @return
     */
    private String getClientIP(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        // 多个路由时，取第一个非unknown的ip
        final String[] arr = ip.split(",");
        for (final String str : arr) {
            if (!"unknown".equalsIgnoreCase(str)) {
                ip = str;
                break;
            }
        }
        return ip;
    }
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        int status = response.getStatus();
        long currentTimeMillis = System.currentTimeMillis();

        long begin =Long.valueOf(String.valueOf(request.getAttribute(LOGGER_SEND_TIME)));
        LoggerEntity logger = (LoggerEntity) request.getAttribute(LOGGER_ENTITY);
        logger.setTimeConsuming(Integer.valueOf(currentTimeMillis-begin+""));
        logger.setRetrunTime(new Timestamp(currentTimeMillis));
        logger.setReturnData(
                JSON.toJSONString(request.getAttribute(LOGGER_ENTITY),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue)
        );
        LoggerJPA jpa = WebApplicationContextUtils.getRequiredWebApplicationContext(
                request.getServletContext()).getBean(LoggerJPA.class);
        jpa.save(logger);

    }
}
