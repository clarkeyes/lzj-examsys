package com.sys.exam.database.model;

import java.util.List;

public class TypeAnswer {
	private int type;
	private List<UserAnswer> uaList;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<UserAnswer> getUaList() {
		return uaList;
	}
	public void setUaList(List<UserAnswer> uaList) {
		this.uaList = uaList;
	}
	
}
