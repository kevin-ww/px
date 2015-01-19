package com.philips.cn.hr.pps.domain;

import java.math.BigDecimal;

/**
 * Created by kvn on 1/15/15.
 */
public class CombinedOutput extends GenericOutput{

    BigDecimal annualIncentive;

    BigDecimal holiday;

    BigDecimal laborUnion;


    @Override
    public String toString() {

        //TODO ,
        StringBuilder sb = new StringBuilder();
        sb.append(super.getCompanyCode()).append("|").
                append(super.getCostCenter()).append("|").
//                append(super.getEmployeeType()).append("|").
                append(super.getPersonalSubArea()).append("|").
                append(this.getAnnualIncentive()).append("|").
                append(this.getHoliday()).append("|").
                append(this.getLaborUnion());

        return sb.toString();
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
}
