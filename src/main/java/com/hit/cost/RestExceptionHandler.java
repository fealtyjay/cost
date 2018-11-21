package com.hit.cost;

import org.springframework.web.bind.annotation.*;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:
 * @Date：2018/11/13 11:09
 * <p>
 * Created By IDEA
 * ==========================
 */
@ControllerAdvice(annotations= RestController.class)
@ResponseBody
public class RestExceptionHandler {
    @ExceptionHandler
    @ResponseStatus
    public  String runtimeExceptionHandler(Exception e){
     return "哎呀，出错了："+e.getMessage();
    }
}
