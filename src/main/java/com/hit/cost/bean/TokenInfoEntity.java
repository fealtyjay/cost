package com.hit.cost.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:
 * @Date：2018/10/24 16:55
 * <p>
 * Created By IDEA
 * ==========================
 */
@Entity
@Table(name="api_token_infos")
public class TokenInfoEntity implements Serializable {
    @Id
    @GeneratedValue(generator="increaseGenerator")
    @GenericGenerator(name="increaseGenerator",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="ati_id")
    private String id;
    @Column(name="ati_app_id")
    private String appId;
    @Column(name="ati_token")
    private  byte[] token;
    @Column(name="ati_build_time")
    private  String buildTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
    @Basic
    @Lob
    /**
     * BLOB类型,类型声明为byte[]：　　private byte[] content;　　
     * 注解：　　@Lob　　
     *           @Basic(fetch = FetchType.LAZY)　　
     *          @Column(name = "CONTENT", columnDefinition = "BLOB",nullable=true)　　
     *          public byte[] getContent() {　　  return this.content;　　}　　
     *          public void setContent(byte[] content) {　　  this.content = content;　　}　　
     * CLOB类型，类型声明为String即可：　　private String remark;　　
     * 注解：　　@Lob　　
     *           @Basic(fetch = FetchType.EAGER)　　
     *           @Column(name="REMARK", columnDefinition="CLOB", nullable=true)　　
     *           public String getRemark() {　　  return this.remark;　　}　　
     *           public void setRemark(String recvdocRemark) {　　  this.remark = remark;　　}　
     * 　按照以上的设置实体类的注解就OK了。
     * ---------------------
     * 作者：JasonBrody
     * 来源：CSDN
     * 原文：https://blog.csdn.net/jasontech/article/details/27884551
     * 版权声明：本文为博主原创文章，转载请附上博文链接！
     */
    public byte[] getToken() {
        return token;
    }
    public void setToken(byte[] token) {
        this.token = token;
    }

    public String getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(String buildTime) {
        this.buildTime = buildTime;
    }
}
