package com.hit.cost.bean;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:
 * @Date：2018/8/1 20:25
 * <p>
 * Created By IDEA
 * ==========================
 */
public enum  MailContentTypeEnum {
    HTML("text/html;charset=UTF-8"), //html格式
    TEXT("text");
    private String value;

    MailContentTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
