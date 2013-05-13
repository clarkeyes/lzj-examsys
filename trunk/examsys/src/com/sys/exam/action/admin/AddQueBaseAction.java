/**
 * ProjectName: examsyssvn
 * Date: May 11, 2013
 *
 */

package com.sys.exam.action.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;

import com.sys.exam.action.ModelAction;
import com.sys.exam.database.bean.QuestionBase;
import com.sys.exam.service.QuestionBaseService;
import com.sys.exam.service.UserService;
import com.sys.exam.util.Constant;

/**
 * <p>Title: AddQueBaseAction.java</p>
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

public class AddQueBaseAction extends ModelAction {
    /**题库名称*/
    private String queBaseName;
    @Override
    public String execute() throws Exception {
        try {      
            QuestionBaseService queBaseService=serviceManager.getQuestionBaseService();
            queBaseName=URLDecoder.decode(queBaseName,"utf-8");
            String ret = queBaseService.addQueBase(queBaseName);//把表格导入到数据库
            if(null==ret){
            	result="success";
            }else{
            	result = ret;
            }
            return SUCCESS;
        } catch (IOException e) {      
            e.printStackTrace();   
            result="系统错误";
            return INPUT;
        } 
    }
	public String getQueBaseName() {
		return queBaseName;
	}
	public void setQueBaseName(String queBaseName) {
		this.queBaseName = queBaseName;
	}
    
}
