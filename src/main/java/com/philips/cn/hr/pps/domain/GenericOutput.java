package com.philips.cn.hr.pps.domain;

/**
 * Created by kvn on 1/15/15.
 */
public class GenericOutput {

    String companyCode;
    String costCenter;

    String employeeType;     //local hiring ,local plus, expatriates;

    String personalSubArea;

//    BigDecimal annualIncentive;
//    BigDecimal holiday;
//    BigDecimal laborUnion;




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

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getPersonalSubArea() {
        return personalSubArea;
    }

    public void setPersonalSubArea(String personalSubArea) {
        this.personalSubArea = personalSubArea;
    }
}
