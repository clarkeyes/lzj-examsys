package com.sys.exam.service.impl;

import com.sys.exam.service.ManagerService;
import com.sys.exam.service.UserExamService;


/**
 * UserExam generated by MyEclipse Persistence Tools
 */

public class UserExamServiceImpl implements UserExamService 
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