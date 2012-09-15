/**
 * 
 */
package com.sys.exam.action.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.sys.exam.action.ModelAction;
import com.sys.exam.database.Pager;
import com.sys.exam.database.model.UserScore;
import com.sys.exam.service.UserExamService;

/**
 * @author Administrator
 *
 */
public class UserScoreListAction extends ModelAction {
	private Long examId;
	/**请求的页号*/
    private int page = 1;
    /**一页容纳的记录条数*/
    private int rows = 10;
    private int total;
    private List<UserScore> userScoreList=new ArrayList<UserScore>();
    @Override
    public String execute() throws Exception {
    	try {
			UserExamService ueService=serviceManager.getUserExamService();
			Pager pager=new Pager();
			pager.setCurrentPage(page);
			pager.setPageSize(rows);
			pager=ueService.findUserScoreList(examId,pager);
			total=pager.getTotalRows();
			userScoreList=pager.getElements();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			result="系统错误";
			return INPUT;
		}
    }
    @JSON(serialize = false)
	public Long getExamId() {
		return examId;
	}
	public void setExamId(Long examId) {
		this.examId = examId;
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
	public List<UserScore> getUserScoreList() {
		return userScoreList;
	}
	public void setUserScoreList(List<UserScore> userScoreList) {
		this.userScoreList = userScoreList;
	}
    
}
