package com.hit.cost.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * =========================
 *如何要使用JPA的自定义查询，那就必须在@Entity中映射name属性
 * @Author:fealty
 * @Description:
 * @Date：2018/7/29 20:57
 * <p>
 * Created By IDEA
 * ==========================
 */
@Entity(name = "org_orgs")
@Table(name = "org_orgs")
public class Org {

    /**
     * ADDRESS : ~
     * CODE : 1250016
     * COUNTRYZONE : ~
     * CREATIONTIME : 2017-12-19 10:51:23
     * CREATOR : 1001F51000000003QKWU
     * DATAORIGINFLAG : 0
     * DEF1 : ~
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
     * DEF2 : ~
     * DEF20 : ~
     * DEF3 : ~
     * DEF4 : ~
     * DEF5 : ~
     * DEF6 : ~
     * DEF7 : ~
     * DEF8 : ~
     * DEF9 : ~
     * DR : 0
     * ENABLESTATE : 2
     * ENTITYTYPE : ~
     * INNERCODE : G5GLFPDS
     * ISBUSINESSUNIT : N
     * ISLASTVERSION : Y
     * ISRETAIL : null
     * MEMO : null
     * MNECODE : null
     * MODIFIEDTIME : 2017-12-19 10:56:48
     * MODIFIER : 1001F51000000003QKWU
     * NAME : 特需泌尿外科门诊1
     * NAME2 : null
     * NAME3 : null
     * NAME4 : null
     * NAME5 : null
     * NAME6 : null
     * NCINDUSTRY : ~
     * ORGANIZATIONCODE : null
     * ORGTYPE1 : N
     * ORGTYPE10 : N
     * ORGTYPE11 : N
     * ORGTYPE12 : N
     * ORGTYPE13 : Y
     * ORGTYPE14 : N
     * ORGTYPE15 : N
     * ORGTYPE16 : N
     * ORGTYPE17 : N
     * ORGTYPE18 : N
     * ORGTYPE19 : N
     * ORGTYPE2 : N
     * ORGTYPE20 : N
     * ORGTYPE21 : N
     * ORGTYPE22 : N
     * ORGTYPE23 : N
     * ORGTYPE24 : N
     * ORGTYPE25 : N
     * ORGTYPE26 : N
     * ORGTYPE27 : N
     * ORGTYPE28 : N
     * ORGTYPE29 : N
     * ORGTYPE3 : Y
     * ORGTYPE30 : N
     * ORGTYPE31 : N
     * ORGTYPE32 : N
     * ORGTYPE33 : N
     * ORGTYPE34 : N
     * ORGTYPE35 : N
     * ORGTYPE36 : N
     * ORGTYPE37 : N
     * ORGTYPE38 : N
     * ORGTYPE39 : N
     * ORGTYPE4 : N
     * ORGTYPE40 : N
     * ORGTYPE5 : N
     * ORGTYPE6 : N
     * ORGTYPE7 : N
     * ORGTYPE8 : N
     * ORGTYPE9 : N
     * PK_ACCPERIODSCHEME : ~
     * PK_CONTROLAREA : ~
     * PK_CORP : 0001F510000000002EX7
     * PK_CURRTYPE : ~
     * PK_EXRATESCHEME : ~
     * PK_FATHERORG : 1001F51000000003RF6J
     * PK_FORMAT : ~
     * PK_GROUP : 0001F510000000000FIZ
     * PK_ORG : 1001F51000000003RCF4
     * PK_TIMEZONE : ~
     * PK_VID : 0001F5100000000047B0
     * PRINCIPAL : ~
     * REPORTCONFIRM : null
     * SHORTNAME : null
     * SHORTNAME2 : null
     * SHORTNAME3 : null
     * SHORTNAME4 : null
     * SHORTNAME5 : null
     * SHORTNAME6 : null
     * TEL : null
     * TS : 2017-12-19 10:56:48
     * VENDDATE : 9999-12-31 23:59:59
     * VNAME : 初始版本
     * VNAME2 : null
     * VNAME3 : null
     * VNAME4 : null
     * VNAME5 : null
     * VNAME6 : null
     * VNO : 201701
     * VSTARTDATE : 2017-12-19 10:51:23
     * WORKCALENDAR : ~
     * UHRPCO : null
     * SYNCLOUD : null
     */

    private String address;
    private String code;
    private String countryzone;
    private String creationtime;
    private String creator;
    private Integer dataoriginflag;
    private Integer dr;
    private Integer enablestate;
    private String entitytype;
    private String innercode;
    private String isbusinessunit;
    private String islastversion;
    private String isretail;
    private String memo;
    private String mnecode;
    private String modifiedtime;
    private String modifier;
    private String name;
    private String name2;
    private String name3;
    private String name4;
    private String name5;
    private String name6;
    private String ncindustry;
    private String organizationcode;
    private String orgtype1;
    private String orgtype10;
    private String orgtype11;
    private String orgtype12;
    private String orgtype13;
    private String orgtype14;
    private String orgtype15;
    private String orgtype16;
    private String orgtype17;
    private String orgtype18;
    private String orgtype19;
    private String orgtype2;
    private String orgtype20;
    private String orgtype21;
    private String orgtype22;
    private String orgtype23;
    private String orgtype24;
    private String orgtype25;
    private String orgtype26;
    private String orgtype27;
    private String orgtype28;
    private String orgtype29;
    private String orgtype3;
    private String orgtype30;
    private String orgtype31;
    private String orgtype32;
    private String orgtype33;
    private String orgtype34;
    private String orgtype35;
    private String orgtype36;
    private String orgtype37;
    private String orgtype38;
    private String orgtype39;
    private String orgtype4;
    private String orgtype40;
    private String orgtype5;
    private String orgtype6;
    private String orgtype7;
    private String orgtype8;
    private String orgtype9;
    private String pk_accperiodscheme;
    private String pk_controlarea;
    private String pk_corp;
    private String pk_currtype;
    private String pk_exratescheme;
    private String pk_fatherorg;
    private String pk_format;
    private String pk_group;
    @Id
    private String pk_org;
    private String pk_timezone;
    private String pk_vid;
    private String principal;
    private String reportconfirm;
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
    private String workcalendar;
    private String uhrpco;
    private String syncloud;

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

    public String getCountryzone() {
        return countryzone;
    }

    public void setCountryzone(String countryzone) {
        this.countryzone = countryzone;
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

    public Integer getDataoriginflag() {
        return dataoriginflag;
    }

    public void setDataoriginflag(Integer dataoriginflag) {
        this.dataoriginflag = dataoriginflag;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

    public Integer getEnablestate() {
        return enablestate;
    }

    public void setEnablestate(Integer enablestate) {
        this.enablestate = enablestate;
    }

    public String getEntitytype() {
        return entitytype;
    }

    public void setEntitytype(String entitytype) {
        this.entitytype = entitytype;
    }

    public String getInnercode() {
        return innercode;
    }

    public void setInnercode(String innercode) {
        this.innercode = innercode;
    }

    public String getIsbusinessunit() {
        return isbusinessunit;
    }

    public void setIsbusinessunit(String isbusinessunit) {
        this.isbusinessunit = isbusinessunit;
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

    public String getNcindustry() {
        return ncindustry;
    }

    public void setNcindustry(String ncindustry) {
        this.ncindustry = ncindustry;
    }

    public String getOrganizationcode() {
        return organizationcode;
    }

    public void setOrganizationcode(String organizationcode) {
        this.organizationcode = organizationcode;
    }

    public String getOrgtype1() {
        return orgtype1;
    }

    public void setOrgtype1(String orgtype1) {
        this.orgtype1 = orgtype1;
    }

    public String getOrgtype10() {
        return orgtype10;
    }

    public void setOrgtype10(String orgtype10) {
        this.orgtype10 = orgtype10;
    }

    public String getOrgtype11() {
        return orgtype11;
    }

    public void setOrgtype11(String orgtype11) {
        this.orgtype11 = orgtype11;
    }

    public String getOrgtype12() {
        return orgtype12;
    }

    public void setOrgtype12(String orgtype12) {
        this.orgtype12 = orgtype12;
    }

    public String getOrgtype13() {
        return orgtype13;
    }

    public void setOrgtype13(String orgtype13) {
        this.orgtype13 = orgtype13;
    }

    public String getOrgtype14() {
        return orgtype14;
    }

    public void setOrgtype14(String orgtype14) {
        this.orgtype14 = orgtype14;
    }

    public String getOrgtype15() {
        return orgtype15;
    }

    public void setOrgtype15(String orgtype15) {
        this.orgtype15 = orgtype15;
    }

    public String getOrgtype16() {
        return orgtype16;
    }

    public void setOrgtype16(String orgtype16) {
        this.orgtype16 = orgtype16;
    }

    public String getOrgtype17() {
        return orgtype17;
    }

    public void setOrgtype17(String orgtype17) {
        this.orgtype17 = orgtype17;
    }

    public String getOrgtype18() {
        return orgtype18;
    }

    public void setOrgtype18(String orgtype18) {
        this.orgtype18 = orgtype18;
    }

    public String getOrgtype19() {
        return orgtype19;
    }

    public void setOrgtype19(String orgtype19) {
        this.orgtype19 = orgtype19;
    }

    public String getOrgtype2() {
        return orgtype2;
    }

    public void setOrgtype2(String orgtype2) {
        this.orgtype2 = orgtype2;
    }

    public String getOrgtype20() {
        return orgtype20;
    }

    public void setOrgtype20(String orgtype20) {
        this.orgtype20 = orgtype20;
    }

    public String getOrgtype21() {
        return orgtype21;
    }

    public void setOrgtype21(String orgtype21) {
        this.orgtype21 = orgtype21;
    }

    public String getOrgtype22() {
        return orgtype22;
    }

    public void setOrgtype22(String orgtype22) {
        this.orgtype22 = orgtype22;
    }

    public String getOrgtype23() {
        return orgtype23;
    }

    public void setOrgtype23(String orgtype23) {
        this.orgtype23 = orgtype23;
    }

    public String getOrgtype24() {
        return orgtype24;
    }

    public void setOrgtype24(String orgtype24) {
        this.orgtype24 = orgtype24;
    }

    public String getOrgtype25() {
        return orgtype25;
    }

    public void setOrgtype25(String orgtype25) {
        this.orgtype25 = orgtype25;
    }

    public String getOrgtype26() {
        return orgtype26;
    }

    public void setOrgtype26(String orgtype26) {
        this.orgtype26 = orgtype26;
    }

    public String getOrgtype27() {
        return orgtype27;
    }

    public void setOrgtype27(String orgtype27) {
        this.orgtype27 = orgtype27;
    }

    public String getOrgtype28() {
        return orgtype28;
    }

    public void setOrgtype28(String orgtype28) {
        this.orgtype28 = orgtype28;
    }

    public String getOrgtype29() {
        return orgtype29;
    }

    public void setOrgtype29(String orgtype29) {
        this.orgtype29 = orgtype29;
    }

    public String getOrgtype3() {
        return orgtype3;
    }

    public void setOrgtype3(String orgtype3) {
        this.orgtype3 = orgtype3;
    }

    public String getOrgtype30() {
        return orgtype30;
    }

    public void setOrgtype30(String orgtype30) {
        this.orgtype30 = orgtype30;
    }

    public String getOrgtype31() {
        return orgtype31;
    }

    public void setOrgtype31(String orgtype31) {
        this.orgtype31 = orgtype31;
    }

    public String getOrgtype32() {
        return orgtype32;
    }

    public void setOrgtype32(String orgtype32) {
        this.orgtype32 = orgtype32;
    }

    public String getOrgtype33() {
        return orgtype33;
    }

    public void setOrgtype33(String orgtype33) {
        this.orgtype33 = orgtype33;
    }

    public String getOrgtype34() {
        return orgtype34;
    }

    public void setOrgtype34(String orgtype34) {
        this.orgtype34 = orgtype34;
    }

    public String getOrgtype35() {
        return orgtype35;
    }

    public void setOrgtype35(String orgtype35) {
        this.orgtype35 = orgtype35;
    }

    public String getOrgtype36() {
        return orgtype36;
    }

    public void setOrgtype36(String orgtype36) {
        this.orgtype36 = orgtype36;
    }

    public String getOrgtype37() {
        return orgtype37;
    }

    public void setOrgtype37(String orgtype37) {
        this.orgtype37 = orgtype37;
    }

    public String getOrgtype38() {
        return orgtype38;
    }

    public void setOrgtype38(String orgtype38) {
        this.orgtype38 = orgtype38;
    }

    public String getOrgtype39() {
        return orgtype39;
    }

    public void setOrgtype39(String orgtype39) {
        this.orgtype39 = orgtype39;
    }

    public String getOrgtype4() {
        return orgtype4;
    }

    public void setOrgtype4(String orgtype4) {
        this.orgtype4 = orgtype4;
    }

    public String getOrgtype40() {
        return orgtype40;
    }

    public void setOrgtype40(String orgtype40) {
        this.orgtype40 = orgtype40;
    }

    public String getOrgtype5() {
        return orgtype5;
    }

    public void setOrgtype5(String orgtype5) {
        this.orgtype5 = orgtype5;
    }

    public String getOrgtype6() {
        return orgtype6;
    }

    public void setOrgtype6(String orgtype6) {
        this.orgtype6 = orgtype6;
    }

    public String getOrgtype7() {
        return orgtype7;
    }

    public void setOrgtype7(String orgtype7) {
        this.orgtype7 = orgtype7;
    }

    public String getOrgtype8() {
        return orgtype8;
    }

    public void setOrgtype8(String orgtype8) {
        this.orgtype8 = orgtype8;
    }

    public String getOrgtype9() {
        return orgtype9;
    }

    public void setOrgtype9(String orgtype9) {
        this.orgtype9 = orgtype9;
    }

    public String getPk_accperiodscheme() {
        return pk_accperiodscheme;
    }

    public void setPk_accperiodscheme(String pk_accperiodscheme) {
        this.pk_accperiodscheme = pk_accperiodscheme;
    }

    public String getPk_controlarea() {
        return pk_controlarea;
    }

    public void setPk_controlarea(String pk_controlarea) {
        this.pk_controlarea = pk_controlarea;
    }

    public String getPk_corp() {
        return pk_corp;
    }

    public void setPk_corp(String pk_corp) {
        this.pk_corp = pk_corp;
    }

    public String getPk_currtype() {
        return pk_currtype;
    }

    public void setPk_currtype(String pk_currtype) {
        this.pk_currtype = pk_currtype;
    }

    public String getPk_exratescheme() {
        return pk_exratescheme;
    }

    public void setPk_exratescheme(String pk_exratescheme) {
        this.pk_exratescheme = pk_exratescheme;
    }

    public String getPk_fatherorg() {
        return pk_fatherorg;
    }

    public void setPk_fatherorg(String pk_fatherorg) {
        this.pk_fatherorg = pk_fatherorg;
    }

    public String getPk_format() {
        return pk_format;
    }

    public void setPk_format(String pk_format) {
        this.pk_format = pk_format;
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

    public String getPk_timezone() {
        return pk_timezone;
    }

    public void setPk_timezone(String pk_timezone) {
        this.pk_timezone = pk_timezone;
    }

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

    public String getReportconfirm() {
        return reportconfirm;
    }

    public void setReportconfirm(String reportconfirm) {
        this.reportconfirm = reportconfirm;
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

    public String getWorkcalendar() {
        return workcalendar;
    }

    public void setWorkcalendar(String workcalendar) {
        this.workcalendar = workcalendar;
    }

    public String getUhrpco() {
        return uhrpco;
    }

    public void setUhrpco(String uhrpco) {
        this.uhrpco = uhrpco;
    }

    public String getSyncloud() {
        return syncloud;
    }

    public void setSyncloud(String syncloud) {
        this.syncloud = syncloud;
    }
}
