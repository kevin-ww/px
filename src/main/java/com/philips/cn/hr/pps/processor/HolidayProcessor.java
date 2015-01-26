package com.philips.cn.hr.pps.processor;

import com.philips.cn.hr.pps.domain.Employee;
import org.springframework.batch.item.ItemProcessor;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by kvn on 1/14/15.
 */
public class HolidayProcessor implements ItemProcessor<Employee,Employee> {

    public static final BigDecimal P1 = new BigDecimal(6.00);

    public static final BigDecimal P2 = new BigDecimal(21.75);


//    public static final MathContext DEFAULT_MATH_CONTEXT  = new MathContext(8,RoundingMode.HALF_UP);

    @Override
    public Employee process(Employee item) throws Exception {
        BigDecimal holiday =
                item.getBaseSalary().divide(P2,Employee.DEFAULT_MATH_CONTEXT);
        holiday=holiday.multiply(P1,Employee.DEFAULT_MATH_CONTEXT);
        item.setHoliday(holiday);
        return item;
    }
}
