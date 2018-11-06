package com.hit.cost.jpa;

import com.hit.cost.bean.TokenInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author:fealty
 * @Description:
 * @Date：2018/10/24 19:21
 */
public interface TokenJPA extends JpaRepository<TokenInfoEntity,String>, JpaSpecificationExecutor<TokenInfoEntity> {

}
