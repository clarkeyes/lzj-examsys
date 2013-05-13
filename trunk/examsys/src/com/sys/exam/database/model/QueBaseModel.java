/**
 * 
 */
package com.sys.exam.database.model;

/**
 * @author Administrator
 *
 */
public class QueBaseModel {
	/**题库id*/
	private long qbId;
    /**题库名称*/
    private String qbName;
    /**单选题数量*/
    private int radioNum;
    /**判断题数量*/
    private int judgeNum;
    /**多选题数量*/
    private int checkNum;
	public long getQbId() {
		return qbId;
	}
	public void setQbId(long qbId) {
		this.qbId = qbId;
	}
	public String getQbName() {
		return qbName;
	}
	public void setQbName(String qbName) {
		this.qbName = qbName;
	}
	public int getRadioNum() {
		return radioNum;
	}
	public void setRadioNum(int radioNum) {
		this.radioNum = radioNum;
	}
	public int getJudgeNum() {
		return judgeNum;
	}
	public void setJudgeNum(int judgeNum) {
		this.judgeNum = judgeNum;
	}
	public int getCheckNum() {
		return checkNum;
	}
	public void setCheckNum(int checkNum) {
		this.checkNum = checkNum;
	}
    
    
}
