package com.philips.cn.hr.pps.domain;

import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;

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
        sb.append(super.getCompanyCode()).append(DelimitedLineTokenizer.DELIMITER_COMMA).
                append(super.getCostCenter()).append(DelimitedLineTokenizer.DELIMITER_COMMA).
//                append(super.getEmployeeType()).append("|").
                append(super.getPersonalSubArea()).append(DelimitedLineTokenizer.DELIMITER_COMMA).
                append(this.getAnnualIncentive()).append(DelimitedLineTokenizer.DELIMITER_COMMA).
                append(this.getHoliday()).append(DelimitedLineTokenizer.DELIMITER_COMMA).
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
