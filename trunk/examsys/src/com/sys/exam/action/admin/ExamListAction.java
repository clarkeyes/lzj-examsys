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
import com.sys.exam.database.model.ExamModel;
import com.sys.exam.service.ExamService;

/**
 * @author Administrator
 *
 */
public class ExamListAction extends ModelAction {
    /**排序规则*/
    private String order = "asc";
    /**排序的关键字*/
    private String sort;
    /**请求的页号*/
    private int page = 1;
    /**一页容纳的记录条数*/
    private int rows = 10;
    private int total;
    private List<ExamModel> examModelList=new ArrayList<ExamModel>();
    @Override
    public String execute() throws Exception {
    	try {
			ExamService examService=serviceManager.getExamService();
			Pager pager=new Pager();
			pager.setCurrentPage(page);
			pager.setPageSize(rows);
			pager=examService.findExamList(pager);
			total=pager.getTotalRows();
			examModelList=pager.getElements();
			result="success";
			return SUCCESS;
		} catch (Exception e) {
			LoggerTool.m_logger.warn("考试列表系统错误", e);
			return INPUT;
		}
    	
    }
    @JSON(serialize = false)
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	@JSON(serialize = false)
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
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
	public List<ExamModel> getExamModelList() {
		return examModelList;
	}
	public void setExamModelList(List<ExamModel> examModelList) {
		this.examModelList = examModelList;
	}
    
}
