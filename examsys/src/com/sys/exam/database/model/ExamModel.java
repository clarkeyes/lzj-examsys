/**
 * 
 */
package com.sys.exam.database.model;

/**
 * @author Administrator
 *
 */
public class ExamModel {
	/**考试名称*/
	private String examName;
	/**时长*/
	private int examTime;
	/**考试人数*/
	private int userNum;
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public int getExamTime() {
		return examTime;
	}
	public void setExamTime(int examTime) {
		this.examTime = examTime;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	
}
