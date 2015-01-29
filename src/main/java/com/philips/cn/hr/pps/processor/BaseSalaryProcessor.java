package com.philips.cn.hr.pps.processor;

import com.philips.cn.hr.pps.domain.Employee;
import org.springframework.batch.item.ItemProcessor;

import java.math.BigDecimal;

/**
 * Created by kvn on 1/29/15.
 */
public class BaseSalaryProcessor implements ItemProcessor<Employee,Employee> {

    public static final String YEARLY_PAY_WAGE_TYPE="1101";


    @Override
    public Employee process(Employee employee) throws Exception {
        if(employee.getWageType().equalsIgnoreCase(YEARLY_PAY_WAGE_TYPE)){
            BigDecimal monthlySalary = employee.getBaseSalary().divide(Employee.TWELVE_MONTH,Employee.DEFAULT_MATH_CONTEXT);
            employee.setBaseSalary(monthlySalary);
        }
        return employee;
    }
}
