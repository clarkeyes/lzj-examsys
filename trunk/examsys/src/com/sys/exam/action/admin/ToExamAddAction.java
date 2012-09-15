/**
 * 
 */
package com.sys.exam.action.admin;

import java.util.List;

import com.sys.exam.action.ModelAction;
import com.sys.exam.database.bean.QuestionBase;
import com.sys.exam.database.bean.QuestionCategory;
import com.sys.exam.service.QuestionBaseService;
import com.sys.exam.service.QuestionCategoryService;

/**
 * @author Administrator
 *
 */
public class ToExamAddAction extends ModelAction {
	private List<QuestionCategory> qcList;
	private List<QuestionBase> qbList;
	@Override
	public String execute() throws Exception {
		try {
			QuestionCategoryService qcService=serviceManager.getQuestionCategoryService();
			QuestionBaseService qbService=serviceManager.getQuestionBaseService();
			qcList=qcService.findQcList();
			qbList=qbService.findQbList();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
		
	}
	public List<QuestionCategory> getQcList() {
		return qcList;
	}
	public void setQcList(List<QuestionCategory> qcList) {
		this.qcList = qcList;
	}
	public List<QuestionBase> getQbList() {
		return qbList;
	}
	public void setQbList(List<QuestionBase> qbList) {
		this.qbList = qbList;
	}
	
}
