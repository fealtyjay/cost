package com.hit.cost.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:
 * @Date：2018/8/1 19:44
 * <p>
 * Created By IDEA
 * ==========================
 */
public class MailEntity implements Serializable {
    //smtp服务器
    private String smtpService;
    //smtp服务器端口号
    private String smtpPort;
    //发送邮箱地址
    private String fromSmtpAddres;
    //发送邮箱密码
    private String fromSmtpPwd;
    //设置邮件标题
    private String title;
    //设置邮件内容
    private String content;
    //内容格式（默认采用html）
    private String contentType;
    //接受邮件地址集合
    private List<String> list = new ArrayList<>();

    public String getSmtpService() {
        return smtpService;
    }

    public void setSmtpService(String smtpService) {
        this.smtpService = smtpService;
    }

    public String getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }

    public String getFromSmtpAddres() {
        return fromSmtpAddres;
    }

    public void setFromSmtpAddres(String fromSmtpAddres) {
        this.fromSmtpAddres = fromSmtpAddres;
    }

    public String getFromSmtpPwd() {
        return fromSmtpPwd;
    }

    public void setFromSmtpPwd(String fromSmtpPwd) {
        this.fromSmtpPwd = fromSmtpPwd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
