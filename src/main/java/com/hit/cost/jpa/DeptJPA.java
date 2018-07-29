package com.hit.cost.jpa;

import com.hit.cost.bean.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @Author:fealty
 * @Description:
 * @Date：2018/7/27 16:44
 */
public interface DeptJPA extends JpaRepository<Dept,String>, JpaSpecificationExecutor<Dept>,Serializable{
}
