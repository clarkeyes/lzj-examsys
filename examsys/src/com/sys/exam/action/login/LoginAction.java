package com.sys.exam.action.login;



import org.apache.struts2.json.annotations.JSON;

import com.sys.exam.action.ModelAction;
import com.sys.exam.database.bean.User;
import com.sys.exam.service.UserService;
import com.sys.exam.util.Constant;

/**
 * <p>Title: LoginAction.java</p>
 * <p>Description: 用户登录操作 </p>
 *
 * <p>Copyright: Copyright (c) 2009 by 
 * Shanghai hwellzen, Shanghai, China
 *                  All rights reserved.</p>
 * <p>Company: Hwellzen</p>
 * @author liuzj
 * @version 1.0
 * @see 
 *
 * <PRE>
 * <U>Updated by:</U>   auther, date
 * <U>Description:</U>  Update description
 * </PRE>
 */
public class LoginAction extends ModelAction
{
    private static final long serialVersionUID = 705707225408531515L;
    /**用户实体*/
    private User loginuser;
    //private boolean userExist=false;
    @SuppressWarnings("unchecked")
    public String execute()
    {
        try
        {
            UserService userService = serviceManager.getUserService();
            User user=userService.verifyUser(loginuser);//验证用户名、密码是否正确
            if (user!=null)
            {
            	session.put(Constant.USER, user);//存储当前登录用户
                 if(Constant.USER_MANAGER==user.getUserRole()||Constant.USER_SPE==user.getUserRole()){
                    result="manager";
                    return "manager";
                }else  if(Constant.USER_USER==user.getUserRole()){
                    result="commonUser";
                    return "commonUser";
                }
            }
            result="userError";
            return INPUT;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            result="error";
            return INPUT;
        }
    }
    @JSON(serialize=false)
    public User getLoginuser()
    {
        return loginuser;
    }

    public void setLoginuser(User loginuser)
    {
        this.loginuser = loginuser;
    }

}
