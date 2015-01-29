package com.philips.cn.hr.pps.domain;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by kvn on 1/15/15.
 */
public class Employee {


    public static final String LOCAL_HIRING="LH";
    public static final String LOCAL_PLUS="LP";
    public static final String EXPATRIATES="I"; //Expatriates的判断逻辑改成 EEgrp = I

    public static final BigDecimal ZERO= new BigDecimal(0);

    public static final MathContext DEFAULT_MATH_CONTEXT  = new MathContext(8, RoundingMode.HALF_UP);


    public static final String EXECUTIVE_LEVEL_PREFIX="EL";

    public static final String EXECUTIVE_LEVEL_PREFIX_X="EX";

    public static final BigDecimal TWELVE_MONTH=new BigDecimal(12);




    String personNum;
    String companyCode;
    String costCenter;
    String jobGrade;
    BigDecimal baseSalary;
    BigDecimal bonus;
    String currency;
    String exceptions;  //ZZ01 no need to calculate AI


    int salesIndicator = 1;  // 0  means sales; others not;
    String employeeType;     //local hiring ,local plus, expatriates;

    //
    String eeGrp;
    String esGrp;



    String wageType;

    public String getWageType() {
        return wageType;
    }

    public void setWageType(String wageType) {
        this.wageType = wageType;
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
    //

    BigDecimal annualIncentive=ZERO;
    BigDecimal holiday=ZERO;
    BigDecimal laborUnion=ZERO;

    String personalSubArea;

    //

    public boolean isLowerThanEL1(){

        //EL1; not in use,

        String jg = this.jobGrade;
        if(jg.equals("40")||jg.equals("50")||jg.equals("60")||jg.equals("70")||jg.equals("80")||jg.equals("90")){
            return true;
        }
        return false;

    }

    public boolean isNotLowerThanEL1(){
        //EL1; executive level 1;
        //EXCO;
        String jg = this.jobGrade.substring(0,2).toUpperCase();
        return jg.equals(EXECUTIVE_LEVEL_PREFIX)||jg.equals(EXECUTIVE_LEVEL_PREFIX_X);
    }

    public boolean isLocalHiring(){
        return this.employeeType.equalsIgnoreCase(LOCAL_HIRING);
    }

    public boolean isLocalPlus(){
        return this.employeeType.equalsIgnoreCase(LOCAL_PLUS);
    }

    public boolean isExpatriates(){
        return this.employeeType.equalsIgnoreCase(EXPATRIATES);
    }

    public boolean isSales(){//sales;
        return this.getSalesIndicator()==0;
    }

    ///


    public String getPersonalSubArea() {
        return personalSubArea;
    }

    public void setPersonalSubArea(String personalSubArea) {
        this.personalSubArea = personalSubArea;
    }

    public String getPersonNum() {
        return personNum;
    }

    public void setPersonNum(String personNum) {
        this.personNum = personNum;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public String getJobGrade() {
        return jobGrade;
    }

    public void setJobGrade(String jobGrade) {
        this.jobGrade = jobGrade;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getSalesIndicator() {
        return salesIndicator;
    }

    public void setSalesIndicator(int salesIndicator) {
        this.salesIndicator = salesIndicator;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public BigDecimal getAnnualIncentive() {
        return annualIncentive;
    }

    public void setAnnualIncentive(BigDecimal annualIncentive) {
        this.annualIncentive = annualIncentive;
    }

    public BigDecimal getHoliday() {
        return holiday;
    }

    public void setHoliday(BigDecimal holiday) {
        this.holiday = holiday;
    }

    public BigDecimal getLaborUnion() {
        return laborUnion;
    }

    public void setLaborUnion(BigDecimal laborUnion) {
        this.laborUnion = laborUnion;
    }


    public String getExceptions() {
        return exceptions;
    }

    public void setExceptions(String exceptions) {
        this.exceptions = exceptions;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "personNum='" + personNum + '\'' +
                ", companyCode='" + companyCode + '\'' +
                ", costCenter='" + costCenter + '\'' +
                ", jobGrade='" + jobGrade + '\'' +
                ", baseSalary=" + baseSalary +
                ", bonus=" + bonus +
                ", currency='" + currency + '\'' +
                ", exceptions='" + exceptions + '\'' +
                ", salesIndicator=" + salesIndicator +
                ", employeeType='" + employeeType + '\'' +
                ", annualIncentive=" + annualIncentive +
                ", holiday=" + holiday +
                ", laborUnion=" + laborUnion +
                ", personalSubArea='" + personalSubArea + '\'' +
                '}';
    }
}
