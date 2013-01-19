package com.sys.exam.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sys.exam.service.impl.ServiceManager;
/**
 * @author zhangshaoju
 *
 * @param <Model>
 */
@SuppressWarnings("hiding")
public class ModelAction extends ActionSupport implements
        ServletRequestAware, ServletContextAware,SessionAware
{
    private static final long serialVersionUID = -8666333588376599236L;
    
    /**action处理结果*/
    protected String result;  //保存处理结果的信息
    /**请求*/
    protected HttpServletRequest request;
    /**登录用户session*/
    @SuppressWarnings("unchecked")
    protected Map session;
    protected ServletContext context;
    /**service工厂*/
    protected ServiceManager serviceManager;

    public void setServletContext(ServletContext context){
        this.context = context;         
    }

    public void setServletRequest(HttpServletRequest request){
        this.request = request;   
    }
    

    public void setSession(Map<String,Object> session)
    {
        this.session = session;
    }

    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }


    public void setServiceManager(ServiceManager serviceManager)
    {
        this.serviceManager = serviceManager;
    }
    
}
