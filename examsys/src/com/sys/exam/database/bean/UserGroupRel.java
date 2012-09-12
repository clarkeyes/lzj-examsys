package com.sys.exam.database.bean;

/**
 * UserGroupRel generated by MyEclipse Persistence Tools
 */

public class UserGroupRel implements java.io.Serializable
{

    // Fields

    private long ugrId;

    private UserGroup userGroup;

    private User user;

    // Constructors

    /** default constructor */
    public UserGroupRel()
    {
    }

    /** full constructor */
    public UserGroupRel(UserGroup userGroup, User user)
    {
        this.userGroup = userGroup;
        this.user = user;
    }

    // Property accessors

    public long getUgrId()
    {
        return this.ugrId;
    }

    public void setUgrId(long ugrId)
    {
        this.ugrId = ugrId;
    }

    public UserGroup getUserGroup()
    {
        return this.userGroup;
    }

    public void setUserGroup(UserGroup userGroup)
    {
        this.userGroup = userGroup;
    }

    public User getUser()
    {
        return this.user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

}