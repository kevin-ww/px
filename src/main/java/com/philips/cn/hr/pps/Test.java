package com.philips.cn.hr.pps;

import com.philips.cn.hr.pps.domain.Employee;
import com.philips.cn.hr.pps.mapper.EmployeeFieldSetMapper;
import com.philips.cn.hr.pps.processor.HolidayProcessor;
import com.philips.cn.hr.pps.processor.LaborUnionProcessor;

import java.math.BigDecimal;

/**
 * Created by kevin on 2015/1/20.
 */
public class Test {

    public static void main(String[] args) throws  Exception{

        String x = "2,211,000.00";
        BigDecimal y = EmployeeFieldSetMapper.convert(x);

        System.out.println(y);

        Employee item = new Employee();
        item.setBaseSalary(y);

//        com.philips.cn.hr.pps.processor.HolidayProcessor holidayProcessor = new HolidayProcessor();
//        holidayProcessor.process(item);

        item.setEmployeeType("LP");
        item.setJobGrade("EXCO");

        new LaborUnionProcessor().process(item);


        System.out.println(item.getLaborUnion());


//        BigDecimal.valueOf()
//        BigDecimal bc =
//                new BigDecimal(x.replaceAll(","));

    }
}
