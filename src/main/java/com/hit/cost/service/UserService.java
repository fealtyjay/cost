package com.hit.cost.service;

import com.hit.cost.bean.User;
import com.hit.cost.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "user")
public class UserService {
    @Autowired
    private UserJPA userJPA;
    @Cacheable
    public List<User> list(){
        return userJPA.findAll();
    }

}
