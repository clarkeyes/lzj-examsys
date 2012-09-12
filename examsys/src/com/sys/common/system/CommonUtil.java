/**
 * <p>Title: CommonUtil</p>
 * <p>Description: 此类提供基本的工具方法</p>
 *
 * <p>Copyright: Copyright (c) 2007 by 
 * Shanghai hwellzen, Shanghai, China
 *                  All rights reserved.</p>
 * <p>Company: Hwellzen</p>
 * @author Ling Liangjun
 * @version 1.0
 *
 * <PRE>
 * <U>Updated by:</U>
 * <U>Description:</U>
 * </PRE>
 */
package com.sys.common.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sys.common.logtool.LoggerTool;

public class CommonUtil
{
	/** 调试标识 */
	public static boolean isDebug = false;

	/** ip正则表达式 */
	public static final String IP_REGEX = "(\\d{1,3}).(\\d{1,3}).(\\d{1,3}).(\\d{1,3})";

	public static final String TIME_FORMAT = "yyyy/MM/dd HH:mm:ss,SSS";
	public static final String DATE_FORMAT = "yyyy/MM/dd";
	public static final int pageSize = 20;
	public static final int pNum=40;//批量插入单位数目
	private static CommonUtil su = new CommonUtil();

	/**
	 * float类型转换为指定单位
	 * 
	 * @param 源数据，单位
	 * @return
	 */
	public static float parseFloatToUnit(float src, int unit)
	{
		return src * unit;
	}

	/**
	 * long类型转换为指定单位
	 * 
	 * @param 源数据，单位
	 * @return
	 */
	public static Long parseLongToUnit(Long src, int unit)
	{
		return src / unit;
	}

	/**
	 * 把byte转换成gb
	 * 
	 * @param b
	 * @return gb
	 */
	public static float parseGb(Long b)
	{
		float gb = b / (1024 * 1024 * 1024);
		return gb;
	}

	/**
	 * 把byte转换成mb
	 * 
	 * @param b
	 * @return mb
	 */
	public static float parseMb(Long b)
	{
		float mb = b / (1024 * 1024);
		return mb;
	}

	/**
	 * 把byte转换成kb
	 * 
	 * @param b
	 * @return kb
	 */
	public static float parseKb(Long b)
	{
		float kb = b / (1024);
		return kb;
	}

	/** 取value小数点后n位 */
	public static double cut(double value, int n)
	{
		if (n < 0)
		{
			return value;
		}
		value = Math.round((value * (Math.pow(10, n))));// 四舍五入取整数（Long）
		value = value / (Math.pow(10, n));
		return value;
	}

	/**
	 * 调试的时候打印调试信息
	 * 
	 * @param strTrace_
	 *            具体的调试信息
	 */
	public static void traceln(String strTrace_)
	{
		LoggerTool.m_logger.info(strTrace_);
	}

	/**
	 * 
	 * 关于方法的描述：获得当前系统时间
	 * 
	 * @param format
	 *            时间的格式 为"yyyy/MM/dd HH:mm:ss,SSS"
	 * @return 时间字符串
	 */
	public static String getCurrentTime()
	{

		SimpleDateFormat ft = null;
		Date date = new Date();
		ft = new SimpleDateFormat(TIME_FORMAT);
		String dateTime = ft.format(date);

		return dateTime;

	}

	/**
	 * 
	 * 关于方法的描述：获得当前系统日期
	 * 
	 * @param format
	 *            时间的格式 为"yyyy/MM/dd"
	 * @return 时间字符串
	 */
	public static String getCurrentDate()
	{

		SimpleDateFormat ft = null;
		Date date = new Date();
		ft = new SimpleDateFormat(DATE_FORMAT);
		String dateTime = ft.format(date);

		return dateTime;

	}

	/**
	 * 
	 * 关于方法的描述：最后心跳时间
	 * 
	 * @param llastSeen_
	 *            最后心跳的时间点
	 * @return 从当前系统时间到最后的心跳的时间点的时间，ms
	 */
	public static String getLastSeen(long llastSeen_)
	{
		String dateTime = "0";
		Date date = new Date();
		long ltime = date.getTime() - llastSeen_;
		if (ltime > 0)
		{
			dateTime = ltime + "";
		}// end if

		return dateTime;

	}

	public static String getDate(String format)
	{
		String strF = "yyyy/MM/dd HH:mm:ss";
		if (null != format && !"".equals(format))
		{
			strF = format;
		}// end if
		SimpleDateFormat ft = null;

		Date date = new Date();

		// 格式可以自己根据需要修改

		ft = new SimpleDateFormat(strF);

		String dateTime = ft.format(date);

		return dateTime;

	}

	/**
	 * 
	 * 关于方法的描述：获得当前系统时间
	 * 
	 * @param format
	 *            时间的格式 例如：yyyy/MM/dd HH:mm:ss
	 * @param timelong_
	 *            时间
	 * 
	 * @return 时间字符串
	 */
	public static String getFormatDate(String format, long timelong_)
	{

		if (0 >= timelong_)
		{
			return "--";
		}
		String strF = "yyyy/MM/dd HH:mm:ss,SSS";
		if (null != format && !"".equals(format))
		{
			strF = format;
		}// end if
		SimpleDateFormat ft = null;

		Date date = new Date(timelong_);

		// 格式可以自己根据需要修改

		ft = new SimpleDateFormat(strF);

		String dateTime = ft.format(date);

		return dateTime;

	}
	
	public static void main(String[] args)
    {
        float str=formatFloat(2.21326f);
        System.out.println(str);
    }

	/**
	 * 
	 * 关于方法的描述：获取对毫秒的格式化字符串.
	 * 
	 * @param long_
	 *            格式化源数据
	 * @return 如果格式源为负数，返回0，其他返回源数据的字符串。
	 */
	public static String getFormatMSecond(long long_)
	{
		String strdate = "0";
		if (long_ > 0)
		{
			strdate = long_ + "";
		}// end if
		return strdate;
	}

	/**
	 * 
	 * 关于方法的描述：获得工程的class的编译路径，本工程即为：classes目录
	 * 
	 * @return 路径
	 */
	public static String getProjectClassesPath()
	{
		String strpath = su.getClass().getClassLoader().getResource("")
				.getPath();
		return strpath;
	}

	/**
	 * 
	 * 关于方法的描述：从字符串中获取ip
	 * 
	 * @param str
	 *            字符串
	 * @return 存在ip返回ip地址，不存在返回null
	 */
	public static String GetIpFromString(String str)
	{
		String strIp = null;
		String regex0 = "(2[0-4]\\d)" + "|(25[0-5])";
		String regex1 = "1\\d{2}";
		String regex2 = "[1-9]\\d";
		String regex3 = "\\d";
		String regex = "(" + regex0 + ")|(" + regex1 + ")|(" + regex2 + ")|("
				+ regex3 + ")";
		regex = "(" + regex + ")\\.(" + regex + ")\\.(" + regex + ")\\.("
				+ regex + ")";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		if (m.find())
		{
			strIp = m.group();
		}// end if
		m.find();
		return strIp;
	}

	/**
	 * 关于方法的描述：
	 * 
	 * @param date
	 *            时间字符串
	 * @param format
	 *            格式
	 * @return
	 */
	static public Date getDate(String date, String format)
	{
		try
		{
			return new SimpleDateFormat(format).parse(date);
		} catch (ParseException e)
		{
			LoggerTool.m_logger.warn("警告:", e);
		}

		return null;
	}

	/**
	 * 控制浮点型小数位数
	 * 
	 * @param f
	 *            对象
	 * @param lenght
	 *            长度
	 * @return
	 */
	public static double subDouble(double f, int lenght)
	{
		/**
		String fStr = String.valueOf(f);
		int len = fStr.length();
		int i = fStr.indexOf('.');
		float returnf = 0.0f;
		if ((len - i) > lenght)
		{
			String returnStr = fStr.substring(0, i + 1 + lenght);
			returnf = (Float.valueOf(returnStr)).floatValue();
		} else
		{
			returnf = f;
		}
		return returnf;
		*/
		if (lenght < 0)
		{
			return f;
		}
		f = Math.round((f * (Math.pow(10, lenght))));// 四舍五入取整数
		f = (float) (f / (Math.pow(10, lenght)));
		return f;
	}

	/**
	 * 格式化浮点数为，小数点后保留4位
	 * 
	 * @param f
	 *            对象
	 * @return 格式化后的浮点数
	 */
	public static float formatFloat(float f)
	{

		DecimalFormat df = new DecimalFormat("#.0000");
		f = Float.parseFloat(df.format(f));//四舍五入
		return f;
	}

	
	
	public static boolean importCmd(String cmd) {   
        boolean flag=true;   
        try {   
            Process process = Runtime.getRuntime().exec(   
                     new String[]{   
                        "sh",   
                        "-c",   
                        cmd});   
            BufferedReader inputBufferedReader = new BufferedReader(   
                    new InputStreamReader(process.getInputStream()));   
            String line = null;   
            while ((line = inputBufferedReader.readLine()) != null) {   
                System.out.println(line);   
            }   
            try {   
                process.waitFor();   
            } catch (InterruptedException e) {   
                flag=false;   
                LoggerTool.m_logger.warn("警告",e);   
            }   
     
        } catch (IOException e) {   
            flag=false;   
            LoggerTool.m_logger.warn("警告",e);   
        }   
        return flag;   
    }

    /**
      * 关于方法的描述：将日期格式化为制定格式
      * @param born 日期
      * @param string 格式化字符串
      * @return 
      */
    public static String getFormatDate(Date born, String format)
    {
        String strF = "yyyy/MM/dd HH:mm:ss,SSS";
        if (null != format && !"".equals(format))
        {
            strF = format;
        }// end if
        SimpleDateFormat ft = null;

        // 格式可以自己根据需要修改

        ft = new SimpleDateFormat(strF);

        String dateTime = ft.format(born);

        return dateTime;
        
    }  

}
