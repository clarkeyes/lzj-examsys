/**
 * 
 */
package com.sys.exam.action.admin;

import java.util.List;

import com.sys.exam.action.ModelAction;
import com.sys.exam.service.UserExamService;
import com.sys.exam.util.Constant;

/**
 * @author Administrator
 *
 */
public class StartUserExamAction extends ModelAction {
	private List<Long> ueIdList;
	@Override
	public String execute() throws Exception {
		try {
			UserExamService ueService=serviceManager.getUserExamService();
			String ret=ueService.updateUesState(ueIdList,Constant.EXAM_STATE_START);
			if(null==ret){
				result="success";
			}else{
				result=ret;
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			result="系统错误";
			return INPUT;
		}
		
	}
	public List<Long> getUeIdList() {
		return ueIdList;
	}
	public void setUeIdList(List<Long> ueIdList) {
		this.ueIdList = ueIdList;
	}
	
}
