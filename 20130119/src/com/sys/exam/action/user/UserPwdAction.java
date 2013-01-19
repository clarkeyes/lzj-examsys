/**
 * ProjectName: vmmaster
 * Date: Aug 23, 2010
 *
 */

package com.sys.exam.action.user;

import com.sys.exam.action.ModelAction;
import com.sys.exam.database.bean.User;
import com.sys.exam.service.UserService;
import com.sys.exam.util.Constant;
import com.sys.exam.util.EncryptUtil;


/**
 * <p>Title: UserPwdAction.java</p>
 * <p>Description: 修改用户密码 </p>
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

public class UserPwdAction extends ModelAction
{
    /**旧密码*/
    private String oldPassword;

    /**新密码*/
    private String newPassword;

    /**确认密码*/
    private String rePassword;

    @Override
    public String execute() throws Exception
    {
        try
        {
            UserService userService = serviceManager.getUserService();
            String oldPassword1 = EncryptUtil.md5Encrypt(oldPassword);// 将用户输入的当前密码进行加密
            User user = (User) session.get(Constant.USER);// 取出登录时保存的用户
            String userPassword = user.getUserPassword();// 获取登录用户的密码
            if (userPassword.equals(oldPassword1))
            {// 当前密码与登录密码是否相同
                user.setUserPassword(newPassword);// 设置新密码
                userService.updatePassword(user);// 更新数据库中的密码
                session.put(Constant.USER, user);
                //result = "密码修改成功！";
                result="success";
                return SUCCESS;
            }
            //result = "当前密码错误";
            result="pwdError";
            return INPUT;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            result="error";
            return INPUT;
        }
    }

    public String getOldPassword()
    {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword)
    {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword()
    {
        return newPassword;
    }

    public void setNewPassword(String newPassword)
    {
        this.newPassword = newPassword;
    }

    public void setRePassword(String rePassword)
    {
        this.rePassword = rePassword;
    }

    public String getRePassword()
    {
        return rePassword;
    }

}
