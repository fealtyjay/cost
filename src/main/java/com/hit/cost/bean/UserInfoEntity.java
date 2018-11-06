package com.hit.cost.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:
 * @Date：2018/10/24 16:40
 * <p>
 * Created By IDEA
 * ==========================
 */
@Entity
@Table(name = "api_user_infos")
public class UserInfoEntity implements Serializable {
    @Id
    @Column(name ="aui_app_id")
    private  String appID;
    @Column(name ="aui_app_secret")
    private  byte[] appSecret;
    @Column(name ="aui_status")
    private  int status;
    @Column(name ="aui_day_request_count")
    private  int dayRequestCount;
    @Column(name ="aui_ajax_bind_ip")
    private String ajaxBindIp;
    @Column(name ="mark")
    private String mark;

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
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
    public byte[] getAppSecret() {
        return appSecret;
    }
    public void setAppSecret(byte[] appSecret) {
        this.appSecret = appSecret;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDayRequestCount() {
        return dayRequestCount;
    }

    public void setDayRequestCount(int dayRequestCount) {
        this.dayRequestCount = dayRequestCount;
    }

    public String getAjaxBindIp() {
        return ajaxBindIp;
    }

    public void setAjaxBindIp(String ajaxBindIp) {
        this.ajaxBindIp = ajaxBindIp;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
