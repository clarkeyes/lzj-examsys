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
import com.sys.exam.database.model.UgModel;
import com.sys.exam.service.UserGroupService;

/**
 * @author Administrator
 *
 */
public class UserGroupListAction extends ModelAction {
	/**请求的页号*/
    private int page = 1;
    /**一页容纳的记录条数*/
    private int rows = 10;
    private int total;
    private List<UgModel> ugList=new ArrayList<UgModel>();
    @Override
    public String execute() throws Exception {
    	try {
			UserGroupService ugService=serviceManager.getUserGroupService();
			Pager pager=new Pager();
			pager.setCurrentPage(page);
			pager.setPageSize(rows);
			pager=ugService.findUgPager(pager);
			total=pager.getTotalRows();
			ugList=pager.getElements();
			return SUCCESS;
		} catch (Exception e) {
			LoggerTool.m_logger.warn("显示用户组信息列表错误", e);
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
	public List<UgModel> getUgList() {
		return ugList;
	}
	public void setUgList(List<UgModel> ugList) {
		this.ugList = ugList;
	}
    
}
