/**
 * 
 */
package com.sys.exam.action.admin;

import com.sys.exam.action.ModelAction;
import com.sys.exam.service.ExamService;
import com.sys.exam.service.UserExamService;

/**
 * @author Administrator
 *
 */
public class ImportUserGroupAction extends ModelAction {
	private Long examId;
	private Long userGroupId;
	@Override
	public String execute() throws Exception {
		try {
			UserExamService ueService=serviceManager.getUserExamService();
			String ret=ueService.addUserExam(examId,userGroupId);
			if(null==ret){
				result="success";
			}else{
				result=ret;
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			result="系统错误";
			return INPUT;
		}
		
	}
	public Long getExamId() {
		return examId;
	}
	public void setExamId(Long examId) {
		this.examId = examId;
	}
	public Long getUserGroupId() {
		return userGroupId;
	}
	public void setUserGroupId(Long userGroupId) {
		this.userGroupId = userGroupId;
	}
	
}
