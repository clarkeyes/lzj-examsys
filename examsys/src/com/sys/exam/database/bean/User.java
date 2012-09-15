package com.sys.exam.database.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * User generated by MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable
{

    // Fields

    private long userId;

    private String userName;

    private String userAccount;

    private String userPassword;

    private Integer userRole;

    private String usermail;

    private Set userExams = new HashSet(0);

    private Set userGroupRels = new HashSet(0);

    // Constructors

    /** default constructor */
    public User()
    {
    }

    /** minimal constructor */
    public User(String userName, String userAccount, String userPassword,
            Integer userRole)
    {
        this.userName = userName;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }

    /** full constructor */
    public User(String userName, String userAccount, String userPassword,
            Integer userRole, String usermail, Set userExams, Set userGroupRels)
    {
        this.userName = userName;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userRole = userRole;
        this.usermail = usermail;
        this.userExams = userExams;
        this.userGroupRels = userGroupRels;
    }

    // Property accessors

    public long getUserId()
    {
        return this.userId;
    }

    public void setUserId(long userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserAccount()
    {
        return this.userAccount;
    }

    public void setUserAccount(String userAccount)
    {
        this.userAccount = userAccount;
    }

    public String getUserPassword()
    {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword)
    {
        this.userPassword = userPassword;
    }

    public Integer getUserRole()
    {
        return this.userRole;
    }

    public void setUserRole(Integer userRole)
    {
        this.userRole = userRole;
    }

    public String getUsermail()
    {
        return this.usermail;
    }

    public void setUsermail(String usermail)
    {
        this.usermail = usermail;
    }

    public Set getUserExams()
    {
        return this.userExams;
    }

    public void setUserExams(Set userExams)
    {
        this.userExams = userExams;
    }

    public Set getUserGroupRels()
    {
        return this.userGroupRels;
    }

    public void setUserGroupRels(Set userGroupRels)
    {
        this.userGroupRels = userGroupRels;
    }

}