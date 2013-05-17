/**
 * 
 */
package com.sys.exam.action.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.sys.common.logtool.LoggerTool;
import com.sys.exam.action.ModelAction;
import com.sys.exam.database.Pager;
import com.sys.exam.database.model.UserModel;
import com.sys.exam.service.UserService;
import com.sys.exam.util.Constant;

/**
 * @author Administrator
 *
 */
public class UserListAction extends ModelAction {
	/**请求的页号*/
    private int page = 1;
    /**一页容纳的记录条数*/
    private int rows = 10;
    private int total;
    /**用户角色*/
    private int userRole;
    private List<UserModel> userList=new ArrayList<UserModel>();
    @Override
    public String execute() throws Exception {
    	try {
			UserService userService=serviceManager.getUserService();
			Pager pager=new Pager();
			pager.setCurrentPage(page);
			pager.setPageSize(rows);
			pager=userService.findUserListByRole(userRole,pager);
			total=pager.getTotalRows();
			userList=pager.getElements();
			return SUCCESS;
		} catch (Exception e) {
			LoggerTool.m_logger.warn("获取用户列表错误", e);
			return INPUT;		
		}
    	
    }
    @JSON(serialize = false)
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	@JSON(serialize = false)
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@JSON(name = "rows")
	public List<UserModel> getUserList() {
		return userList;
	}
	public void setUserList(List<UserModel> userList) {
		this.userList = userList;
	}
	public int getUserRole() {
		return userRole;
	}
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
    
}
