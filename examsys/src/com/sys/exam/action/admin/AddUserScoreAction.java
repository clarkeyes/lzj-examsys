/**
 * 
 */
package com.sys.exam.action.admin;

import com.sys.exam.action.ModelAction;
import com.sys.exam.service.UserExamService;

/**
 * @author Administrator
 *
 */
public class AddUserScoreAction extends ModelAction {
	private Long ueId;
	private Float ueGrade;
	@Override
	public String execute() throws Exception {
		try {
			UserExamService ueService=serviceManager.getUserExamService();
			String ret=ueService.updateUeGrade(ueId,ueGrade);
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
	public Long getUeId() {
		return ueId;
	}
	public void setUeId(Long ueId) {
		this.ueId = ueId;
	}
	public Float getUeGrade() {
		return ueGrade;
	}
	public void setUeGrade(Float ueGrade) {
		this.ueGrade = ueGrade;
	}
	
}
