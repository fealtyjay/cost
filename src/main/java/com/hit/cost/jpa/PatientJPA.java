package com.hit.cost.jpa;

import com.hit.cost.bean.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @Author:fealty
 * @Description:
 * @Date：2018/7/6 15:01
 */
@Repository
public interface PatientJPA extends JpaRepository<Patient,String>,
        JpaSpecificationExecutor<Patient>,
        Serializable{
}
