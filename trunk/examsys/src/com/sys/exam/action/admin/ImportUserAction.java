/**
 * 
 */
package com.sys.exam.action.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.sys.exam.action.ModelAction;
import com.sys.exam.service.UserService;
import com.sys.exam.util.Constant;

/**
 * @author Administrator
 *
 */
public class ImportUserAction extends ModelAction {
	/**要上传的表格文件*/
    private File userFile;
    @Override
    public String execute() throws Exception {
    	String storeFileName = Constant.strProPath+Constant.TEMP_USERfILE;
        File storeFile = new File(storeFileName); 
        if(storeFile.exists()){
            storeFile.delete();
        }
        if(userFile.length()>Constant.MAXIMUM){
            result="文件太大";//文件大小超过范围
            return INPUT;
        }
        FileOutputStream fos=null;
        FileInputStream fis=null;
        try {      
            fos = new FileOutputStream(storeFile);      
            fis = new FileInputStream(userFile); 
            byte[] b = new byte[1024 * 5];
            int len;
            while ((len = fis.read(b)) != -1) {//将文件写入服务器的指定位置      
                fos.write(b, 0, len);      
                fos.flush();      
            }      
            UserService userService=serviceManager.getUserService();
            String ret = userService.addImportUsers(storeFileName);//把表格导入到数据库
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
	public File getUserFile() {
		return userFile;
	}
	public void setUserFile(File userFile) {
		this.userFile = userFile;
	}
    
}
