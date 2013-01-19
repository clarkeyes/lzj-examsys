package com.sys.common.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sys.common.logtool.LoggerTool;

/**
 * <p>Title: testdb.java</p>
 * <p>Description: The tool is used to execute the commond </p>
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
public class SystemCmd
{
    /**数据库用户名��ݿ�����*/
    private static String m_dbUserName = null;

    /**数据库密码��ݿ�����*/
    private static String m_dbPassword = null;

    /**
      * 关于方法的描述：运行脚本
      * @param filepath
      * @return 
      */
    public static boolean importDb(String filepath)
    {
        boolean flag = true;
        String[] cmd = { "cat " + filepath + "| /usr/bin/mysql -u"
                + m_dbUserName + " -p" + m_dbPassword
                + "  --default-character-set=gb2312 " };
        try
        {
            Process process = Runtime.getRuntime().exec(
                    new String[] { "sh", "-c", cmd[0] });
            BufferedReader inputBufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = inputBufferedReader.readLine()) != null)
            {
                System.out.println(line);
            }
            try
            {
                process.waitFor();
            }
            catch (InterruptedException e)
            {
                flag = false;
                e.printStackTrace();
            }

        }
        catch (IOException e)
        {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    /**
      * 关于方法的描述：运行对应数据库的脚本
      * @param filepath
      * @param dbname
      * @return 
      */
    public static boolean importDb(String filepath, String dbname)
    {
        boolean flag = true;
        String[] cmd = { "cat " + filepath + "| /usr/bin/mysql -u"
                + m_dbUserName + " -p" + m_dbPassword
                + " --default-character-set=gb2312 " + dbname };
        try
        {
            Process process = Runtime.getRuntime().exec(
                    new String[] { "sh", "-c", cmd[0] });
            BufferedReader inputBufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = inputBufferedReader.readLine()) != null)
            {
                System.out.println(line);
            }
            try
            {
                process.waitFor();
            }
            catch (InterruptedException e)
            {
                flag = false;
                e.printStackTrace();
            }

        }
        catch (IOException e)
        {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    /**
      * 关于方法的描述： 执行命令
      * @param cmd
      * @return 
      */
    public boolean importCmd(String cmd)
    {
        // LoggerTool.m_logger.info(cmd);
        boolean flag = true;
        try
        {
            Process process = Runtime.getRuntime().exec(
                    new String[] { "sh", "-c", cmd });
            BufferedReader inputBufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = inputBufferedReader.readLine()) != null)
            {
                System.out.println(line);
                LoggerTool.m_logger.info(line);
            }
            try
            {
                process.waitFor();
            }
            catch (InterruptedException e)
            {
                flag = false;
                LoggerTool.m_logger.info(e);
                e.printStackTrace();
            }

        }
        catch (IOException e)
        {
            flag = false;
            e.printStackTrace();
            LoggerTool.m_logger.info(e);
        }
        catch (Exception e)
        {
            flag = false;
            LoggerTool.m_logger.info(e);
        }
        return flag;
    }

    public static void runAcommand(String cmd) throws IOException
    {
        // Run a command
        boolean completed = false;

        Process process = null; // Sub process used to execute the command
        int exitCode;
        process = Runtime.getRuntime().exec(cmd);

        final BufferedReader errReader = new BufferedReader(
                new InputStreamReader(process.getErrorStream()));

        BufferedReader inReader = new BufferedReader(new InputStreamReader(
                process.getInputStream()));

        final StringBuffer errMsg = new StringBuffer();
        // read error and input streams as this would free up the buffers
        // free the error stream buffer
        Thread errThread = new Thread()
        {

            public void run()
            {
                try
                {
                    String line = errReader.readLine();
                    while ((line != null) && !isInterrupted())
                    {
                        errMsg.append(line);
                        errMsg.append(System.getProperty("line.separator"));
                        line = errReader.readLine();
                    }
                }
                catch (IOException ioe)
                {
                    LoggerTool.m_logger.warn("Error reading the error stream",
                            ioe);
                }
            }

        };
        try
        {
            errThread.start();
        }
        catch (IllegalStateException ise)
        {
        }

        try
        {
            String line = inReader.readLine();
            if (line == null)
            {
                throw new IOException("Exception a line not the end of stream");
            }
            // clear the input stream buffer
            line = inReader.readLine();
            while (line != null)
            {
                System.out.println(line);
                line = inReader.readLine();
                
            }

            // wait for the process to finish and check the exit code
            exitCode = process.waitFor();

            try
            {
                errThread.join();
            }
            catch (InterruptedException ie)
            {
                LoggerTool.m_logger.warn(
                        "Interrupted while reading the error stream", ie);
            }
            completed = true;
            if (exitCode != 0)
            {
                throw new IOException(exitCode + errMsg.toString());
            }
        }
        catch (InterruptedException ie)
        {
            throw new IOException(ie.toString());
        }
        finally
        {
            // close the input stream
            try
            {
                inReader.close();
            }
            catch (IOException e)
            {
                LoggerTool.m_logger.warn(
                        "Error whilke closing the input stream", e);
            }
            if (!completed)
            {
                errThread.interrupt();
            }
            try
            {
                errReader.close();
            }
            catch (IOException ioe)
            {
                LoggerTool.m_logger.warn(
                        "Error while closing the error stream", ioe);
            }
            process.destroy();
        }

    }

    public static String getM_dbUserName()
    {
        return m_dbUserName;
    }

    public static void setM_dbUserName(String userName)
    {
        m_dbUserName = userName;
    }

    public static String getM_dbPassword()
    {
        return m_dbPassword;
    }

    public static void setM_dbPassword(String password)
    {
        m_dbPassword = password;
    }

}
