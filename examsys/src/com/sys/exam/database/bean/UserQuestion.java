package com.sys.exam.database.bean;

/**
 * UserQuestion generated by MyEclipse Persistence Tools
 */

public class UserQuestion implements java.io.Serializable
{

    // Fields

  

	private long uqId;

    private UserExam userExam;

    private Integer uqAnswer;

    private Questions questions;

   

	private Integer uqSign;

    private float uqValue;

    private String uqSubjectiveAnswer;

    // Constructors

    /** default constructor */
    public UserQuestion()
    {
    }

    /** minimal constructor */
    public UserQuestion(UserExam userExam, Questions questions, Integer uqSign,
            float uqValue)
    {
        this.userExam = userExam;
        this.questions = questions;
        this.uqSign = uqSign;
        this.uqValue = uqValue;
    }

    /** full constructor */
    public UserQuestion(UserExam userExam, Integer uqAnswer, Questions questions,
            Integer uqSign, float uqValue, String uqSubjectiveAnswer)
    {
        this.userExam = userExam;
        this.uqAnswer = uqAnswer;
        this.questions = questions;
        this.uqSign = uqSign;
        this.uqValue = uqValue;
        this.uqSubjectiveAnswer = uqSubjectiveAnswer;
    }

    // Property accessors
    public Questions getQuestions() {
  		return questions;
  	}

  	public void setQuestions(Questions questions) {
  		this.questions = questions;
  	}
  	
  	
    public long getUqId()
    {
        return this.uqId;
    }

    public void setUqId(long uqId)
    {
        this.uqId = uqId;
    }

    public UserExam getUserExam()
    {
        return this.userExam;
    }

    public void setUserExam(UserExam userExam)
    {
        this.userExam = userExam;
    }

    public Integer getUqAnswer()
    {
        return this.uqAnswer;
    }

    public void setUqAnswer(Integer uqAnswer)
    {
        this.uqAnswer = uqAnswer;
    }


    public Integer getUqSign()
    {
        return this.uqSign;
    }

    public void setUqSign(Integer uqSign)
    {
        this.uqSign = uqSign;
    }

    public float getUqValue()
    {
        return this.uqValue;
    }

    public void setUqValue(float uqValue)
    {
        this.uqValue = uqValue;
    }

    public String getUqSubjectiveAnswer()
    {
        return this.uqSubjectiveAnswer;
    }

    public void setUqSubjectiveAnswer(String uqSubjectiveAnswer)
    {
        this.uqSubjectiveAnswer = uqSubjectiveAnswer;
    }

}