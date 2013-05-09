/**
 * 
 */
package com.sys.exam.action.user;

import java.util.List;

import com.sys.exam.action.ModelAction;
import com.sys.exam.database.model.TypeAnswer;
import com.sys.exam.database.model.UserAnswer;
import com.sys.exam.service.UserQuestionService;

/**
 * @author Administrator
 *
 */
public class CommitAnswerAction extends ModelAction {
	private List<TypeAnswer> taList;
	private long ueId;
	/**成绩*/
	private float ueGrade;
	@Override
	public String execute() throws Exception {
		try {
			UserQuestionService uqService=serviceManager.getUserQuestionService();
			ueGrade=uqService.addUserAnswer(ueId,taList);
			result="success";
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			result="提交失败";
			return INPUT;
		}
	}
	public List<TypeAnswer> getTaList() {
		return taList;
	}
	public void setTaList(List<TypeAnswer> taList) {
		this.taList = taList;
	}
	public long getUeId() {
		return ueId;
	}
	public void setUeId(long ueId) {
		this.ueId = ueId;
	}
	public float getUeGrade() {
		return ueGrade;
	}
	public void setUeGrade(float ueGrade) {
		this.ueGrade = ueGrade;
	}
	
	
}
