/**
 * 
 */
package com.sys.exam.action.admin;

import java.util.List;

import com.sys.exam.action.ModelAction;
import com.sys.exam.database.bean.UserGroup;
import com.sys.exam.service.UserGroupService;

/**
 * @author Administrator
 *
 */
public class ToImportUserGroupAction extends ModelAction {
	private Long examId;
	private List<UserGroup> ugList;
	@Override
	public String execute() throws Exception {
		try {
			UserGroupService ugService=serviceManager.getUserGroupService();
			ugList=ugService.findUgList();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
		
	}
	public Long getExamId() {
		return examId;
	}
	public void setExamId(Long examId) {
		this.examId = examId;
	}
	public List<UserGroup> getUgList() {
		return ugList;
	}
	public void setUgList(List<UserGroup> ugList) {
		this.ugList = ugList;
	}
	
}
