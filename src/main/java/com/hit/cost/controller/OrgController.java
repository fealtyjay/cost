package com.hit.cost.controller;

import com.hit.cost.bean.Org;
import com.hit.cost.jpa.OrgJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:
 * @Date：2018/7/29 21:08
 * <p>
 * Created By IDEA
 * ==========================
 */
@RestController
@RequestMapping(value = "/org")
public class OrgController {
    @Autowired
    private OrgJPA orgJPA;
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public List<Org> queryAll(){
        return orgJPA.findAll();
    }
    @RequestMapping(value = "allbusinessunit",method = RequestMethod.GET)
    public  List<Org> queryAllBusinessUnit(){
        return orgJPA.findAllBusinessUnit();
    }
}
