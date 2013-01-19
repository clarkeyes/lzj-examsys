package com.sys.exam.database.bean;

/**
 * Options generated by MyEclipse Persistence Tools
 */

public class Options implements java.io.Serializable
{

    // Fields

    private long optionId;

    private Questions questions;

    private String optionDes;

    private Integer optionOrder;

    // Constructors

    /** default constructor */
    public Options()
    {
    }

    /** full constructor */
    public Options(Questions questions, String optionDes, Integer optionOrder)
    {
        this.questions = questions;
        this.optionDes = optionDes;
        this.optionOrder = optionOrder;
    }

    // Property accessors

    public long getOptionId()
    {
        return this.optionId;
    }

    public void setOptionId(long optionId)
    {
        this.optionId = optionId;
    }

    public Questions getQuestions()
    {
        return this.questions;
    }

    public void setQuestions(Questions questions)
    {
        this.questions = questions;
    }

    public String getOptionDes()
    {
        return this.optionDes;
    }

    public void setOptionDes(String optionDes)
    {
        this.optionDes = optionDes;
    }

    public Integer getOptionOrder()
    {
        return this.optionOrder;
    }

    public void setOptionOrder(Integer optionOrder)
    {
        this.optionOrder = optionOrder;
    }

}