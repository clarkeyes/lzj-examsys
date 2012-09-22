/**
 * 
 */
package com.sys.exam.database.model;

import java.util.List;

import com.sys.exam.database.bean.ExamQuesType;
import com.sys.exam.database.bean.UserExam;

/**
 * @author Administrator
 *
 */
public class UserExamModel {
	private UserExam ue;
	private int totalScore;
	private List<EqtModel> eqtList;
	public UserExam getUe() {
		return ue;
	}
	public void setUe(UserExam ue) {
		this.ue = ue;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public List<EqtModel> getEqtList() {
		return eqtList;
	}
	public void setEqtList(List<EqtModel> eqtList) {
		this.eqtList = eqtList;
	}
	
}
