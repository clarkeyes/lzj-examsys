/**
 * 
 */
package com.sys.exam.action.admin;

import java.util.List;

import com.sys.exam.action.ModelAction;
import com.sys.exam.service.UserService;

/**
 * @author Administrator
 *
 */
public class DeleteUsersAction extends ModelAction {
	private List<Long> userIdList;
	@Override
	public String execute() throws Exception {
		try {
			UserService userService=serviceManager.getUserService();
			String ret=userService.deleteUsers(userIdList);
			if(null==ret){
				result="success";
			}else{
				result=ret;
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			result="系统错误";
			return INPUT;
		}
		
	}
	public List<Long> getUserIdList() {
		return userIdList;
	}
	public void setUserIdList(List<Long> userIdList) {
		this.userIdList = userIdList;
	}
	
}
