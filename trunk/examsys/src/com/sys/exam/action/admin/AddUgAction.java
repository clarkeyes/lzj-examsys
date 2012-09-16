/**
 * 
 */
package com.sys.exam.action.admin;

import com.sys.exam.action.ModelAction;
import com.sys.exam.service.UserGroupService;

/**
 * @author Administrator
 *
 */
public class AddUgAction extends ModelAction {
	private String ugName;
	@Override
	public String execute() throws Exception {
		try {
			UserGroupService ugService=serviceManager.getUserGroupService();
			String ret=ugService.addUg(ugName);
			if(null==ret){
				result="success";
			}else{
				result=ret;
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			result="添加用户组失败";
			return INPUT;
		}
	}
	public String getUgName() {
		return ugName;
	}
	public void setUgName(String ugName) {
		this.ugName = ugName;
	}
	
}
