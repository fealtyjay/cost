package com.hit.cost.jpa;

import com.hit.cost.bean.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author:fealty
 * @Description:
 * @Date：2018/9/5 15:24
 */
public interface LoggerJPA extends JpaRepository<LoggerEntity, String> {
}
