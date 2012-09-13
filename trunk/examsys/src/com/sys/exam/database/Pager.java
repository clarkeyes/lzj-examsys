package com.sys.exam.database;

import java.util.List;

public class Pager {
	/**记录总数*/
	private int totalRows;
	private int pageSize;
	/**当前页码*/
	private int currentPage;
	/**总页数*/
	private int totalPages;
	/**起始行*/
	private int startRow;
	/**记录列表*/
	private List elements;
	public Pager() {
	}
	/**
	 * 构造函数
	 * 构建pager对象
	 * @param 查处数据总行数
	 */
	public Pager(int _totalRows,int pageSize_) {
		totalRows = _totalRows;
		pageSize=pageSize_;
		totalPages=totalRows/pageSize;
		int mod=totalRows%pageSize;
		if(mod>0){
			totalPages++;
		}
		currentPage = 1;
		startRow = 0;
	}
	
	/**
	  * 显示首页： 
	  */
	public void first() {
		currentPage = 1;
		startRow = 0;
	}
	/**
	  * 关于方法的描述： 显示前一页
	  */
	public void previous() {
		if (currentPage == 1) {
			return;
		}
		currentPage--;
		startRow = (currentPage - 1) * pageSize;
	}
	/**
	  * 显示后一页： 
	  */
	public void next() {
		if (currentPage < totalPages) {
			currentPage++;
		}
		startRow = (currentPage - 1) * pageSize;
	}
	/**
	  * 关于方法的描述： 显示尾页
	  */
	public void last() {
		currentPage = totalPages;
		startRow = (currentPage - 1) * pageSize;
	}
	/**
	  * 关于方法的描述：刷新pager对象
	  * @param _currentPage 
	  */
	public void refresh(int _currentPage) {
		currentPage = _currentPage;
		if (currentPage > totalPages) {
			last();
		}
		else if (currentPage <= 0) {
            first();
        }//end if
		else {
		    startRow = (currentPage - 1) * pageSize;
        }//end else
		
	}
	public int getStartRow() {
		return startRow;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRows() {
		return totalRows;
	}
    /**
     * @return Returns the elements.
     */
    public List getElements()
    {
        return elements;
    }
    /**
     * @param elements The elements to set.
     */
    public void setElements(List elements)
    {
        this.elements = elements;
    }
}
