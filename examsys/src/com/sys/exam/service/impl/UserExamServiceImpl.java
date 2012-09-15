package com.sys.exam.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.sys.common.logtool.LoggerTool;
import com.sys.common.system.CommonUtil;
import com.sys.exam.database.bean.ExamQuestion;
import com.sys.exam.database.bean.Questions;
import com.sys.exam.database.bean.UserExam;
import com.sys.exam.database.bean.UserQuestion;
import com.sys.exam.service.ManagerService;
import com.sys.exam.service.UserExamService;
import com.sys.exam.util.Constant;


/**
 * UserExam generated by MyEclipse Persistence Tools
 */

public class UserExamServiceImpl implements UserExamService 
{

    private ManagerService managerService;

    /**
     * @return Returns the managerService.
     */
    public ManagerService getManagerService()
    {
        return managerService;
    }

    /**
     * @param managerService The managerService to set.
     */
    public void setManagerService(ManagerService managerService)
    {
        this.managerService = managerService;
    }
    @Override
    public void CheckExamTime()
    {
        List<UserExam> listues=managerService.getUserExamDao()
        .find("from UserExam where ueState="+Constant.EXAM_STATE_GOING);
        if (null!=listues)
        {
            for (int i = 0; i < listues.size(); i++)
            {
                UserExam ue=listues.get(i);
                Date startDate=CommonUtil.getDate(ue.getUeStartTime(), "yyyy/MM/dd HH:mm:ss,SSS");
                Calendar cal=Calendar.getInstance(); 
                cal.setTime(startDate); 
                cal.add(Calendar.MINUTE, ue.getExam().getExamTime());
                Date d=new Date();
                if (d.compareTo(cal.getTime())<=0)
                {
                    updateSubUserExam(ue);
                }//end if

            }//end for
        }//end if
       
        
        
        
        
    }

    public  void updateSubUserExam(UserExam ue)
    {
        boolean isJudge=updateGradeJudging(ue);
        if (isJudge)
        {
            ue.setUeEndTime(CommonUtil.getCurrentTime());
            ue.setUeState(Constant.EXAM_STATE_SUB);
            managerService.getUserExamDao().save(ue);
        }//end if
        else {
            LoggerTool.m_logger.info("判分失败");
        }//end else
        
    }

    public  boolean updateGradeJudging(UserExam ue)
    {
        boolean ret=false;
        if (null!=ue)
        {
            float igrade=0f;
            Set<UserQuestion> listUqs=ue.getUserQuestions();
            for (UserQuestion uq :listUqs)
            {
                ExamQuestion eq=uq.getExamQuestion();
                Questions que=eq.getQuestions();
                if (null!=uq.getUqAnswer())
                {
                    if (que.getQuesAnswer()==uq.getUqAnswer())
                    {
                        igrade+=eq.getEqValue();
                    }//end if
                    
                }//end if
            }//end for
            
            ue.setUeGrade(igrade);
            managerService.getUserExamDao().save(ue);
            ret =true;
        }//end if
       
        
        
        return ret;
    }
}