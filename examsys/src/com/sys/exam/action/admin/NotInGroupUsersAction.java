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

/**
 * @author Administrator
 *
 */
public class NotInGroupUsersAction extends ModelAction {
	private long ugId;
	/**当前页号*/
    private int page=1;
    /**页面大小*/
    private int rows=10; 
    private int total;
    private List<UserModel> userModelList=new ArrayList<UserModel>();
    @Override
    public String execute() throws Exception {
    	try {
			UserService userService=serviceManager.getUserService();
			Pager pager=new Pager();
			pager.setCurrentPage(page);
			pager.setPageSize(rows);
			pager=userService.findNotInGroupUsers(ugId,pager);
			total=pager.getTotalRows();
			userModelList=pager.getElements();
			return SUCCESS;
		} catch (Exception e) {
			LoggerTool.m_logger.warn("获取非组内用错误", e);
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
	@JSON(serialize = false)
	public long getUgId() {
		return ugId;
	}
	public void setUgId(long ugId) {
		this.ugId = ugId;
	}
	@JSON(name = "rows")
	public List<UserModel> getUserModelList() {
		return userModelList;
	}
	public void setUserModelList(List<UserModel> userModelList) {
		this.userModelList = userModelList;
	}
}
