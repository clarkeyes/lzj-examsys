/**
 * 
 */
package com.sys.exam.action.user;


import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.sys.common.logtool.LoggerTool;
import com.sys.exam.action.ModelAction;
import com.sys.exam.database.Pager;
import com.sys.exam.database.bean.User;
import com.sys.exam.database.bean.UserExam;
import com.sys.exam.database.model.ExamModel;
import com.sys.exam.service.UserExamService;
import com.sys.exam.util.Constant;

/**
 * @author Administrator
 *
 */
public class UserExamContentAction extends ModelAction {
    
    /**TODO*/
    private static final long serialVersionUID = 440514624114109693L;
    private List<UserExam> listUserExams=new ArrayList<UserExam>();
    @Override
    public String execute() throws Exception {
        User user=(User)session.get(Constant.USER);//当前登录用户
        UserExamService examService=serviceManager.getUserExamService();
        
    	try {
			
			listUserExams=examService.getAvaiExam(user);
			LoggerTool.m_logger.info(listUserExams.size());
			result="success";
			return SUCCESS;
		} catch (Exception e) {
			LoggerTool.m_logger.warn("用户考试列表异常", e);
			return INPUT;
		}
    	
    }
    /**
     * @return Returns the listUserExams.
     */
    public List<UserExam> getListUserExams()
    {
        return listUserExams;
    }
    /**
     * @param listUserExams The listUserExams to set.
     */
    public void setListUserExams(List<UserExam> listUserExams)
    {
        this.listUserExams = listUserExams;
    }
    
}
