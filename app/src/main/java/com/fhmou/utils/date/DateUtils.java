package com.fhmou.utils.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * package com.fhmou.utils.date
 * functional describe:
 *
 * @version 1.0 16-9-1 上午11:36
 * @auther luyanliang [765673481@qq.com]
 */
public class DateUtils {

    public static final String FORMAT_DATE_CN = "yyyy年MM月dd日";
    public static final String FORMAT_DATE_Md = "MM/dd";
    public static final String FORMAT_DATE_Md_2 = "MM-dd";
    public static final String FORMAT_DATE_yyMMdd = "yy/MM/dd";
    public static final String FORMAT_DATE_yyyyMMdd = "yyyy-MM-dd";
    public static final String FORMAT_DATE_yyyyMMdd2 = "yyyy/MM/dd";
    public static final String FORMAT_DATE_yyyyMMdd3 = "yyyyMMdd";
    private static String FORMAT_DEFAULT = "yyyy年MM月dd日 HH时mm分ss秒";
    public static final String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String FORMAT_FULL_CN = "yyyy年MM月dd日 HH时mm分ss秒SSS毫秒";
    public static final String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_SHORT = "yyyy-MM-dd HH:mm";
    public static final String FORMAT_SHORT2 = "yyyy/MM/dd HH:mm";
    public static final String FORMAT_SHORT_CN = "yyyy年MM月dd日 HH时mm分";
    public static final String FORMAT_SHORT_MdHm = "MM/dd HH:mm";
    public static final String FORMAT_TIME_CN = "HH时mm分ss秒";
    public static final String FORMAT_TIME_Hm = "HH:mm";
    public static final String FORMAT_TIME_Hms = "HH:mm:ss";
    private static final String[] WEEKDAY = { "星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
    private static final String[] WEEKDAY_2 = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };

    public static Date addDay(Date date, int num)
    {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime(date);
        localCalendar.add(Calendar.DAY_OF_MONTH, num);
        return localCalendar.getTime();
    }

    public static String format(long time)
    {
        return format(new Date(time));
    }

    public static String format(long paramLong, String paramString)
    {
        return format(new Date(paramLong), paramString);
    }

    public static String format(long paramLong, String paramString, Locale paramLocale)
    {
        return format(new Date(paramLong), paramString, paramLocale);
    }

    public static String format(Date paramDate)
    {
        return format(paramDate, FORMAT_DEFAULT);
    }

    public static String format(Date paramDate, String paramString)
    {
        return format(paramDate, paramString, Locale.CHINA);
    }

    public static String format(Date paramDate, String paramString, Locale paramLocale)
    {
        return new SimpleDateFormat(paramString, paramLocale).format(paramDate);
    }
}
