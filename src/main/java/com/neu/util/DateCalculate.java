package com.neu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCalculate {

    /**
     * calculate how many month between date1 and date2
     * @param date1: the begin date
     * @param date2: the end date
     * @return the number of month between date1 and date2
     * @throws ParseException
     */
    public static int calculatedMonth(String date1, String date2)
            throws ParseException {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(DateCalculate.stringToDate(date1));
        c2.setTime(DateCalculate.stringToDate(date2));
        int result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        int year = (c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR)) * 12;
        return Math.abs(result + year);
    }

    /**
     * increase the month of date
     * @param date: the initial date
     * @return the date after increase
     */
    public static String increaseMonth(String date) {
        try {
            Calendar ct = Calendar.getInstance();
            ct.setTime(DateCalculate.stringToDate(date));
            ct.add(Calendar.MONTH, +1);
            return DateCalculate.dateToString(ct.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     * change the string type into date type
     * @param string: the string type
     * @return the date type
     * @throws ParseException
     */
    public static Date stringToDate(String string) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        Date date = simpleDateFormat.parse(string);
        return date;
    }

    /**
     * change the date type into string type
     * @param date:the date type
     * @return the string type
     */
    public static String dateToString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        String string = simpleDateFormat.format(date);
        return string;
    }
}
