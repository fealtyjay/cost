package com.hit.cost.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:
 * @Date：2018/9/15 16:55
 * <p>
 * Created By IDEA
 * ==========================
 */
@NoRepositoryBean
public interface BaseRepository<T,PK extends Serializable>  extends JpaRepository<T,PK> {

}
