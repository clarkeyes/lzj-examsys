/**
 * 
 */
package com.sys.exam.action.admin;

import com.sys.exam.action.ModelAction;
import com.sys.exam.service.ExamService;

/**
 * @author Administrator
 *
 */
public class DeleteExamAction extends ModelAction {
	private Long examId;
	@Override
	public String execute() throws Exception {
		try {
			ExamService examService=serviceManager.getExamService();
			String ret=examService.deleteExam(examId);
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
	
}
