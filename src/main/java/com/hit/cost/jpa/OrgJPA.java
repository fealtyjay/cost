package com.hit.cost.jpa;

import com.hit.cost.bean.Org;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:fealty
 * @Description:
 * @Date：2018/7/29 21:11
 */
public interface OrgJPA extends JpaRepository<Org,String>,JpaSpecificationExecutor<Org>,Serializable {
    /**
     * nativeQuery：true 直接按照自己写的SQL来执行,如果此时返回的对象中有某些属性，
     *               而查询结果集中没有这些属性，会在查询时报列名无效
     * @return
     */
    @Query(value = "select  code,name,vname,pk_vid,pk_org  from org_orgs where isbusinessunit='Y'",
    nativeQuery = false)
    public List<Org> findAllBusinessUnit() ;

}
