/**
 * 
 */
package com.sys.exam.action.admin;

import com.sys.exam.action.ModelAction;
import com.sys.exam.database.bean.UserExam;
import com.sys.exam.service.UserExamService;

/**
 * @author Administrator
 *
 */
public class ToUserScoreAddAction extends ModelAction {
	private Long ueId;
	private UserExam ue;
	@Override
	public String execute() throws Exception {
		try {
			UserExamService ueService=serviceManager.getUserExamService();
			ue=ueService.findUeById(ueId);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
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
	
}
