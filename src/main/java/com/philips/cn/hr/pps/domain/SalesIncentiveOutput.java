package com.philips.cn.hr.pps.domain;

import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;

import java.math.BigDecimal;

/**
 * Created by kvn on 2/12/15.
 */
public class SalesIncentiveOutput extends CombinedOutput{



    BigDecimal monthlySalesIncentive;

    public BigDecimal getMonthlySalesIncentive() {
        return monthlySalesIncentive;
    }

    public void setMonthlySalesIncentive(BigDecimal monthlySalesIncentive) {
        this.monthlySalesIncentive = monthlySalesIncentive;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder(super.toString());

        sb.append(DelimitedLineTokenizer.DELIMITER_COMMA).
                append(this.getMonthlySalesIncentive());

        return sb.toString();
    }
}
