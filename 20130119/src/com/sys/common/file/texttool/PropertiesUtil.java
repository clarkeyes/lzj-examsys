package com.sys.common.file.texttool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Properties;

import com.sys.common.logtool.LoggerTool;

/**
 * <p>Title: PropertiesUtil.java</p>
 * <p>Description: 操作属性文件工具类  </p>
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
public class PropertiesUtil
{

    /**文件全路径*/
    private String m_filePath;

    /**属性对象*/
    private Properties m_objProperties;

    /**
     * 构造函数 加载属性资源文件 
     *
     * @param filePath 资源文件
     * @throws Exception
     */
    public PropertiesUtil(String filePath) throws Exception
    {
        this.m_filePath = filePath;
        File file = new File(filePath);
        FileInputStream inStream = new FileInputStream(file);
        try
        {
            m_objProperties = new Properties();
            m_objProperties.load(inStream);
        }
        catch (FileNotFoundException e)
        {
            LoggerTool.m_logger.warn("未找到属性资源文件!", e);
            e.printStackTrace();
            throw e;
        }
        catch (Exception e)
        {
            LoggerTool.m_logger.warn("读取属性资源文件发生未知错误!", e);
            e.printStackTrace();
            throw e;
        }
        finally
        {
            inStream.close();
        }
    }

    /**
      * 关于方法的描述：持久化属性文件,
      * 使用setValue()方法后，必须调用此方法才能将属性持久化到存储文件中
      * @param desc 属性列表的描述
      * @throws Exception 
      */
    public void savefile(String desc) throws Exception
    {
        FileOutputStream outStream = null;
        try
        {
            File file = new File(m_filePath);
            outStream = new FileOutputStream(file);
            m_objProperties.store(outStream, desc);// 保存属性文件
        }
        catch (Exception e)
        {
            LoggerTool.m_logger.warn("保存属性文件出错.", e);
            e.printStackTrace();
            throw e;
        }
        finally
        {
            outStream.close();
        }

    }
    
    public void saveToFile(String toFilePath,String desc) throws Exception
    {
        FileWriter outStream = null;
        try
        {
            File file = new File(toFilePath);
            outStream= new FileWriter(file);
            m_objProperties.store(outStream, desc);// 保存属性文件
        }
        catch (Exception e)
        {
            LoggerTool.m_logger.warn("保存属性文件出错.", e);
            e.printStackTrace();
            throw e;
        }
        finally
        {
            outStream.close();
        }

    }
    

    /**  
     * @title 获取属性值  
     * @desc 指定Key值，获取value  
     * @param String  
     * @return String  
     */
    public String getValue(String key)
    {
        return m_objProperties.getProperty(key);
    }

    /**  
     * @name getVlue  
     * @title 获取属性值,支持缺省设置  
     * @desc 重载getValue()方法；指定Key值，获取value并支持缺省值  
     * @param String  
     * @return String  
     */
    public String getValue(String key, String defaultValue)
    {
        String strtmp=m_objProperties.getProperty(key, defaultValue);
        if (null==strtmp||"".equals(strtmp))
        {
            strtmp=defaultValue;
        }//end if
        return strtmp;
    }

    /**  
     * @title 删除属性  
     * @desc 根据Key,删除属性  
     * @param String  
     * @return   
     */
    public void removeValue(String key)
    {
        m_objProperties.remove(key);
    }

    /**  
     * @title 设置属性  
     * @param String,String  
     * @return   
     */
    public void setValue(String key, String value)
    {
        m_objProperties.setProperty(key, value);
    }

    /**  
     * @title 打印所有属性值  
     * @param   
     * @return   
     */
    public void printAllVlue()
    {
        m_objProperties.list(System.out);
    }
}