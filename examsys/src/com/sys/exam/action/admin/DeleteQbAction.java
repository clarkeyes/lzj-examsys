/**
 * ProjectName: examsyssvn
 * Date: May 13, 2013
 *
 */

package com.sys.exam.action.admin;

import com.sys.common.logtool.LoggerTool;
import com.sys.exam.action.ModelAction;
import com.sys.exam.service.QuestionBaseService;

/**
 * <p>Title: DeleteQbAction.java</p>
 * <p>Description: 删除题库 </p>
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

public class DeleteQbAction extends ModelAction {
	/**题库id*/
	private long qbId;
	@Override
	public String execute() throws Exception {
		try {
			QuestionBaseService qbService=serviceManager.getQuestionBaseService();
			qbService.deleteQb(qbId);
			result="success";
			return SUCCESS;
		} catch (Exception e) {
			LoggerTool.m_logger.warn("删除题库失败", e);
			result="删除题库失败";
			return INPUT;
		}
		
	}
	public long getQbId() {
		return qbId;
	}
	public void setQbId(long qbId) {
		this.qbId = qbId;
	}
	
}
