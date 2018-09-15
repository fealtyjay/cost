package com.hit.cost.controller;

import com.hit.cost.bean.Patient;
import com.hit.cost.jpa.PatientJPA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:
 * @Date：2018/7/6 15:17
 * <p>
 * Created By IDEA
 * ==========================
 */
@RestController
@RequestMapping(value = "/patient")
public class PatientController {
    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
    @Autowired
    private PatientJPA patientJPA;
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Patient> list() {
        logger.info("list");
        return patientJPA.findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Patient save(@RequestBody Patient patient) {
        logger.debug("debug");
        return patientJPA.save(patient);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(Patient patient) {
        patientJPA.delete(patient);
    }


}
