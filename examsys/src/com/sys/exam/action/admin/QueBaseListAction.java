/**
 * ProjectName: examsyssvn
 * Date: May 10, 2013
 *
 */

package com.sys.exam.action.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.sys.common.logtool.LoggerTool;
import com.sys.exam.action.ModelAction;
import com.sys.exam.database.Pager;
import com.sys.exam.database.model.QueBaseModel;
import com.sys.exam.service.QuestionBaseService;

/**
 * <p>Title: QueBaseListAction.java</p>
 * <p>Description:  </p>
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

public class QueBaseListAction extends ModelAction {
	/**请求的页号*/
    private int page = 1;
    /**一页容纳的记录条数*/
    private int rows = 10;
    private int total;
    private List<QueBaseModel> queBaseList=new ArrayList<QueBaseModel>();
    @Override
    public String execute() throws Exception {
    	try {
			QuestionBaseService qbService=serviceManager.getQuestionBaseService();
			Pager pager=new Pager();
			pager.setCurrentPage(page);
			pager.setPageSize(rows);
			pager=qbService.findQbmList(pager);
			total=pager.getTotalRows();
			queBaseList=pager.getElements();
			return SUCCESS;
		} catch (Exception e) {
			LoggerTool.m_logger.warn("获取题库列表失败", e);
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
	public List<QueBaseModel> getQueBaseList() {
		return queBaseList;
	}
	public void setQueBaseList(List<QueBaseModel> queBaseList) {
		this.queBaseList = queBaseList;
	}
    
}
