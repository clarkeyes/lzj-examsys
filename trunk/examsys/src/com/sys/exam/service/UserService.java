package com.sys.exam.service;

import java.util.List;

import com.sys.exam.database.Pager;
import com.sys.exam.database.bean.User;


/**
 * User generated by MyEclipse Persistence Tools
 */

public interface UserService 
{

	/**验证登录用户的用户名密码是否正确
	 * @param loginuser
	 * @return
	 * @throws Exception
	 */
	User verifyUser(User loginuser)throws Exception;

	/**分页查找指定角色的用户信息
	 * @param userRole 角色
	 * @param pager 分页
	 * @return 用户id，name，account等信息
	 * @throws Exception
	 */
	Pager findUserListByRole(int userRole, Pager pager)throws Exception;

	/**删除选中的用户
	 * @param userIdList 用户id列表
	 * @return null：成功，其他为错误信息
	 * @throws Exception
	 */
	String deleteUsers(List<Long> userIdList)throws Exception;

	/**将上传文件中的用户导入数据库
	 * @param filePath 文件路径
	 * @return null：成功，其他为错误信息
	 * @throws Exception
	 */
	String addImportUsers(String filePath)throws Exception;

	/**分页查找指定用户组id的组内用户
	 * @param ugId 用户组id
	 * @param pager 分页信息
	 * @return
	 * @throws Exception
	 */
	Pager findInGroupUsers(long ugId, Pager pager)throws Exception;

	/**分页查找不在指定用户组中的用户
	 * @param ugId 用户组id
	 * @param pager 分页信息
	 * @return
	 * @throws Exception
	 */
	Pager findNotInGroupUsers(long ugId, Pager pager)throws Exception;

	/**删除指定用户组中选中的用户
	 * @param userIdList 用户id列表
	 * @param ugId 用户组id
	 * @return null：成功，其他为错误信息
	 * @throws Exception
	 */
	String removeUsers(List<Long> userIdList, long ugId)throws Exception;

	/**向指定的用户组中添加选中的用户
	 * @param userIdList 用户id列表
	 * @param ugId 用户组id
	 * @return null：成功，其他为错误信息
	 * @throws Exception
	 */
	String addUsersToUg(List<Long> userIdList, long ugId)throws Exception;

	/**修改用户密码
	 * @param user 用户信息
	 * @throws Exception
	 */
	void updatePassword(User user)throws Exception;

    

}