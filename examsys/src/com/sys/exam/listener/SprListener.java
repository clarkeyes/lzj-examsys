
package com.sys.exam.listener;

import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * <p>Title: VmmListener.java</p>
 * <p>Description: spring上下文环境  </p>
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

public class SprListener extends ContextLoaderListener
{
    /**
    * spring上下文环境   
    */
    private static ApplicationContext applicationContext;

    public void contextInitialized(ServletContextEvent event)
    {
        super.contextInitialized(event);
        applicationContext = WebApplicationContextUtils
                .getRequiredWebApplicationContext(event.getServletContext());
    }

    public static Object getBean(String beanName)
    {
        return applicationContext.getBean(beanName);
    }

}
