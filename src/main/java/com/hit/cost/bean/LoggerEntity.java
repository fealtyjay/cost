package com.hit.cost.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:
 * @Date：2018/9/5 14:37
 * <p>
 * Created By IDEA
 * ==========================
 */
@Entity
@Table(name="logger_infos")
public class LoggerEntity implements Serializable {
    /**
     * CREATE TABLE
     *     logger_infos
     *     (
     *         ali_id VARCHAR2(100) NOT NULL,
     *         ali_session_id VARCHAR2(100),
     *         ali_time TIMESTAMP(0),
     *         ali_return_time TIMESTAMP(0),
     *         ali_return_data CLOB,
     *         ali_http_status_code VARCHAR2(10),
     *         ali_time_consuming VARCHAR2(8),
     *         ali_client_ip VARCHAR2(30),
     *         ali_uri VARCHAR2(100),
     *         ali_type VARCHAR2(50),
     *         ali_method VARCHAR2(10),
     *         ali_param_data CLOB, PRIMARY KEY (ali_id)
     *     )
     */
    @Id
    @GeneratedValue(generator="guidGenerator")
    @GenericGenerator(name="guidGenerator",strategy = "org.hibernate.id.GUIDGenerator")
    @Column(name="ali_id")
    private String id;
    @Column(name="ali_client_ip")
    private String clientIp;
    @Column(name="ali_uri")
    private String uri;
    @Column(name="ali_type")
    private String type;
    @Column(name="ali_method")
    private  String method;
    @Column(name = "ali_param_data")
    private String paramData;
    @Column(name ="ali_session_id")
    private  String sessionId;
    @Column(name="ali_time")
    private Timestamp time;
    @Column(name="ali_return_time")
    private Timestamp retrunTime;
    @Column(name="ali_return_data")
    private String returnData;
    @Column(name="ali_http_status_code")
    private String httpStatusData;
    @Column(name="ali_time_consuming")
    private int timeConsuming;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParamData() {
        return paramData;
    }

    public void setParamData(String paramData) {
        this.paramData = paramData;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Timestamp getRetrunTime() {
        return retrunTime;
    }

    public void setRetrunTime(Timestamp retrunTime) {
        this.retrunTime = retrunTime;
    }

    public String getReturnData() {
        return returnData;
    }

    public void setReturnData(String returnData) {
        this.returnData = returnData;
    }

    public String getHttpStatusData() {
        return httpStatusData;
    }

    public void setHttpStatusData(String httpStatusData) {
        this.httpStatusData = httpStatusData;
    }

    public int getTimeConsuming() {
        return timeConsuming;
    }

    public void setTimeConsuming(int timeConsuming) {
        this.timeConsuming = timeConsuming;
    }
}
