package com.hit.cost.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:
 * @Date：2018/7/6 13:23
 * <p>
 * Created By IDEA
 * ==========================
 */
@RestController
public class HelloWorldController {

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public  String  index(){
        return "Hello World";
    }
}
