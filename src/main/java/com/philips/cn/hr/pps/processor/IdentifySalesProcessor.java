package com.philips.cn.hr.pps.processor;

import com.philips.cn.hr.pps.domain.Employee;
import com.philips.cn.hr.pps.domain.F2;
import com.philips.cn.hr.pps.mapper.EmployeeFieldSetMapper;
import org.springframework.batch.item.ItemProcessor;


/**
 * Created by kvn on 1/15/15.
 */
public class IdentifySalesProcessor implements ItemProcessor <F2,Employee>{

    public static final int SALES_INDICATOR = 0; //0 means sales , other not;

    @Override
    public Employee process(F2 item) throws Exception {

        Employee emp = EmployeeFieldSetMapper.convert(item);        //convert f2 to emp;

        if(isSales(item.getExceptions())){
            emp.setSalesIndicator(SALES_INDICATOR);
        }

        return emp;
    }

    public static boolean isSales(String exceptions){
        return exceptions.substring(0,2).equalsIgnoreCase("SI");
    }
}
