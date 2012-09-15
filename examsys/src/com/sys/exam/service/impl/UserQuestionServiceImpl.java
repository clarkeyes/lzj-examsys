package com.sys.exam.service.impl;

import com.sys.exam.service.ManagerService;
import com.sys.exam.service.UserQuestionService;

/**
 * UserQuestion generated by MyEclipse Persistence Tools
 */

public class UserQuestionServiceImpl implements UserQuestionService 
{

    private ManagerService managerService;

    /**
     * @return Returns the managerService.
     */
    public ManagerService getManagerService()
    {
        return managerService;
    }

    /**
     * @param managerService The managerService to set.
     */
    public void setManagerService(ManagerService managerService)
    {
        this.managerService = managerService;
    } 

}