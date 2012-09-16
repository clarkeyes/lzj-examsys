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
import com.sys.exam.database.bean.UserQuestion;
import com.sys.exam.database.model.ExamModel;
import com.sys.exam.database.model.UqType;
import com.sys.exam.service.UserExamService;
import com.sys.exam.service.UserQuestionService;
import com.sys.exam.util.Constant;

/**
 * @author Administrator
 *
 */
public class UserExamContentAction extends ModelAction {
    
    /**TODO*/
    private static final long serialVersionUID = 440514624114109693L;
    private Long ueId;
    private UserExam ue;
    private List<UqType> uqTypeList;
    @Override
    public String execute() throws Exception {
        User user=(User)session.get(Constant.USER);//当前登录用户
        UserExamService ueService=serviceManager.getUserExamService();
        UserQuestionService uqService=serviceManager.getUserQuestionService();
    	try {
    		ue=ueService.findUeById(ueId);
    		uqTypeList=uqService.findUqTypeList(ueId);
			result="success";
			return SUCCESS;
		} catch (Exception e) {
			LoggerTool.m_logger.warn("用户考试试题信息异常", e);
			return INPUT;
		}
    	
    }
	public Long getUeId() {
		return ueId;
	}
	public void setUeId(Long ueId) {
		this.ueId = ueId;
	}
	public UserExam getUe() {
		return ue;
	}
	public void setUe(UserExam ue) {
		this.ue = ue;
	}
	public List<UqType> getUqTypeList() {
		return uqTypeList;
	}
	public void setUqTypeList(List<UqType> uqTypeList) {
		this.uqTypeList = uqTypeList;
	}
    
}
