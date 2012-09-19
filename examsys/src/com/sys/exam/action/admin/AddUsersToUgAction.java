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
public class AddUsersToUgAction extends ModelAction {
	private List<Long> userIdList;
	private long ugId;
	@Override
	public String execute() throws Exception {
		try {
			UserService userService=serviceManager.getUserService();
			String ret=userService.addUsersToUg(userIdList,ugId);
			if(null==ret){
				result="success";
			}else{
				result=ret;
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			result="添加用户失败";
			return INPUT;
		}
		
	}
	public List<Long> getUserIdList() {
		return userIdList;
	}
	public void setUserIdList(List<Long> userIdList) {
		this.userIdList = userIdList;
	}
	public long getUgId() {
		return ugId;
	}
	public void setUgId(long ugId) {
		this.ugId = ugId;
	}
	
}
