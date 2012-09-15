package com.sys.exam.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * <p>Title: DateStringConvertor.java</p>
 * <p>Description:  用于日期，字符串之间的相互转换</p>
 *
 * <p>Copyright: Copyright (c) 2009 by 
 * Shanghai hwellzen, Shanghai, China
 *                  All rights reserved.</p>
 * <p>Company: Hwellzen</p>
 * @author liuzj
 * @version 1.0
 * @see 
 *
 * <PRE>
 * <U>Updated by:</U>   auther, date
 * <U>Description:</U>  Update description
 * </PRE>
 */
public class DateOperator
{

    /**
      * 将日期类型，转换为字符串
      * @param date
      * @return 
      */
    public static String dateToString(Date date,String format)
    {
        SimpleDateFormat sdf = 
            new SimpleDateFormat(format);
        String s = sdf.format(date);
        return s;
    }
    /**
      * 将字符串，转换为日期
      * @param s
      * @return
      * @throws ParseException 
      */
    public static Date stringToDate(String str,String format) throws ParseException
    {
        SimpleDateFormat sdf = 
            new SimpleDateFormat(format);
        Date date = sdf.parse(str);
        return date;
    }
    /**获取指定日期时间格式的当前系统时间
     * @param format 日期时间格式
     * @return
     */
    public static String getCurrentTime(String format){
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        SimpleDateFormat sdf = 
            new SimpleDateFormat(format);
        return sdf.format(date);
    }
    
}
