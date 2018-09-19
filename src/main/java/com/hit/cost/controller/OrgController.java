package com.hit.cost.controller;

import com.hit.cost.bean.Org;
import com.hit.cost.bean.QOrg;
import com.hit.cost.jpa.OrgJPA;
import com.hit.cost.query.Inquirer;
import com.querydsl.core.types.dsl.BooleanExpression;
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
public class OrgController {
    @Autowired
    private OrgJPA orgJPA;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Org> queryAll() {
        return orgJPA.findAll();
    }

    @RequestMapping(value = "allbusinessunit", method = RequestMethod.GET)
    public List<Org> queryAllBusinessUnit() {
        return orgJPA.findAllBusinessUnit();
    }

    @RequestMapping(value = "code", method = RequestMethod.POST)
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
    public  List<Org> many(){
        QOrg qOrg = QOrg.org;
        BooleanExpression expression = qOrg.isbusinessunit.eq("Y");
        Inquirer inquirer  = new Inquirer();
        inquirer.putExpression(expression);
        return inquirer.iteratorToList(orgJPA.findAll(inquirer.buildQuery()));
    }


}
