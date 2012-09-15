/**
 * 
 */
package com.sys.exam.action.login;

import com.sys.exam.action.ModelAction;
import com.sys.exam.database.bean.User;
import com.sys.exam.util.Constant;



/**
 * <p>Title: HeadAction.java</p>
 * <p>Description:  提取登录用户</p>
 *
 * <p>Copyright: Copyright (c) 2009 by 
 * Shanghai hwellzen, Shanghai, China
 *                  All rights reserved.</p>
 * <p>Company: Hwellzen</p>
 * @author wangj
 * @version 1.0
 * @see 
 *
 * <PRE>
 * <U>Updated by:</U>   auther, date
 * <U>Description:</U>  Update description
 * </PRE>
 */
public class HeadAction extends ModelAction {
    /**登录用户的用户名*/
    private String userName;
    private int userRole;
    @Override
    public String execute() throws Exception
    {
        User user=(User)session.get(Constant.USER);
        userName=user.getUserName();
        userRole=user.getUserRole();
        return SUCCESS;
    }
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
	public int getUserRole() {
		return userRole;
	}
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
    
}
