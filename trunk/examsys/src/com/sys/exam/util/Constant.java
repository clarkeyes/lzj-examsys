package com.sys.exam.util;

import com.sys.common.file.texttool.PropertiesUtil;
import com.sys.common.logtool.LoggerTool;



/**
 * <p>Title: Constant.java</p>
 * <p>Description:  记录该系统中所使用的常量</p>
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
public class Constant{
	public static String strProPath=Constant.class.getClassLoader().getResource("").getPath();
    /**用户，作为session的key值*/
    public static final String USER="user";
    
    /**管理员*/
    public static final int USER_MANAGER=0;
    /**普通用户*/
    public static final int USER_USER=1;
   
    
    static{
        try
        {
            PropertiesUtil pro = new PropertiesUtil(strProPath+"config.properties");
        }
        catch (Exception e)
        {
            LoggerTool.m_logger.warn("初始化有误",e);
        }
        
    }
}
