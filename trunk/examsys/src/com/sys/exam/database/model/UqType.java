/**
 * 
 */
package com.sys.exam.database.model;

import java.util.List;

import com.sys.exam.database.bean.UserQuestion;

/**
 * @author Administrator
 *
 */
public class UqType {
	private int type;
	private List<UqModel> uqModelList;
	private int uqNum;
	private float typeScore;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<UqModel> getUqModelList() {
		return uqModelList;
	}
	public void setUqModelList(List<UqModel> uqModelList) {
		this.uqModelList = uqModelList;
	}
	public int getUqNum() {
		return uqNum;
	}
	public void setUqNum(int uqNum) {
		this.uqNum = uqNum;
	}
	public float getTypeScore() {
		return typeScore;
	}
	public void setTypeScore(float typeScore) {
		this.typeScore = typeScore;
	}
	
	
}
