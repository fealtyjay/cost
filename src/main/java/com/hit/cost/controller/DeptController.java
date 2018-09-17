package com.hit.cost.controller;

import com.hit.cost.bean.Dept;
import com.hit.cost.bean.QDept;
import com.hit.cost.jpa.DeptJPA;
import com.hit.cost.query.Inquirer;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Iterator;
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
    //注入entityManager
    @PersistenceContext
    private EntityManager entityManager;
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
        PageRequest pageRequest  = PageRequest.of(dept.getPage()-1,dept.getSize());
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
      PageRequest pageRequest = PageRequest.of(dept.getPage()-1,dept.getSize(),sort);
      //执行分页查询
      return deptJPA.findAll(pageRequest).getContent();
    }
   @RequestMapping(value = "query",method = RequestMethod.GET)
    public  List<Dept>  list(){
       QDept qDept =QDept.dept;
       JPAQuery<Dept> jpaQuery = new JPAQuery<>(entityManager);
       return jpaQuery.
               //查询字段
               select(qDept).
                       //查询表
                       from(qDept).
                       //自己添加查询条件
                               //返回查询结果
                       fetch();
   }
   @RequestMapping(value = "join")
   public List<Dept> join(){
        QDept qDept =QDept.dept;
        //查询条件
        BooleanExpression expression =qDept.innercode.contains("FORT");
        //执行查询
        Iterator<Dept> iterator = deptJPA.findAll(expression).iterator();
        List<Dept> depts = new ArrayList<Dept>();
        while(iterator.hasNext()){
            depts.add(iterator.next());
        }
        return depts;
    }
    @RequestMapping(value = "joindef")
    public List<Dept> joinDef(){
        QDept qDept =  QDept.dept;
        Inquirer inquirer = new Inquirer();
        inquirer.putExpression(qDept.innercode.contains("AIGW"));
        return inquirer.iteratorToList(deptJPA.findAll(inquirer.buildQuery()));
    }

}
