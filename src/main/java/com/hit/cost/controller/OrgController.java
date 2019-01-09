package com.hit.cost.controller;

import com.hit.cost.bean.Org;
import com.hit.cost.bean.QOrg;
import com.hit.cost.jpa.OrgJPA;
import com.hit.cost.query.Inquirer;
import com.querydsl.core.types.dsl.BooleanExpression;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

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
@Api(value="组织API")
public class OrgController {
    @Autowired
    private OrgJPA orgJPA;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ApiOperation(value="查询所有组织",notes = "查询出当前数据库中的所有组织")
    public List<Org> queryAll() {
        List<Org> orgs = orgJPA.findAll();
        long count = orgs.stream().count();
        System.out.println("查询出："+count+" 条数据");
        orgs.stream().forEach(System.out::println);
        //orgs.stream().forEach(Org ::getCode);
        return orgJPA.findAll();
    }

    @RequestMapping(value = "allbusinessunit", method = RequestMethod.GET)
    @ApiOperation(value="查询所有业务单元",notes="查询所有是业务单元的组织",httpMethod = "GET")
    public List<Org> queryAllBusinessUnit() {
        return orgJPA.findAllBusinessUnit();
    }

    @RequestMapping(value = "code", method = RequestMethod.POST)
    @ApiOperation(value="根据组织编码查询组织")
    @ApiImplicitParam(name="code",value="组织编码",required = true)
    public Org findbyCode(@RequestParam(name = "code") String code) {
        Optional<Org> res = orgJPA.findOne(new Specification<Org>() {
            @Override
            public Predicate toPredicate(Root<Org> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                query.where(criteriaBuilder.equal(root.get("code"), code));
                return null;
            }
        });
        return res.get();
    }

    @RequestMapping(value = "sons", method = RequestMethod.POST)
    @ApiOperation(value ="根据内部编码查询所有的下级组织",notes = "查询组织属性内部编码中包含参数的编码的所有组织")
    @ApiImplicitParam(name="innercode",value = "内部编码",required = true)
    public List<Org> findSons(@RequestParam(name = "innercode") String innercode) {
        return orgJPA.findAll(new Specification<Org>() {
            @Override
            public Predicate toPredicate(Root<Org> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                query.where(criteriaBuilder.like(root.get("innercode"), innercode + "%"));
                return null;
            }
        });
    }
    @RequestMapping(value = "many")
    @ApiOperation(value = "查询出所有组织",notes = "根据组织和部门的对应关系，查询出所有组织对应的部门")
    public  List<Org> many(){
        QOrg qOrg = QOrg.org;
        BooleanExpression expression = qOrg.isbusinessunit.eq("Y");
        Inquirer inquirer  = new Inquirer();
        inquirer.putExpression(expression);
        return inquirer.iteratorToList(orgJPA.findAll(inquirer.buildQuery()));
    }


}
