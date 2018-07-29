package com.hit.cost.generate;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:
 * @Date：2018/7/10 13:42
 * <p>
 * Created By IDEA
 * ==========================
 */
public class IdGenerate implements IdentifierGenerator {
    public IdGenerate() {
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String str= session.getSessionIdentifier().toString();
        str =str.replaceAll("-","");
        str=str.substring(0,20);
      return  str;
    }
//    public synchronized String getId(){
//        Properties pros =  System.getProperties();
//        return null;
//    }
}
