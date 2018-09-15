package com.hit.cost.jpa;

import com.hit.cost.bean.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * update操作需要添加事物注解
 * @Author:fealty
 * @Description:
 * @Date：2018/7/27 16:44
 */
@Transactional
public interface DeptJPA extends JpaRepository<Dept,String>, JpaSpecificationExecutor<Dept>,Serializable{
    @Modifying
    /**
     * nativeQuery：true 使用原生SQL语句
     * nativeQuery：false 使用HQL语句
     */
    @Query(value = " update " +
            "org_dept" +
            " set dr='1' where code=?1 ",nativeQuery = true)
    public void deleteByCode(String code);

}
