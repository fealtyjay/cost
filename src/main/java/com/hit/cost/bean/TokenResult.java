package com.hit.cost.bean;

import java.io.Serializable;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:
 * @Date：2018/10/24 19:26
 * <p>
 * Created By IDEA
 * ==========================
 */
public class TokenResult implements Serializable {
    //状态
    private boolean flag =true;
    //消息内容
    private String msg ="";
   //token
    private String token ="";

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
