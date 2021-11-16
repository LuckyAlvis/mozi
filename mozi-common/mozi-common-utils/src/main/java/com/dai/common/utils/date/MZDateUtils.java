package com.dai.common.utils.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MZDateUtils {
    public static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static String DEFULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static String SHORT_DATE_FORMAT = "yyyyMMdd";
    public static String YMDHMSS = "yyyyMMddHHmmssSSS";
    public static String YMDHMS = "yyyyMMddHHmmss";
    public static String YMDH = "yyyyMMddHH";

    public static String getYYYYMMDDHHSSDate() {
        return new SimpleDateFormat(YMDHMS).format(new Date());
    }
    public static String getDate() {
        return new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(new Date());
    }
    public static Date getNow() {
        return Calendar.getInstance().getTime();
    }

    public static void main(String[] args) {
        System.out.println(getNow());
        System.out.println(new Date());
        System.out.println(getDate());
        System.out.println(getYYYYMMDDHHSSDate());
    }
}
