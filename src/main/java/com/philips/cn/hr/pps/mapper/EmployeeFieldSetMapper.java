package com.philips.cn.hr.pps.mapper;

import com.philips.cn.hr.pps.domain.Employee;
import com.philips.cn.hr.pps.domain.F1;
import com.philips.cn.hr.pps.domain.F2;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by kvn on 1/15/15.
 */
public class EmployeeFieldSetMapper implements RowMapper<Employee> {


//    String peronNum;
//    String companyCode;
//    String eeGrp;
//    String esGrp;
//    String costCenter;
//    String amount;
//    String currency;
//    String wageType;
//    String jobGrade;
//    String personalSubArea;

    public static Employee convert(F1 f1){

        Employee emp = new Employee();
        emp.setPersonNum(f1.getPeronNum());
        emp.setCompanyCode(f1.getCompanyCode());
        emp.setCostCenter(f1.getCostCenter());

        emp.setJobGrade(f1.getJobGrade());
        emp.setBaseSalary(convert(f1.getBaseSalary()));
        emp.setPersonalSubArea(f1.getPersonalSubArea());


        //
        emp.setEeGrp(f1.getEeGrp());
        emp.setEsGrp(f1.getEsGrp());

        //currency -> CNY;

        return emp;
    }



//    String peronNum;
//    String exceptions;
//    String wageType;
//    String amount;
//    String currency;

    public static Employee convert(F2 f2){
        Employee emp = new Employee();
        emp.setPersonNum(f2.getPeronNum());
        emp.setExceptions(f2.getExceptions());
        emp.setBonus(convert(f2.getBonus()));
        return emp;
    }


    //    7,908.00->7908.00
    public static BigDecimal convert(String baseSalary){
        String amt = baseSalary.replaceAll(",","");
        return new BigDecimal(amt);
    }


    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

//        INSERT INTO employee
//                (personNum,companyCode,costCenter,jobGrade,currency,
//                        exceptions,salesIndicator,employeeType,annualIncentive,holiday,laborUnion,personalSubArea)

        Employee employee = new Employee();
        employee.setPersonNum(rs.getString(1));
        employee.setCompanyCode(rs.getString(2));
        employee.setCostCenter(rs.getString(3));
        employee.setJobGrade(rs.getString(4));
        employee.setCurrency(rs.getString(5));
        employee.setExceptions(rs.getString(6));
        employee.setSalesIndicator(rs.getInt(7));
        employee.setEmployeeType(rs.getString(8));
        employee.setAnnualIncentive(rs.getBigDecimal(9));
        employee.setHoliday(rs.getBigDecimal(10));
        employee.setLaborUnion(rs.getBigDecimal(11));
        employee.setPersonalSubArea(rs.getString(12));
        return employee;
    }
}
