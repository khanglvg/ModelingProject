package com.cauvong.softwarearchitecture.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


/**
 * Created by ijuin on 12/4/2017.
 */

public class MyUtils {
    public static String convertTime(long timestamp) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("HH:mm");
        Date date = new Date(timestamp);
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(date);
    }
}
