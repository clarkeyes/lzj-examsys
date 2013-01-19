/**
 * 
 */
package com.sys.exam.action.admin;

import com.sys.exam.action.ModelAction;
import com.sys.exam.service.UserGroupService;

/**
 * @author Administrator
 *
 */
public class DeleteUgAction extends ModelAction {
	private Long ugId;
	@Override
	public String execute() throws Exception {
		try {
			UserGroupService ugService=serviceManager.getUserGroupService();
			String ret=ugService.deleteUgById(ugId);
			if(null==ret){
				result="success";
			}else{
				result=ret;
			}
			return SUCCESS;
		} catch (RuntimeException e) {
			e.printStackTrace();
			result="删除用户组失败";
			return INPUT;
		}
		
	}
	public Long getUgId() {
		return ugId;
	}
	public void setUgId(Long ugId) {
		this.ugId = ugId;
	}
	
}
