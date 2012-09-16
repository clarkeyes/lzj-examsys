/**
 * 
 */
package com.sys.exam.action.admin;

import java.util.List;

import com.sys.common.logtool.LoggerTool;
import com.sys.exam.action.ModelAction;
import com.sys.exam.database.bean.Exam;
import com.sys.exam.database.model.UqType;
import com.sys.exam.service.ExamService;

/**
 * @author Administrator
 *
 */
public class ExamContentAction extends ModelAction {
	private long examId;
	private Exam exam;
	private List<UqType> uqTypeList;
	@Override
	public String execute() throws Exception {
		try {
			ExamService examService=serviceManager.getExamService();
    		exam=examService.findExamById(examId);
    		uqTypeList=examService.findEqTypeList(examId);
			result="success";
			return SUCCESS;
		} catch (Exception e) {
			LoggerTool.m_logger.warn("考试试题信息异常", e);
			return INPUT;
		}
	}
	public long getExamId() {
		return examId;
	}
	public void setExamId(long examId) {
		this.examId = examId;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public List<UqType> getUqTypeList() {
		return uqTypeList;
	}
	public void setUqTypeList(List<UqType> uqTypeList) {
		this.uqTypeList = uqTypeList;
	}
	
}
