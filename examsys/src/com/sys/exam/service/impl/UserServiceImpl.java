package com.sys.exam.service.impl;


import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.sys.common.logtool.LoggerTool;
import com.sys.exam.database.Pager;
import com.sys.exam.database.bean.User;
import com.sys.exam.database.bean.UserGroup;
import com.sys.exam.database.bean.UserGroupRel;
import com.sys.exam.database.model.UserModel;
import com.sys.exam.service.ManagerService;
import com.sys.exam.service.UserService;
import com.sys.exam.util.Constant;
import com.sys.exam.util.EncryptUtil;


/**
 * User generated by MyEclipse Persistence Tools
 */

public class UserServiceImpl implements UserService 
{

    private ManagerService managerService;

    /**
     * @return Returns the managerService.
     */
    public ManagerService getManagerService()
    {
        return managerService;
    }

    /**
     * @param managerService The managerService to set.
     */
    public void setManagerService(ManagerService managerService)
    {
        this.managerService = managerService;
    }

	@Override
	public User verifyUser(User loginuser) throws Exception {
		StringBuilder hsql=new StringBuilder();
		hsql.append("from User user where user.userAccount='");
		hsql.append(loginuser.getUserAccount());
		hsql.append("' or user.userName='");
		hsql.append(loginuser.getUserAccount());
		hsql.append("'");
		List<User> userList=managerService.getUserDao().find(hsql.toString());
		User user_db=null;//从数据库中查找到的user
		if(userList.size()>0){
			user_db=userList.get(0);
		}
        if(user_db!=null){
        	//将用户提交的密码进行md5加密
        	String password=EncryptUtil.md5Encrypt(loginuser.getUserPassword());
        	String password_db=user_db.getUserPassword();
        	if(password_db.equals(password)){//验证用户输入的密码是否正确
        		return user_db;
        	}
            return null;
        }else
        {
            return null;
        }
	}

	@Override
	public Pager findUserListByRole(int userRole, Pager pager) throws Exception {
		
	    String sql="from User u where u.userRole="+userRole;
	    List<User> listusers=managerService.getUserDao().find(sql);
	    List<UserModel> listUms=new ArrayList<UserModel>();
	    UserModel um=null;
	    for (User user : listusers)
        {
            um=new UserModel();
            um.setUserAccount(user.getUserAccount());
            um.setUserId(user.getUserId());
            um.setUserName(user.getUserName());
            listUms.add(um);
        }
	    
	    //分页
	    int pageBegin = (pager.getCurrentPage() - 1) * pager.getPageSize();
        int pageEnd = pageBegin + pager.getPageSize();
        int total = listUms.size();
        if (pageEnd > total)
            pageEnd = total;
        Pager p = new Pager(total, pager.getPageSize());
        p.setElements(listUms.subList(pageBegin, pageEnd));
	    
		return p;
	}

	@Override
	public String deleteUsers(List<Long> userIdList) throws Exception {
	    for (Long long1 : userIdList)
        {
	        managerService.getUserDao().deleteByKey(long1);
        }
		
		return null;
	}

	@Override
	public String addImportUsers(String filePath) throws Exception {
		String flag = null;
        // 创建对Excel工作簿文件的引用
        HSSFWorkbook wookbook = new HSSFWorkbook(new FileInputStream(
        		filePath));
        // 在Excel文档中，第一张工作表的缺省索引是0
        // 其语句为：HSSFSheet sheet = workbook.getSheetAt(0);
        // HSSFSheet sheet = wookbook.getSheet("Sheet2");
        HSSFSheet sheet = wookbook.getSheetAt(0);
        // 获取到Excel文件中的所有行数
        int rows = sheet.getPhysicalNumberOfRows();
        // 遍历行­
        List<Integer> rowi = findByRow1(sheet);// 得到账号，昵称，所在的列号数组
        //判断首行数据是不是按要求写的
        if (rowi.size() >= 2)
        {
            for (int i = 1; i < rows; i++)
            {
                // 读取左上端单元格­
                HSSFRow row = sheet.getRow(i);
                // 行不为空­
                if (row != null)
                {
                    // 获取到Excel文件中的所有的列­
                    int cells = row.getPhysicalNumberOfCells();
                    String value = "";
                    // 遍历列­
                    for (int j = 0; j < cells; j++)
                    {
                        // 获取到列的值­
                        HSSFCell cell = row.getCell(j);

                        if (cell != null)
                        {
                            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                            value += cell.toString() + ",";
                        }
                    }
                    // 将数据插入到mysql数据库中­
                    if (value.contains(","))
                    {
                        String[] val = value.split(",");
                        String userAccount = val[rowi.get(0)].toString();
                        String userName = val[rowi.get(1)].toString();
                        // 判断用户名、账号是否符合要求
                        if (userAccount.matches("\\w{1,25}")
                                && userName.matches("[\\w|\\u4e00-\\u9fa5]{1,25}"))
                        {
                            List<User> userList = managerService.getUserDao().find("from User u where u.userAccount='"
                                            + userAccount + "'");
                            if (userList.size() == 0)
                            {
                                User user = new User();
                                user.setUserAccount(userAccount);
                                user.setUserName(userName);
                                user.setUserRole(Constant.USER_USER);
                                String password = EncryptUtil.md5Encrypt(userAccount);
                                user.setUserPassword(password);
                                managerService.getUserDao().save(user);
                            }
                        }
                        else
                        {
                            flag = "表格中有数据不符合要求";
                        }
                    }
                }
            }
        }
        else
        {
            flag = "表格首行数据错误";
        }
        return flag;
	}  
	/**
	 * 关于方法的描述：得到账号，昵称，类别所在的列号数组
	 * @param sheet
	 * @return
	 */
	    private List<Integer> findByRow1(HSSFSheet sheet) {
	   	 List<Integer> ret=new ArrayList<Integer>();
	   	 HSSFRow row = sheet.getRow(0);
	        if (row != null){
	        	 // 获取到Excel文件中的所有的列­
	            int cells = row.getPhysicalNumberOfCells();
	            String value = "";
	            // 遍历列­
	            for (int j = 0; j < cells; j++)
	            {
	           	// 获取到列的值­
	                HSSFCell cell = row.getCell(j);
	                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	                if (cell != null)
	                {
	                        value += cell.toString() + ",";
	                }
	            }
	                if (value.contains(","))
	                {
	                    String[] val = value.split(",");
	                    for (int i = 0; i < val.length; i++) {
							if(val[i].equals("账号"))
								{
								ret.add(i);
								break;
								}
						}
	                    for (int i = 0; i < val.length; i++) {
	                        if(val[i].equals("姓名"))
								{
	                       	 ret.add(i);
	                       	 break;
								}    
						}
	                }
	                return ret;
	            }
	        return ret;
		}

	@Override
	public Pager findInGroupUsers(long ugId, Pager pager) throws Exception {
		StringBuilder hsql=new StringBuilder();
		hsql.append("select user from User as user left join user.userGroupRels as ugrs where  ugrs.userGroup.ugId=");
		hsql.append(ugId);
		List<User> userList=managerService.getUserDao().find(hsql.toString());
		List<UserModel> userModelList=new ArrayList<UserModel>();
		for(User user:userList){
			UserModel userModel=new UserModel();
			userModel.setUserAccount(user.getUserAccount());
			userModel.setUserId(user.getUserId());
			userModel.setUserName(user.getUserName());
			userModelList.add(userModel);
		}
		// 分页
        int pageBegin = (pager.getCurrentPage() - 1) * pager.getPageSize();
        int pageEnd = pageBegin + pager.getPageSize();
        int total = userModelList.size();
        if (pageEnd > total)
            pageEnd = total;
        Pager p = new Pager(total, pager.getPageSize());
        p.setElements(userModelList.subList(pageBegin, pageEnd));
        return p;
	}

	@Override
	public Pager findNotInGroupUsers(long ugId, Pager pager) throws Exception {
		StringBuilder hsql=new StringBuilder();
		hsql.append("select user from User user where user.userId not in (select ugr.user.userId from UserGroupRel ugr where ugr.userGroup.ugId=");
		hsql.append(ugId);
		hsql.append(") and user.userRole in (");
		hsql.append(Constant.USER_USER);
		hsql.append(",");
		hsql.append(Constant.USER_PUBLIC);
		hsql.append(")");
		List<User> userList=managerService.getUserDao().find(hsql.toString());
		List<UserModel> userModelList=new ArrayList<UserModel>();
		for(User user:userList){
			UserModel userModel=new UserModel();
			userModel.setUserAccount(user.getUserAccount());
			userModel.setUserId(user.getUserId());
			userModel.setUserName(user.getUserName());
			userModelList.add(userModel);
		}
		// 分页
        int pageBegin = (pager.getCurrentPage() - 1) * pager.getPageSize();
        int pageEnd = pageBegin + pager.getPageSize();
        int total = userModelList.size();
        if (pageEnd > total)
            pageEnd = total;
        Pager p = new Pager(total, pager.getPageSize());
        p.setElements(userModelList.subList(pageBegin, pageEnd));
        return p;
	}

	@Override
	public String removeUsers(List<Long> userIdList, long ugId) throws Exception {
		String ret=null;
		//组织用户id
		StringBuilder userIds=new StringBuilder();
		for(int i=0;i<userIdList.size();i++){
			userIds.append(userIdList.get(i));
			if(i!=userIdList.size()-1){
				userIds.append(",");
			}
		}
		//查找选中用户
		StringBuilder hsql=new StringBuilder();
		hsql.append("from UserGroupRel ugr where ugr.userGroup.ugId=");
		hsql.append(ugId);
		hsql.append(" and ugr.user.userId in (");
		hsql.append(userIds.toString());
		hsql.append(")");
		List<UserGroupRel> ugrList=managerService.getUserGroupRelDao().find(hsql.toString());
		managerService.getUserGroupRelDao().deleteAll(ugrList);
		return ret;
	}

	@Override
	public String addUsersToUg(List<Long> userIdList, long ugId)
			throws Exception {
		String ret=null;
		//组织用户id
		StringBuilder userIds=new StringBuilder();
		for(int i=0;i<userIdList.size();i++){
			userIds.append(userIdList.get(i));
			if(i!=userIdList.size()-1){
				userIds.append(",");
			}
		}
		//查找选中用户
		StringBuilder hsql=new StringBuilder();
		hsql.append("from User user where user.userId in (");
		hsql.append(userIds.toString());
		hsql.append(")");
		List<User> userList=managerService.getUserDao().find(hsql.toString());
		UserGroup ug=managerService.getUserGroupDao().get(ugId);
		List<UserGroupRel> ugrList=new ArrayList<UserGroupRel>();
		for(User user:userList){
			UserGroupRel ugr=new UserGroupRel();
			ugr.setUser(user);
			ugr.setUserGroup(ug);
			ugrList.add(ugr);
		}
		managerService.getUserGroupRelDao().saveOrUpdateAll(ugrList);
		return ret;
	}

	@Override
	public void updatePassword(User user) throws Exception {
		String password=EncryptUtil.md5Encrypt(user.getUserPassword());
        user.setUserPassword(password);
        managerService.getUserDao().update(user);
		
	}

	@Override
	public String addUser(User user) throws Exception {
		// 判断用户是否存在
		String ret=null;
		StringBuilder hsql=new StringBuilder();
		hsql.append("from User u where u.userAccount='");
		hsql.append(user.getUserAccount());
		hsql.append("'");
		List<User> userList=managerService.getUserDao().find(hsql.toString());
		if(null!=userList&&userList.size()>0){
			ret="账号已存在，请重新输入";
		}else{
			//密码加密
			String password=EncryptUtil.md5Encrypt(user.getUserPassword());
			user.setUserPassword(password);
			managerService.getUserDao().save(user);
		}
		return ret;
	}

}