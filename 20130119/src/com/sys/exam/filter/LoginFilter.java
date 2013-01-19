package com.sys.exam.filter;



import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sys.common.logtool.LoggerTool;
import com.sys.exam.database.bean.User;



/**
 * <p>Title: LoginFilter.java</p>
 * <p>Description: 登录过滤类，用户在没有登录或者登录后长时间没有操作，就会被
 * 过滤到主页面重新登录 </p>
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
public class LoginFilter implements Filter
{
	public void destroy()
	{

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws ServletException, IOException
	{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		User user = null;
		user = (User) session.getAttribute("user");
		if (user == null)
		{
		 LoggerTool.m_logger.info("过滤器操作");
			    java.io.PrintWriter out = response.getWriter();   
			    out.println("<html>");   
			    out.println("<script>");   
			    out.println("window.open ('"+req.getContextPath()+"/login.jsp','_top')");   
			    out.println("</script>");   
			    out.println("</html>");   
		} else
		{
			chain.doFilter(req, res);
		}
	}

	public void init(FilterConfig arg0) throws ServletException
	{

	}

}
