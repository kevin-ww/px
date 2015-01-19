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


    @Override
    public Employee process(Employee emp) throws Exception {

        BigDecimal laborUnion = null;

        if (emp.isExpatriates()) {
            laborUnion = new BigDecimal(2800);
        } else if (emp.isLocalPlus()&&emp.isLowerThanEL1()) {
            laborUnion = emp.getBaseSalary().multiply(new BigDecimal(0.2));
        }else if(emp.isLocalPlus()&&(!emp.isLowerThanEL1())){
            laborUnion=new BigDecimal(2800);
        } else {
            laborUnion = emp.getBaseSalary().multiply(new BigDecimal(0.2));
        }

        emp.setLaborUnion(laborUnion);

        return emp;

    }
}
