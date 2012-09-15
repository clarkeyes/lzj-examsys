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
    
    /***************考试状态****************/
    /**考试新建状态，用户不能开始考试*/
    public static final int EXAM_STATE_NEW=1;
    /**考试启动状态，用户可以开始考试*/
    public static final int EXAM_STATE_START=2;
    /**考试进行中状态*/
    public static final int EXAM_STATE_GOING=3;
    /**考试提交状态*/
    public static final int EXAM_STATE_SUB=4;
    /**考试判分完毕状态*/
    public static final int EXAM_STATE_OVER=5;
    
    /***************题型标识****************/
    /**单选类型*/
    public static final int QUESTION_SINGLE=1;
    /**多选类型*/
    public static final int QUESTION_MULTIPLE=2;
    /**判断类型*/
    public static final int QUESTION_JUDGE=3;
    
    /***************题库选择标识****************/
    /**题库的ID*/
    public static  int QUESTION_BASE_ID=1;
    
    
   
    
    static{
        try
        {
            PropertiesUtil pro = new PropertiesUtil(strProPath+"config.properties");
            setQUESTION_BASE_ID(Integer.parseInt(pro.getValue("question_base_id", "1")));
        }
        catch (Exception e)
        {
            LoggerTool.m_logger.warn("初始化有误",e);
        }
        
    }
    public static void main(String[] args)
    {
        int str=Constant.getQUESTION_BASE_ID();
        System.out.println(str);
    }



    /**
     * @return Returns the qUESTION_BASE_ID.
     */
    public static int getQUESTION_BASE_ID()
    {
        return QUESTION_BASE_ID;
    }




    /**
     * @param question_base_id The qUESTION_BASE_ID to set.
     */
    public static void setQUESTION_BASE_ID(int question_base_id)
    {
        QUESTION_BASE_ID = question_base_id;
    }
}
