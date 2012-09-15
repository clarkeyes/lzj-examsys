package com.sys.exam.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Session;

import com.sys.common.logtool.LoggerTool;




/**
 * <p>Title: SessionCloseFilter.java</p>
 * <p>Description:  关闭session过滤器</p>
 *
 * <p>Copyright: Copyright (c) 2009 by 
 * Shanghai hwellzen, Shanghai, China
 *                  All rights reserved.</p>
 * <p>Company: Hwellzen</p>
 * @author liuzj
 * @version 1.0
 * @see 
 *
 * <PRE>
 * <U>Updated by:</U>   auther, date
 * <U>Description:</U>  Update description
 * </PRE>
 */
public class SessionCloseFilter implements Filter
{	
    
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	
	public void destroy() {
		// 
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException 
	{
		 try 
		 {     
			 chain.doFilter(request, response); 
			 
		 } 
		 finally 
		 { 
		     Session session = (Session) threadLocal.get();
		        threadLocal.set(null);

		        if (session != null) 
		        {
		            session.close();
		            LoggerTool.m_logger.info("关闭hibernate session");
		        }
			 
		 }
		
	}

	
	public void init(FilterConfig arg0) throws ServletException {
		// 
		
	}

}
