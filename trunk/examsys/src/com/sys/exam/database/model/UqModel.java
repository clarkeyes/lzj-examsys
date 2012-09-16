/**
 * 
 */
package com.sys.exam.database.model;

import java.util.List;

import com.sys.exam.database.bean.ExamQuestion;
import com.sys.exam.database.bean.Options;
import com.sys.exam.database.bean.UserQuestion;

/**
 * @author Administrator
 *
 */
public class UqModel {
	private UserQuestion uq;
	private ExamQuestion examq;
	private List<Options> opList;
	public UserQuestion getUq() {
		return uq;
	}
	public void setUq(UserQuestion uq) {
		this.uq = uq;
	}
	public List<Options> getOpList() {
		return opList;
	}
	public void setOpList(List<Options> opList) {
		this.opList = opList;
	}
	public ExamQuestion getExamq() {
		return examq;
	}
	public void setExamq(ExamQuestion examq) {
		this.examq = examq;
	}
	
}
