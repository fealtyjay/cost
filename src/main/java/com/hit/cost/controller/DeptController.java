package com.hit.cost.controller;

import com.hit.cost.bean.Dept;
import com.hit.cost.jpa.DeptJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    /**
     * 分页查询
     * @param page
     * @return
     */
    @RequestMapping(value = "cutpage",method = RequestMethod.POST)
    public List<Dept> cutPage( int page){
        Dept dept  = new Dept();
        dept.setPage(page);
        dept.setSize(5);
//        dept.setSidx("code");
        PageRequest pageRequest  = new PageRequest(dept.getPage()-1,dept.getSize());
        return deptJPA.findAll(pageRequest).getContent();
    }

    /**
     * 分页查询排序
     * @param page
     * @return
     */
    @RequestMapping(value = "sort",method = RequestMethod.POST)
    public List<Dept> sortDatas(int page){
      Dept dept = new Dept();
      dept.setPage(page);
      dept.setSize(10);
      //获取排序对象
      Sort.Direction sort_direction = Sort.Direction.ASC.toString().equalsIgnoreCase(dept.getSorted()) ? Sort.Direction.ASC:Sort.Direction.DESC;
      //设置排序对象参数
      Sort sort  = new Sort(sort_direction,dept.getSidx());
      //创建分页对象
      PageRequest pageRequest = new PageRequest(dept.getPage()-1,dept.getSize(),sort);
      //执行分页查询
      return deptJPA.findAll(pageRequest).getContent();
    }

}
