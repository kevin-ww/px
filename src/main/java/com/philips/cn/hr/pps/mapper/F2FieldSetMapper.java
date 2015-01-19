package com.philips.cn.hr.pps.mapper;

import com.philips.cn.hr.pps.domain.F2;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * Created by kvn on 1/15/15.
 */
public class F2FieldSetMapper implements FieldSetMapper<F2> {

    @Override
    public F2 mapFieldSet(FieldSet fieldSet) throws BindException {


//        String peronNum;
//        String exceptions;
//        String wageType;
//        String bonus;      //bonous; ai;
//        String currency;


        if(fieldSet == null||fieldSet.getFieldCount()<3){//check footer?
            return null;
        }

        F2 f2 = new F2();

        f2.setPeronNum(fieldSet.readString(1));
        f2.setExceptions(fieldSet.readString(2));
        f2.setWageType(fieldSet.readString(3));
        f2.setBonus(fieldSet.readString(4));
        f2.setCurrency(fieldSet.readString(5));

        return f2;
    }
}
