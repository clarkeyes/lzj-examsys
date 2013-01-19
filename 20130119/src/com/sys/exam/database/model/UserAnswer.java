/**
 * 
 */
package com.sys.exam.database.model;

import java.util.List;

/**
 * @author Administrator
 *
 */
public class UserAnswer {
	private long uqId;
	private List<Integer> anList;
	public long getUqId() {
		return uqId;
	}
	public void setUqId(long uqId) {
		this.uqId = uqId;
	}
	public List<Integer> getAnList() {
		return anList;
	}
	public void setAnList(List<Integer> anList) {
		this.anList = anList;
	}
	
}
