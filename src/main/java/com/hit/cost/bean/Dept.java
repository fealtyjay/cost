package com.hit.cost.bean;

import com.hit.cost.base.BaseEntity;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * =========================
 *
 * @Author:fealty
 * @Description:
 * @Date：2018/7/27 16:36
 * <p>
 * Created By IDEA
 * ==========================
 */
@Entity
@Table(name="org_dept")
public class Dept extends BaseEntity {

    /**
     * ADDRESS : ~
     * CODE : 101
     * CREATEDATE : 2017-11-21
     * CREATIONTIME : 2017-11-21 11:19:14
     * CREATOR : 1001AA10000000001PQN
     * DATAORIGINFLAG : 0
     * DEPTCANCELDATE : null
     * DEPTLEVEL : 1001F51000000003QL5N
     * DEPTTYPE : 0
     * DISPLAYORDER : 999999
     * DR : 0
     * ENABLESTATE : 2
     * HRCANCELED : N
     * INNERCODE : RBQD
     * ISLASTVERSION : Y
     * ISRETAIL : N
     * MEMO : null
     * MNECODE : null
     * MODIFIEDTIME : 2017-12-19 11:35:31
     * MODIFIER : 1001F51000000003QKWU
     * NAME : 大内科
     * NAME2 : null
     * NAME3 : null
     * NAME4 : null
     * NAME5 : null
     * NAME6 : null
     * ORGTYPE13 : Y
     * ORGTYPE17 : N
     * PK_DEPT : 1001AA10000000002YHG
     * PK_FATHERORG : ~
     * PK_GROUP : 0001F510000000000FIZ
     * PK_ORG : 0001F510000000002EX7
     * PK_VID : 0001AA10000000002UMY
     * PRINCIPAL : ~
     * RESPOSITION : ~
     * SHORTNAME : null
     * SHORTNAME2 : null
     * SHORTNAME3 : null
     * SHORTNAME4 : null
     * SHORTNAME5 : null
     * SHORTNAME6 : null
     * TEL : null
     * TS : 2017-12-19 11:35:31
     * VENDDATE : 9999-12-31 23:59:59
     * VNAME : 初始版本
     * VNAME2 : null
     * VNAME3 : null
     * VNAME4 : null
     * VNAME5 : null
     * VNAME6 : null
     * VNO : 201701
     * VSTARTDATE : 2017-11-21 11:19:14
     * DEPTDUTY : null
     * PK_CALAT : 1001AA1000000006RQPE
     */

    private String address;
    @NotEmpty
    private String code;
    private String createdate;
    private String creationtime;
    private String creator;
    private int dataoriginflag;
    private String deptcanceldate;
    private String deptlevel;
    private int depttype;
    private int displayorder;
    private int dr;
    private int enablestate;
    private String hrcanceled;
    private String innercode;
    private String islastversion;
    private String isretail;
    private String  memo;
    private String mnecode;
    private String modifiedtime;
    private String modifier;
    private String name;
    private String name2;
    private String name3;
    private String name4;
    private String name5;
    private String name6;
    private String orgtype13;
    private String orgtype17;
    @Id
    private String pk_dept;
    private String pk_fatherorg;
    private String pk_group;
//    @OneToOne
//    @JoinColumn( name="pk_org")
//    private Org  org;
//    private String pk_org;
    private String pk_vid;
    private String principal;
    private String resposition;
    private String shortname;
    private String shortname2;
    private String shortname3;
    private String shortname4;
    private String shortname5;
    private String shortname6;
    private String tel;
    private String ts;
    private String venddate;
    private String vname;
    private String vname2;
    private String vname3;
    private String vname4;
    private String vname5;
    private String vname6;
    private String vno;
    private String vstartdate;
    private String deptduty;
    private String pk_calat;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
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

    public int getDataoriginflag() {
        return dataoriginflag;
    }

    public void setDataoriginflag(int dataoriginflag) {
        this.dataoriginflag = dataoriginflag;
    }

    public String getDeptcanceldate() {
        return deptcanceldate;
    }

    public void setDeptcanceldate(String deptcanceldate) {
        this.deptcanceldate = deptcanceldate;
    }

    public String getDeptlevel() {
        return deptlevel;
    }

    public void setDeptlevel(String deptlevel) {
        this.deptlevel = deptlevel;
    }

    public int getDepttype() {
        return depttype;
    }

    public void setDepttype(int depttype) {
        this.depttype = depttype;
    }

    public int getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(int displayorder) {
        this.displayorder = displayorder;
    }

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

    public int getEnablestate() {
        return enablestate;
    }

    public void setEnablestate(int enablestate) {
        this.enablestate = enablestate;
    }

    public String getHrcanceled() {
        return hrcanceled;
    }

    public void setHrcanceled(String hrcanceled) {
        this.hrcanceled = hrcanceled;
    }

    public String getInnercode() {
        return innercode;
    }

    public void setInnercode(String innercode) {
        this.innercode = innercode;
    }

    public String getIslastversion() {
        return islastversion;
    }

    public void setIslastversion(String islastversion) {
        this.islastversion = islastversion;
    }

    public String getIsretail() {
        return isretail;
    }

    public void setIsretail(String isretail) {
        this.isretail = isretail;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getMnecode() {
        return mnecode;
    }

    public void setMnecode(String mnecode) {
        this.mnecode = mnecode;
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

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getName4() {
        return name4;
    }

    public void setName4(String name4) {
        this.name4 = name4;
    }

    public String getName5() {
        return name5;
    }

    public void setName5(String name5) {
        this.name5 = name5;
    }

    public String getName6() {
        return name6;
    }

    public void setName6(String name6) {
        this.name6 = name6;
    }

    public String getOrgtype13() {
        return orgtype13;
    }

    public void setOrgtype13(String orgtype13) {
        this.orgtype13 = orgtype13;
    }

    public String getOrgtype17() {
        return orgtype17;
    }

    public void setOrgtype17(String orgtype17) {
        this.orgtype17 = orgtype17;
    }

    public String getPk_dept() {
        return pk_dept;
    }

    public void setPk_dept(String pk_dept) {
        this.pk_dept = pk_dept;
    }

    public String getPk_fatherorg() {
        return pk_fatherorg;
    }

    public void setPk_fatherorg(String pk_fatherorg) {
        this.pk_fatherorg = pk_fatherorg;
    }

    public String getPk_group() {
        return pk_group;
    }

    public void setPk_group(String pk_group) {
        this.pk_group = pk_group;
    }

//    public String getPk_org() {
//        return pk_org;
//    }
//
//    public void setPk_org(String pk_org) {
//        this.pk_org = pk_org;
//    }

//    public Org getOrg() {
//        return org;
//    }
//
//    public void setOrg(Org org) {
//        this.org = org;
//    }

    public String getPk_vid() {
        return pk_vid;
    }

    public void setPk_vid(String pk_vid) {
        this.pk_vid = pk_vid;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getResposition() {
        return resposition;
    }

    public void setResposition(String resposition) {
        this.resposition = resposition;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getShortname2() {
        return shortname2;
    }

    public void setShortname2(String shortname2) {
        this.shortname2 = shortname2;
    }

    public String getShortname3() {
        return shortname3;
    }

    public void setShortname3(String shortname3) {
        this.shortname3 = shortname3;
    }

    public String getShortname4() {
        return shortname4;
    }

    public void setShortname4(String shortname4) {
        this.shortname4 = shortname4;
    }

    public String getShortname5() {
        return shortname5;
    }

    public void setShortname5(String shortname5) {
        this.shortname5 = shortname5;
    }

    public String getShortname6() {
        return shortname6;
    }

    public void setShortname6(String shortname6) {
        this.shortname6 = shortname6;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getVenddate() {
        return venddate;
    }

    public void setVenddate(String venddate) {
        this.venddate = venddate;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVname2() {
        return vname2;
    }

    public void setVname2(String vname2) {
        this.vname2 = vname2;
    }

    public String getVname3() {
        return vname3;
    }

    public void setVname3(String vname3) {
        this.vname3 = vname3;
    }

    public String getVname4() {
        return vname4;
    }

    public void setVname4(String vname4) {
        this.vname4 = vname4;
    }

    public String getVname5() {
        return vname5;
    }

    public void setVname5(String vname5) {
        this.vname5 = vname5;
    }

    public String getVname6() {
        return vname6;
    }

    public void setVname6(String vname6) {
        this.vname6 = vname6;
    }

    public String getVno() {
        return vno;
    }

    public void setVno(String vno) {
        this.vno = vno;
    }

    public String getVstartdate() {
        return vstartdate;
    }

    public void setVstartdate(String vstartdate) {
        this.vstartdate = vstartdate;
    }

    public String getDeptduty() {
        return deptduty;
    }

    public void setDeptduty(String deptduty) {
        this.deptduty = deptduty;
    }

    public String getPk_calat() {
        return pk_calat;
    }

    public void setPk_calat(String pk_calat) {
        this.pk_calat = pk_calat;
    }


}
