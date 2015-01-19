package com.philips.cn.hr.pps.processor;

import com.philips.cn.hr.pps.domain.Employee;
import org.springframework.batch.item.ItemProcessor;

import java.math.BigDecimal;

/**
 * Created by kvn on 1/14/15.
 */
public class HolidayProcessor implements ItemProcessor<Employee,Employee> {

    public static final BigDecimal P1 = new BigDecimal(6);

    public static final BigDecimal P2 = new BigDecimal(21.75);

    @Override
    public Employee process(Employee item) throws Exception {
        BigDecimal holiday = item.getBaseSalary().multiply(P1).divideToIntegralValue(P2);
        item.setHoliday(holiday);
        return item;
    }
}
