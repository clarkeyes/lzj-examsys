/**
 * ProjectName: examsys
 * Date: Sep 15, 2012
 *
 */

package com.sys.exam.task;

import java.util.TimerTask;

import com.sys.common.logtool.LoggerTool;
import com.sys.exam.service.UserExamService;

/**
 * <p>Title: ExamTimeCheckTask.java</p>
 * <p>Description:  </p>
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

public class ExamTimeCheckTask extends TimerTask
{
    private UserExamService userExamService;
    @Override
    public void run()
    {
        //周期性的获得学生试卷表格中进行状态的试卷
        //判断试卷开始时间加上考试的时长是否大于当前系统时间
        //如果大于自动交卷
        LoggerTool.m_logger.info("自动交卷检查");
        userExamService.updateCheckExamTime();
        
    }
    /**
     * @return Returns the userExamService.
     */
    public UserExamService getUserExamService()
    {
        return userExamService;
    }
    /**
     * @param userExamService The userExamService to set.
     */
    public void setUserExamService(UserExamService userExamService)
    {
        this.userExamService = userExamService;
    }

}
