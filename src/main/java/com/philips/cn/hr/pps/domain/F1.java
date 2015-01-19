package com.philips.cn.hr.pps.domain;

/**
 * Created by kvn on 1/15/15.
 */
public class F1 {

//    14.01.2015                              SAP Query 14.01.2015/07:33:34 300228484                                  1
//            --------------------------------------------------------------------------------------------------------------------
//    SAP Query 14.01.2015/07:33:34 300228484
//            --------------------------------------------------------------------------------------------------------------------
//            |Pers.No.|CoCd|EEGrp|ESgrp|Cost Ctr  |       Amount|Crcy|Wage Type|Indicator for exceptions in st|Personnel Subarea|
//            --------------------------------------------------------------------------------------------------------------------
//            |28000001|CNX0|1    |14   |CNX0021050|    7,908.00 |CNY |1101     |40                            |Shanghai         |


    String peronNum;
    String companyCode;
    String eeGrp;
    String esGrp;
    String costCenter;
    String baseSalary;  //base Salary;
    String currency;
    String wageType;
    String jobGrade;
    String personalSubArea;


    public String getPeronNum() {
        return peronNum;
    }

    public void setPeronNum(String peronNum) {
        this.peronNum = peronNum;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getEeGrp() {
        return eeGrp;
    }

    public void setEeGrp(String eeGrp) {
        this.eeGrp = eeGrp;
    }

    public String getEsGrp() {
        return esGrp;
    }

    public void setEsGrp(String esGrp) {
        this.esGrp = esGrp;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getWageType() {
        return wageType;
    }

    public void setWageType(String wageType) {
        this.wageType = wageType;
    }

    public String getJobGrade() {
        return jobGrade;
    }

    public void setJobGrade(String jobGrade) {
        this.jobGrade = jobGrade;
    }

    public String getPersonalSubArea() {
        return personalSubArea;
    }

    public void setPersonalSubArea(String personalSubArea) {
        this.personalSubArea = personalSubArea;
    }

    public String getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(String baseSalary) {
        this.baseSalary = baseSalary;
    }
}
