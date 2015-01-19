package com.philips.cn.hr.pps.mapper;

import com.philips.cn.hr.pps.domain.CombinedOutput;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by kvn on 1/15/15.
 */
public class CombinedOutputRowMapper implements RowMapper<CombinedOutput> {
    @Override
    public CombinedOutput mapRow(ResultSet resultSet, int i) throws SQLException {
        CombinedOutput aiOutput = new CombinedOutput();
        aiOutput.setCompanyCode(resultSet.getString(1));
        aiOutput.setCostCenter(resultSet.getString(2));
        aiOutput.setEmployeeType(resultSet.getString(3));
        aiOutput.setPersonalSubArea(resultSet.getString(4));
        aiOutput.setAnnualIncentive(resultSet.getBigDecimal(5));
        aiOutput.setHoliday(resultSet.getBigDecimal(6));
        aiOutput.setLaborUnion(resultSet.getBigDecimal(7));
        return aiOutput;
    }
}
