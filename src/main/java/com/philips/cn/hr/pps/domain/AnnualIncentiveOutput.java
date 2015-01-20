package com.philips.cn.hr.pps.domain;

import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;

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
        sb.append(super.getCompanyCode()).append(DelimitedLineTokenizer.DELIMITER_COMMA).
                append(super.getCostCenter()).append(DelimitedLineTokenizer.DELIMITER_COMMA).
                append(super.getEmployeeType()).append(DelimitedLineTokenizer.DELIMITER_COMMA).
                append(super.getPersonalSubArea()).append(DelimitedLineTokenizer.DELIMITER_COMMA).
                append(this.getAnnualIncentive());

        return sb.toString();
    }
}
