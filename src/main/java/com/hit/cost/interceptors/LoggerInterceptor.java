package com.hit.cost.interceptors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hit.cost.bean.LoggerEntity;
import com.hit.cost.jpa.LoggerJPA;
import org.springframework.beans.factory.BeanFactory;
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
        //自动排除生成token的路径,并且如果是options请求是cors跨域预请求，设置allow对应头信息
        //if (request.getRequestURI().equals("/token")|| RequestMethod.OPTIONS.toString().endsWith(request.getMethod())){
        //   return true;
        //}
        ////其他请求获取头信息
        //final String authHeader = request.getHeader("X-YAuth-Token");
        //try {
        //    //如果没有header信息
        //    if (authHeader == null || authHeader.trim() == "") {
        //        throw new SignatureException("not found X-YAuth-Token.");
        //    }
        //
        //    //获取jwt实体对象接口实例
        //    final Claims claims = Jwts.parser().setSigningKey("ZEUSAUTHv1.0.0")
        //            .parseClaimsJws(authHeader).getBody();
        //    //从数据库中获取token
        //    Optional<TokenInfoEntity> token = getDAO(TokenJPA.class,request).findOne(new Specification<TokenInfoEntity>() {
        //        @Override
        //        public Predicate toPredicate(Root<TokenInfoEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        //            criteriaQuery.where(criteriaBuilder.equal(root.get("appId"), claims.getSubject()));
        //            return null;
        //        }
        //    });
        //    //数据库中的token值
        //    String tokenval = new String(token.get().getToken());
        //    //如果内存中不存在,提示客户端获取token
        //    if(tokenval == null || tokenval.trim() == "") {
        //        throw new SignatureException("not found token info, please get token agin.");
        //    }
        //    //判断内存中的token是否与客户端传来的一致
        //    if(!tokenval.equals(authHeader))
        //    {
        //        throw new SignatureException("not found token info, please get token agin.");
        //    }
        //}
        ////验证异常处理
        //catch (SignatureException | ExpiredJwtException e)
        //{
        //    //输出对象
        //    PrintWriter writer = response.getWriter();
        //
        //    //输出error消息
        //    writer.write("need refresh token");
        //    writer.close();
        //    return false;
        //}
        ////出现异常时
        //catch (final Exception e)
        //{
        //    //输出对象
        //    PrintWriter writer = response.getWriter();
        //    //输出error消息
        //    writer.write(e.getMessage());
        //    writer.close();
        //    return false;
        //}
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
    /**
     * 根据传入的类型获取spring管理的对应dao
     * @param clazz 类型
     * @param request 请求对象
     * @param <T>
     * @return
     */
    private <T> T getDAO(Class<T> clazz,HttpServletRequest request)
    {
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return factory.getBean(clazz);
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
