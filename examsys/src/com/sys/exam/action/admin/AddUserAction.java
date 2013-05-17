/**
 * ProjectName: examsyssvn
 * Date: May 15, 2013
 *
 */

package com.sys.exam.action.admin;

import com.sys.common.logtool.LoggerTool;
import com.sys.exam.action.ModelAction;
import com.sys.exam.database.bean.User;
import com.sys.exam.service.UserService;

/**
 * <p>Title: AddUserAction.java</p>
 * <p>Description: 添加用户 </p>
 *
 *
 * @author wangj
 * @version 1.0
 * @see 
 *
 * <PRE>
 * <U>Updated by:</U>   auther, date
 * <U>Description:</U>  Update description
 * </PRE>
 */

public class AddUserAction extends ModelAction {
	/**用户信息*/
	private User user;
	@Override
	public String execute() throws Exception {
		try {
			UserService userService=serviceManager.getUserService();
			String ret=userService.addUser(user);
			if(null==ret){
				result="success";
			}else{
				result=ret;
			}
			return SUCCESS;
		} catch (Exception e) {
			LoggerTool.m_logger.warn("添加用户失败", e);
			result="添加用户失败";
			return INPUT;
		}
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
