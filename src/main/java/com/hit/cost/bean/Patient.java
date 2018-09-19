package com.hit.cost.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:
 * @Date：2018/7/6 14:45
 * <p>
 * Created By IDEA
 * ==========================
 */
@Entity
@Table(name="dc_patient")
public class Patient implements Serializable{

    /**
     * CODE : 17425498
     * CREATIONTIME : null
     * CREATOR : ~
     * DEF1 : 2016-12-29
     * DEF10 : ~
     * DEF11 : ~
     * DEF12 : ~
     * DEF13 : ~
     * DEF14 : ~
     * DEF15 : ~
     * DEF16 : ~
     * DEF17 : ~
     * DEF18 : ~
     * DEF19 : ~
     * DEF2 : 2017-01-02
     * DEF20 : ~
     * DEF3 : ~
     * DEF4 : ~
     * DEF5 : ~
     * DEF6 : ~
     * DEF7 : ~
     * DEF8 : ~
     * DEF9 : ~
     * DR : 0
     * MODIFIEDTIME : null
     * MODIFIER : ~
     * NAME : 杨海林
     * PHONE : null
     * PK_GROUP : 0001F510000000000FIZ
     * PK_ORG : 0001F510000000002EX7
     * PK_ORG_V : ~
     * PK_PARENT : null
     * PK_PATIENT : 0001AA1000000000LJSS
     * RECORDNUM : 2165011
     * TS : 2018-06-29 11:22:42
     * VID : null
     * VMEMO : null
     * VNUM : 1
     * VSEX : 2
     * PK_DEPT : ~
     */
    @OrderColumn
    private String code;
    private String creationtime;
    private String creator;
    private String def1;
    private String def10;
    private String def11;
    private String def12;
    private String def13;
    private String def14;
    private String def15;
    private String def16;
    private String def17;
    private String def18;
    private String def19;
    private String def2;
    private String def20;
    private String def3;
    private String def4;
    private String def5;
    private String def6;
    private String def7;
    private String def8;
    private String def9;
    private Integer dr;
    private String modifiedtime;
    private String modifier;
    private String name;
    private String phone;
    private String pk_group;
    private String pk_org;
    private String pk_org_v;
    private String pk_parent;
    @Id
    @GeneratedValue(generator = "myGenerator")
    @GenericGenerator(name="myGenerator",strategy = "com.hit.cost.generate.IdGenerate")
    private String pk_patient;
    private String recordnum;
    private String ts;
    private String vid;
    private String vmemo;
    private Integer vnum;
    private Integer vsex;
    private String pk_dept;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(String creationtime) {
        this.creationtime = creationtime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDef1() {
        return def1;
    }

    public void setDef1(String def1) {
        this.def1 = def1;
    }

    public String getDef10() {
        return def10;
    }

    public void setDef10(String def10) {
        this.def10 = def10;
    }

    public String getDef11() {
        return def11;
    }

    public void setDef11(String def11) {
        this.def11 = def11;
    }

    public String getDef12() {
        return def12;
    }

    public void setDef12(String def12) {
        this.def12 = def12;
    }

    public String getDef13() {
        return def13;
    }

    public void setDef13(String def13) {
        this.def13 = def13;
    }

    public String getDef14() {
        return def14;
    }

    public void setDef14(String def14) {
        this.def14 = def14;
    }

    public String getDef15() {
        return def15;
    }

    public void setDef15(String def15) {
        this.def15 = def15;
    }

    public String getDef16() {
        return def16;
    }

    public void setDef16(String def16) {
        this.def16 = def16;
    }

    public String getDef17() {
        return def17;
    }

    public void setDef17(String def17) {
        this.def17 = def17;
    }

    public String getDef18() {
        return def18;
    }

    public void setDef18(String def18) {
        this.def18 = def18;
    }

    public String getDef19() {
        return def19;
    }

    public void setDef19(String def19) {
        this.def19 = def19;
    }

    public String getDef2() {
        return def2;
    }

    public void setDef2(String def2) {
        this.def2 = def2;
    }

    public String getDef20() {
        return def20;
    }

    public void setDef20(String def20) {
        this.def20 = def20;
    }

    public String getDef3() {
        return def3;
    }

    public void setDef3(String def3) {
        this.def3 = def3;
    }

    public String getDef4() {
        return def4;
    }

    public void setDef4(String def4) {
        this.def4 = def4;
    }

    public String getDef5() {
        return def5;
    }

    public void setDef5(String def5) {
        this.def5 = def5;
    }

    public String getDef6() {
        return def6;
    }

    public void setDef6(String def6) {
        this.def6 = def6;
    }

    public String getDef7() {
        return def7;
    }

    public void setDef7(String def7) {
        this.def7 = def7;
    }

    public String getDef8() {
        return def8;
    }

    public void setDef8(String def8) {
        this.def8 = def8;
    }

    public String getDef9() {
        return def9;
    }

    public void setDef9(String def9) {
        this.def9 = def9;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

    public String getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(String modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPk_group() {
        return pk_group;
    }

    public void setPk_group(String pk_group) {
        this.pk_group = pk_group;
    }

    public String getPk_org() {
        return pk_org;
    }

    public void setPk_org(String pk_org) {
        this.pk_org = pk_org;
    }

    public String getPk_org_v() {
        return pk_org_v;
    }

    public void setPk_org_v(String pk_org_v) {
        this.pk_org_v = pk_org_v;
    }

    public String getPk_parent() {
        return pk_parent;
    }

    public void setPk_parent(String pk_parent) {
        this.pk_parent = pk_parent;
    }

    public String getPk_patient() {
        return pk_patient;
    }

    public void setPk_patient(String pk_patient) {
        this.pk_patient = pk_patient;
    }

    public String getRecordnum() {
        return recordnum;
    }

    public void setRecordnum(String recordnum) {
        this.recordnum = recordnum;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getVmemo() {
        return vmemo;
    }

    public void setVmemo(String vmemo) {
        this.vmemo = vmemo;
    }

    public Integer getVnum() {
        return vnum;
    }

    public void setVnum(Integer vnum) {
        this.vnum = vnum;
    }

    public Integer getVsex() {
        return vsex;
    }

    public void setVsex(Integer vsex) {
        this.vsex = vsex;
    }

    public String getPk_dept() {
        return pk_dept;
    }

    public void setPk_dept(String pk_dept) {
        this.pk_dept = pk_dept;
    }
}
