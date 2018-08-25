package com.ergomotions.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

    public static String PATTERN_dd_MM_yyyy = "dd/MM/yyyy";

    private static Calendar getCalendar(int year, int monthOfYear, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, monthOfYear);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        return c;
    }

    private static String getDate(int year, int monthOfYear, int dayOfMonth, String patternFormat) {
        String myDate = "";
        Calendar c = getCalendar(year, monthOfYear, dayOfMonth);
        SimpleDateFormat format1 = new SimpleDateFormat(patternFormat);
        myDate = format1.format(c.getTime());
        return myDate;
    }

    public static String getDateStringFromPicker(int year, int monthOfYear, int dayOfMonth){
        return getDate(year, monthOfYear, dayOfMonth, PATTERN_dd_MM_yyyy);
    }

}
