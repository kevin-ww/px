package com.philips.cn.hr.pps.mapper;

import com.philips.cn.hr.pps.domain.F1;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * Created by kvn on 1/15/15.
 */
public class F1FieldSetMapper implements FieldSetMapper<F1> {
    @Override
    public F1 mapFieldSet(FieldSet fieldSet) throws BindException {


//        String peronNum;
//        String companyCode;
//        String eeGrp;
//        String esGrp;
//        String costCenter;
//        String baseSalary;  //base Salary;
//        String currency;
//        String wageType;
//        String jobGrade;
//        String personalSubArea;


        if(fieldSet == null||fieldSet.getFieldCount()<3){//check footer?
            //TODO , need check the input file format;
            return null;
        }

        F1 f1 = new F1();

        f1.setPeronNum(fieldSet.readString(1).trim());
        f1.setCompanyCode(fieldSet.readString(2).trim());
        f1.setEeGrp(fieldSet.readString(3).trim());
        f1.setEsGrp(fieldSet.readString(4).trim());
        f1.setCostCenter(fieldSet.readString(5).trim());
        f1.setBaseSalary(fieldSet.readString(6).trim());
        f1.setCurrency(fieldSet.readString(7).trim());
        f1.setWageType(fieldSet.readString(8).trim());
        f1.setJobGrade(fieldSet.readString(9).trim());
        f1.setPersonalSubArea(fieldSet.readString(10).trim());

        return f1;
    }

    public static boolean isFooterLine(FieldSet fieldSet){
        return fieldSet.getFieldCount()==1;
    }

}
