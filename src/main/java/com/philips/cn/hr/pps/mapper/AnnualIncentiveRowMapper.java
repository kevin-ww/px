package com.philips.cn.hr.pps.mapper;

import com.philips.cn.hr.pps.domain.AnnualIncentiveOutput;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by kvn on 1/15/15.
 */
public class AnnualIncentiveRowMapper implements RowMapper<AnnualIncentiveOutput> {
    @Override
    public AnnualIncentiveOutput mapRow(ResultSet resultSet, int i) throws SQLException {

        AnnualIncentiveOutput aiOutput = new AnnualIncentiveOutput();
        aiOutput.setCompanyCode(resultSet.getString(1));
        aiOutput.setCostCenter(resultSet.getString(2));
        aiOutput.setEmployeeType(resultSet.getString(3));
        aiOutput.setPersonalSubArea(resultSet.getString(4));
        aiOutput.setAnnualIncentive(resultSet.getBigDecimal(5));
        return aiOutput;
    }
}
