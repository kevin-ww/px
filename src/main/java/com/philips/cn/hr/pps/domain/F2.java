package com.philips.cn.hr.pps.domain;

/**
 * Created by kvn on 1/15/15.
 */
public class F2 {
//
//    14.01.2015            SAP Query 14.01.2015/07:33:34 300228484                1
//            --------------------------------------------------------------------------------
//    SAP Query 14.01.2015/07:33:34 300228484
//            ------------------------------------------------
//            |Pers.No.|Exceptions|Wage Type|     Amount|Crcy|
//            ------------------------------------------------
//            |28000006|1001      |5910     | 22,240.92 |CNY |
//            |28000039|EL01      |5910     |      0.00 |CNY |

    String peronNum;
    String exceptions;
    String wageType;
    String bonus;      //bonous; ai;
    String currency;


    public String getPeronNum() {
        return peronNum;
    }

    public void setPeronNum(String peronNum) {
        this.peronNum = peronNum;
    }

    public String getExceptions() {
        return exceptions;
    }

    public void setExceptions(String exceptions) {
        this.exceptions = exceptions;
    }

    public String getWageType() {
        return wageType;
    }

    public void setWageType(String wageType) {
        this.wageType = wageType;
    }

    public String getCurrency() {
        return currency;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


}
