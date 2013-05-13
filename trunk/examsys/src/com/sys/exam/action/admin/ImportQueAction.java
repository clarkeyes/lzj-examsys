/**
 * ProjectName: examsyssvn
 * Date: May 13, 2013
 *
 */

package com.sys.exam.action.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;

import com.sys.exam.action.ModelAction;
import com.sys.exam.service.QuestionBaseService;
import com.sys.exam.service.QuestionsService;
import com.sys.exam.util.Constant;

/**
 * <p>Title: ImportQueAction.java</p>
 * <p>Description:  导入题目文件</p>
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

public class ImportQueAction extends ModelAction {
	/**要上传的文件*/
    private File queBaseFile;
    /**题库名称*/
    private String qcName;
    /**题库id*/
    private long qbId;
    @Override
    public String execute() throws Exception {
    	String storeFileName = Constant.strProPath+"queBase.doc";
        File storeFile = new File(storeFileName); 
        if(storeFile.exists()){
            storeFile.delete();
        }
        if(queBaseFile.length()>Constant.MAXIMUM){
            result="文件太大";//文件大小超过范围
            return INPUT;
        }
        FileOutputStream fos=null;
        FileInputStream fis=null;
        try {      
            fos = new FileOutputStream(storeFile);      
            fis = new FileInputStream(queBaseFile); 
            byte[] b = new byte[1024 * 5];
            int len;
            while ((len = fis.read(b)) != -1) {//将文件写入服务器的指定位置      
                fos.write(b, 0, len);      
                fos.flush();      
            }      
            QuestionsService queService=serviceManager.getQuestionsService();
            qcName=URLDecoder.decode(qcName,"utf-8");
            String ret=queService.addQue(storeFileName,qcName,qbId);
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
        } finally {      
            try {fos.close(); } catch (IOException e) {e.printStackTrace();}   
            try {fis.close(); } catch (IOException e) {e.printStackTrace();}   
        } 
    }
	public File getQueBaseFile() {
		return queBaseFile;
	}
	public void setQueBaseFile(File queBaseFile) {
		this.queBaseFile = queBaseFile;
	}
	public String getQcName() {
		return qcName;
	}
	public void setQcName(String qcName) {
		this.qcName = qcName;
	}
	public long getQbId() {
		return qbId;
	}
	public void setQbId(long qbId) {
		this.qbId = qbId;
	}
    
}
