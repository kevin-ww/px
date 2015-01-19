package com.philips.cn.hr.pps.processor;

import com.philips.cn.hr.pps.domain.Employee;
import com.philips.cn.hr.pps.domain.F1;
import com.philips.cn.hr.pps.mapper.EmployeeFieldSetMapper;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by kvn on 1/15/15.
 */
public class EmployeeTypeProcessor implements ItemProcessor<F1,Employee> {

//    public static final String LOCAL_HIRING="LH";
//    public static final String LOCAL_PLUS="LP";
//    public static final String EXPATRIATES="EXP";


    @Override
    public Employee process(F1 item) throws Exception {

        Employee emp = EmployeeFieldSetMapper.convert(item);    //convert f1 to employee;

        if(isExpatriates(item.getEeGrp())){
            emp.setEmployeeType(Employee.EXPATRIATES);
        } else if(isLocalPlus(item.getEsGrp())){
            emp.setEmployeeType(Employee.LOCAL_PLUS);
        } else
            emp.setEmployeeType(Employee.LOCAL_HIRING);

        return emp;
    }

    private static boolean isExpatriates(String eeGrp){
        return eeGrp.equalsIgnoreCase(Employee.EXPATRIATES);
    }

    public static boolean isLocalPlus(String esGrp){
        return esGrp.equalsIgnoreCase("1B")||esGrp.equalsIgnoreCase("1G")||esGrp.equalsIgnoreCase("1I");
    }
}
