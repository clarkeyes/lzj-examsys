package com.sys.common.logtool;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * 
 * <p>Title: LoggerTool.java</p>
 * <p>Description: 日志工具，首先调用logInit（String）初始化日志配置文件，
 * 然后调用 例如：
     * LoggerTool.m_logger.debug("sdfsdf");
     * LoggerTool.m_logger.info("sdfsdf");
     * LoggerTool.m_logger.warn("sdfsdf");
     * LoggerTool.m_logger.fatal("sdfsdf");</p>
 *
 *
 * <p>Copyright: Copyright (c) 2006 by 
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

public class LoggerTool
{

    /**记录日志实体*/
    public static Logger m_logger = Logger.getLogger(LoggerTool.class.getName());

    /**
      * 关于方法的描述：初始化日志配置文件
      * @param strConfigFilePath_ 日志配置文件路径，路径为<br>null或者“”
      * ，采用默认路径"log4j.properties"
      */
    public static void logInit(String strConfigFilePath_)
    {
        String strPath = "log4j.properties";
        if (null != strConfigFilePath_ && !"".equals(strConfigFilePath_))
        {
            strPath = strConfigFilePath_;
        }// end if
        PropertyConfigurator.configure(strPath);
    }
    /**
     * 关于方法的描述：初始化日志配置文件
     */
    public static void logInit()
    {
      PropertyConfigurator.configure(LoggerTool.class.getClassLoader().getResource("log4j.properties"));
    }

    public static void main(String[] args)
    {
        LoggerTool.logInit();
        LoggerTool.m_logger.warn("sdfsdf");
        LoggerTool.m_logger.warn("sdfsdf1");
        LoggerTool.m_logger.warn("sdfsdf2");
        LoggerTool.m_logger.warn("sdfsdf3");
    }

}
