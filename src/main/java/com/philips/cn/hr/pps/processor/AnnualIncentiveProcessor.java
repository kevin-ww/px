package com.philips.cn.hr.pps.processor;

import com.philips.cn.hr.pps.domain.Employee;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by kvn on 1/14/15.
 */
public class AnnualIncentiveProcessor implements ItemProcessor<Employee,Employee> {



//    a)	AI:  //is calculated in the ADP system by person level which can be used directly by PPS automation system.
//            •	Category of “ZZ01” is excluded from the AI accrual calculation.
//    •	“SI” is excluded from the AI accrual calculation.

    public static final String ZZ01 = "ZZ01";

    @Override
    public Employee process(Employee emp) throws Exception {


        if(emp.getExceptions().equalsIgnoreCase(ZZ01)||emp.isSales()){
            emp.setAnnualIncentive(Employee.ZERO);
        } else {
            emp.setAnnualIncentive(emp.getBonus());
        }

        return emp;
    }
}

