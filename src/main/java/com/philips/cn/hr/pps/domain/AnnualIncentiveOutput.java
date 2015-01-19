package com.philips.cn.hr.pps.domain;

import java.math.BigDecimal;

/**
 * Created by kvn on 1/15/15.
 */
public class AnnualIncentiveOutput extends GenericOutput {

    BigDecimal annualIncentive;

    public BigDecimal getAnnualIncentive() {
        return annualIncentive;
    }

    public void setAnnualIncentive(BigDecimal annualIncentive) {
        this.annualIncentive = annualIncentive;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getCompanyCode()).append("|").
                append(super.getCostCenter()).append("|").
                append(super.getEmployeeType()).append("|").
                append(super.getPersonalSubArea()).append("|").
                append(this.getAnnualIncentive());

        return sb.toString();
    }
}
