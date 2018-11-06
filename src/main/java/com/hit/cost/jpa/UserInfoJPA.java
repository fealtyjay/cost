package com.hit.cost.jpa;

import com.hit.cost.bean.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author:fealty
 * @Description:
 * @Date：2018/10/24 19:17
 */
public interface UserInfoJPA extends JpaRepository<UserInfoEntity,String>, JpaSpecificationExecutor<UserInfoEntity> {
}
