/**
 * ProjectName: examsyssvn
 * Date: May 17, 2013
 *
 */

package com.sys.exam.action.user;

import java.util.List;

import com.sys.common.logtool.LoggerTool;
import com.sys.exam.action.ModelAction;
import com.sys.exam.database.bean.User;
import com.sys.exam.database.model.UqType;
import com.sys.exam.database.model.UserExamModel;
import com.sys.exam.service.UserExamService;
import com.sys.exam.service.UserQuestionService;
import com.sys.exam.util.Constant;

/**
 * <p>Title: CheckAnswerAction.java</p>
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

public class CheckAnswerAction extends ModelAction {
	/**用户测试id*/
	private Long ueId;
    /**用户考试信息*/
    private UserExamModel ueM;
    /**题目分类*/
    private List<UqType> uqTypeList;
    /**操作标志*/
    private int reStart;
    @Override
    public String execute() throws Exception {
    	 User user=(User)session.get(Constant.USER);//当前登录用户
         UserExamService ueService=serviceManager.getUserExamService();
         UserQuestionService uqService=serviceManager.getUserQuestionService();
     	try {
     		ueM=ueService.findUeMById(ueId,reStart);
     		uqTypeList=uqService.findUqTypeList(ueId);
 			result="success";
 			return SUCCESS;
 		} catch (Exception e) {
 			LoggerTool.m_logger.warn("用户考试试题信息异常", e);
 			return INPUT;
 		}
    }
	public Long getUeId() {
		return ueId;
	}
	public void setUeId(Long ueId) {
		this.ueId = ueId;
	}
	public UserExamModel getUeM() {
		return ueM;
	}
	public void setUeM(UserExamModel ueM) {
		this.ueM = ueM;
	}
	public List<UqType> getUqTypeList() {
		return uqTypeList;
	}
	public void setUqTypeList(List<UqType> uqTypeList) {
		this.uqTypeList = uqTypeList;
	}
	public int getReStart() {
		return reStart;
	}
	public void setReStart(int reStart) {
		this.reStart = reStart;
	}
    
}
