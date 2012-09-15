/**
 * ProjectName: vmmaster
 * Date: Sep 7, 2010
 *
 */

package com.sys.exam.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.sys.exam.action.ModelAction;
import com.sys.exam.database.bean.User;


/**
 * <p>Title: LogoutAction.java</p>
 * <p>Description: 用户登出操作 </p>
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

public class LogoutAction extends ModelAction
{
    /**序列号*/
    private static final long serialVersionUID = -1806382510159675196L;
    private User loginuser;
    private boolean userExist=true;
    @Override
    public String execute() throws Exception
    {
        session.clear();
        return SUCCESS;
    }
}
