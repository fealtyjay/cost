package com.hit.cost.controller;

import com.hit.cost.bean.User;
import com.hit.cost.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@Api(value = "用户API")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value="/list",method = RequestMethod.GET)
    @ApiOperation(value = "获取所有的系统用户",notes = "使用缓存来获取")
    public List<User> list(){
        return userService.list();
    }
}
