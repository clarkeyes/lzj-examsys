package com.sys.exam.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.sys.common.logtool.LoggerTool;
import com.sys.common.system.CommonUtil;
import com.sys.exam.database.bean.ExamQuestion;
import com.sys.exam.database.bean.Questions;
import com.sys.exam.database.bean.User;
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
    public void updateCheckExamTime()
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
                LoggerTool.m_logger.info(d+" : "+cal.getTime());
                LoggerTool.m_logger.info(d.compareTo(cal.getTime()));
                if (d.compareTo(cal.getTime())>0)
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
            String sql="from UserQuestion uq where uq.userExam.ueId="+ue.getUeId();
            List<UserQuestion> listUqs=managerService.getUserQuestionDao().find(sql);
            for (UserQuestion uq :listUqs)
            {
                ExamQuestion eq=uq.getExamQuestion();
                Questions que=eq.getQuestions();
                if (null!=uq.getUqAnswer())
                {
                    LoggerTool.m_logger.info(que.getQuesAnswer().intValue()+"::"+uq.getUqAnswer().intValue());
                    if (que.getQuesAnswer().intValue()==uq.getUqAnswer().intValue())
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
    
    
    @Override
    public List<UserExam> getAvaiExam(User user)
    {
        List<UserExam> listues=null;
        StringBuffer sbsql=new StringBuffer();
         sbsql.append("from UserExam ue where ue.ueState=")
         .append(Constant.EXAM_STATE_START)
         .append("and ue.user.userId=")
         .append(user.getUserId());
        listues=managerService.getUserExamDao().find(sbsql.toString());
        
        return listues;
    }
}