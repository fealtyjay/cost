package com.hit.cost.controller;

import com.hit.cost.bean.Dept;
import com.hit.cost.jpa.DeptJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:
 * @Date：2018/7/27 16:59
 * <p>
 * Created By IDEA
 * ==========================
 */
@RestController
@RequestMapping(value = "/dept")
public class DeptController {
    @Autowired
    private DeptJPA deptJPA;
    @RequestMapping(value="list",method = RequestMethod.GET)
    public List<Dept> queryAll(){
        return deptJPA.findAll();
    }
    @RequestMapping(value="sons",method = RequestMethod.POST)
    public  List<Dept> getAllSonsByCode(@RequestParam(name = "code") String code){
        return null;
    }
    @RequestMapping(value = "deletebycode",method = RequestMethod.POST)
    public  void deleteByCode(@RequestParam(name="code") String code){
        deptJPA.deleteByCode(code);
    }

}
