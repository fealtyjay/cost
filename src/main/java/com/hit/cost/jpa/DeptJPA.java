package com.hit.cost.jpa;

import com.hit.cost.bean.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author:fealty
 * @Description:
 * @Date：2018/7/27 16:44
 */
public interface DeptJPA extends JpaRepository<Dept,String>, JpaSpecificationExecutor<Dept>,Serializable{
    @Modifying
    @Query(value = " update " +
            "org_dept" +
            " set dr='1' where code=?1 ",nativeQuery = true)
    public void deleteByCode(String code);

}
