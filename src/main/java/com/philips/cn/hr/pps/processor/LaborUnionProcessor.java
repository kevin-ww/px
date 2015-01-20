package com.philips.cn.hr.pps.processor;

import com.philips.cn.hr.pps.domain.Employee;
import org.springframework.batch.item.ItemProcessor;

import java.math.BigDecimal;

/**
 * Created by kvn on 1/14/15.
 */
public class LaborUnionProcessor implements ItemProcessor<Employee, Employee> {

//    c)	Labor Union:
//            •	Local plus grading < EL1: basic salary * 2%
//            •	Local plus grading >=EL1: fixed amount of RMB 2,800 per month, calculated by EY;
//    •	Expatriates: RMB 2,800 per month per person.
//            •	 “SI” is in the calculation scope.


    public static final BigDecimal BASIC_AMOUNT=new BigDecimal(2800.00);

    public static final BigDecimal BASIC_PERCENTAGE=new BigDecimal(0.02);

    @Override
    public Employee process(Employee emp) throws Exception {

        BigDecimal laborUnion = null;

        if (emp.isExpatriates()) {
            laborUnion = BASIC_AMOUNT;
        } else if (emp.isLocalPlus()&&(!emp.isNotLowerThanEL1())) {
            laborUnion = emp.getBaseSalary().multiply(BASIC_PERCENTAGE,HolidayProcessor.DEFAULT_MATH_CONTEXT);
        }else if(emp.isLocalPlus()&&(emp.isNotLowerThanEL1())){
            laborUnion=BASIC_AMOUNT;
        } else {
            laborUnion = emp.getBaseSalary().multiply(BASIC_PERCENTAGE,HolidayProcessor.DEFAULT_MATH_CONTEXT);
        }

        emp.setLaborUnion(laborUnion);

        return emp;

    }
}
