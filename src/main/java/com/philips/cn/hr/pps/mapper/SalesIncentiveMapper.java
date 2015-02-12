package com.philips.cn.hr.pps.mapper;

import com.philips.cn.hr.pps.domain.CombinedOutput;
import com.philips.cn.hr.pps.domain.SalesIncentiveOutput;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by kvn on 2/12/15.
 */
public class SalesIncentiveMapper implements RowMapper<SalesIncentiveOutput> {


    @Override
    public SalesIncentiveOutput mapRow(ResultSet resultSet, int i) throws SQLException {
        SalesIncentiveOutput siOutput = new SalesIncentiveOutput();
        siOutput.setCompanyCode(resultSet.getString(1));
        siOutput.setCostCenter(resultSet.getString(2));
        siOutput.setEmployeeType(resultSet.getString(3));
        siOutput.setPersonalSubArea(resultSet.getString(4));
        siOutput.setAnnualIncentive(resultSet.getBigDecimal(5));
        siOutput.setHoliday(resultSet.getBigDecimal(6));
        siOutput.setLaborUnion(resultSet.getBigDecimal(7));
        siOutput.setMonthlySalesIncentive(resultSet.getBigDecimal(8));
        return siOutput;
    }
}
