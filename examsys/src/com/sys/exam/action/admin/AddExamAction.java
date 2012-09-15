/**
 * 
 */
package com.sys.exam.action.admin;

import java.util.List;

import com.sys.exam.action.ModelAction;
import com.sys.exam.database.bean.QuestionCategory;
import com.sys.exam.database.model.QcModel;
import com.sys.exam.database.model.QuesType;
import com.sys.exam.service.ExamService;

/**
 * @author Administrator
 *
 */
public class AddExamAction extends ModelAction {
	private String examName;
	private Long qbId;
	private List<QcModel> qcs;
	private List<QuesType> typeList;
	@Override
	public String execute() throws Exception {
		
		try {
			ExamService examService=serviceManager.getExamService();
			if((null!=qcs)&&(null!=typeList)){
				String ret=examService.addExam(examName,qbId,qcs,typeList);
				if(null==ret){
					result="success";
				}else{
					result=ret;
				}
			}else{
				result="类别比例或题型的内容为空";
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			result="系统错误";
			return INPUT;
		}
	}
	

	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public Long getQbId() {
		return qbId;
	}
	public void setQbId(Long qbId) {
		this.qbId = qbId;
	}
	public List<QuesType> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<QuesType> typeList) {
		this.typeList = typeList;
	}


	public List<QcModel> getQcs() {
		return qcs;
	}


	public void setQcs(List<QcModel> qcs) {
		this.qcs = qcs;
	}
	
}
