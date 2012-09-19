package com.sys.exam.service.impl;

import com.sys.exam.database.dao.ExamCateRatioDao;
import com.sys.exam.database.dao.ExamDao;
import com.sys.exam.database.dao.ExamQuesTypeDao;
import com.sys.exam.database.dao.OptionsDao;
import com.sys.exam.database.dao.QuestionBaseDao;
import com.sys.exam.database.dao.QuestionCategoryDao;
import com.sys.exam.database.dao.QuestionTypeDao;
import com.sys.exam.database.dao.QuestionsDao;
import com.sys.exam.database.dao.UserDao;
import com.sys.exam.database.dao.UserExamDao;
import com.sys.exam.database.dao.UserGroupDao;
import com.sys.exam.database.dao.UserGroupRelDao;
import com.sys.exam.database.dao.UserQuestionDao;
import com.sys.exam.service.ManagerService;

public class ManagerServiceImpl implements ManagerService
{
    private ExamDao examDao;
    private OptionsDao optionsDao;
    private QuestionBaseDao questionBaseDao;
    private QuestionCategoryDao questionCategoryDao;
    private  QuestionsDao  questionsDao;
    private UserDao userDao;
    private UserExamDao userExamDao;
    private UserGroupDao userGroupDao;
    private UserGroupRelDao userGroupRelDao;
    private UserQuestionDao userQuestionDao;
    private ExamCateRatioDao examCateRatioDao;
    private ExamQuesTypeDao examQuesTypeDao;
    private QuestionTypeDao questionTypeDao;
    
    /**
     * @return Returns the examCateRatioDao.
     */
    public ExamCateRatioDao getExamCateRatioDao()
    {
        return examCateRatioDao;
    }
    /**
     * @param examCateRatioDao The examCateRatioDao to set.
     */
    public void setExamCateRatioDao(ExamCateRatioDao examCateRatioDao)
    {
        this.examCateRatioDao = examCateRatioDao;
    }
    /**
     * @return Returns the examQuesTypeDao.
     */
    public ExamQuesTypeDao getExamQuesTypeDao()
    {
        return examQuesTypeDao;
    }
    /**
     * @param examQuesTypeDao The examQuesTypeDao to set.
     */
    public void setExamQuesTypeDao(ExamQuesTypeDao examQuesTypeDao)
    {
        this.examQuesTypeDao = examQuesTypeDao;
    }
    /**
     * @return Returns the questionTypeDao.
     */
    public QuestionTypeDao getQuestionTypeDao()
    {
        return questionTypeDao;
    }
    /**
     * @param questionTypeDao The questionTypeDao to set.
     */
    public void setQuestionTypeDao(QuestionTypeDao questionTypeDao)
    {
        this.questionTypeDao = questionTypeDao;
    }
    /**
     * @return Returns the examDao.
     */
    public ExamDao getExamDao()
    {
        return examDao;
    }
    /**
     * @param examDao The examDao to set.
     */
    public void setExamDao(ExamDao examDao)
    {
        this.examDao = examDao;
    }
    
    /**
     * @return Returns the optionsDao.
     */
    public OptionsDao getOptionsDao()
    {
        return optionsDao;
    }
    /**
     * @param optionsDao The optionsDao to set.
     */
    public void setOptionsDao(OptionsDao optionsDao)
    {
        this.optionsDao = optionsDao;
    }
    /**
     * @return Returns the questionBaseDao.
     */
    public QuestionBaseDao getQuestionBaseDao()
    {
        return questionBaseDao;
    }
    /**
     * @param questionBaseDao The questionBaseDao to set.
     */
    public void setQuestionBaseDao(QuestionBaseDao questionBaseDao)
    {
        this.questionBaseDao = questionBaseDao;
    }
    /**
     * @return Returns the questionCategoryDao.
     */
    public QuestionCategoryDao getQuestionCategoryDao()
    {
        return questionCategoryDao;
    }
    /**
     * @param questionCategoryDao The questionCategoryDao to set.
     */
    public void setQuestionCategoryDao(QuestionCategoryDao questionCategoryDao)
    {
        this.questionCategoryDao = questionCategoryDao;
    }
    /**
     * @return Returns the questionsDao.
     */
    public QuestionsDao getQuestionsDao()
    {
        return questionsDao;
    }
    /**
     * @param questionsDao The questionsDao to set.
     */
    public void setQuestionsDao(QuestionsDao questionsDao)
    {
        this.questionsDao = questionsDao;
    }
    /**
     * @return Returns the userDao.
     */
    public UserDao getUserDao()
    {
        return userDao;
    }
    /**
     * @param userDao The userDao to set.
     */
    public void setUserDao(UserDao userDao)
    {
        this.userDao = userDao;
    }
    /**
     * @return Returns the userExamDao.
     */
    public UserExamDao getUserExamDao()
    {
        return userExamDao;
    }
    /**
     * @param userExamDao The userExamDao to set.
     */
    public void setUserExamDao(UserExamDao userExamDao)
    {
        this.userExamDao = userExamDao;
    }
    /**
     * @return Returns the userGroupDao.
     */
    public UserGroupDao getUserGroupDao()
    {
        return userGroupDao;
    }
    /**
     * @param userGroupDao The userGroupDao to set.
     */
    public void setUserGroupDao(UserGroupDao userGroupDao)
    {
        this.userGroupDao = userGroupDao;
    }
    /**
     * @return Returns the userGroupRelDao.
     */
    public UserGroupRelDao getUserGroupRelDao()
    {
        return userGroupRelDao;
    }
    /**
     * @param userGroupRelDao The userGroupRelDao to set.
     */
    public void setUserGroupRelDao(UserGroupRelDao userGroupRelDao)
    {
        this.userGroupRelDao = userGroupRelDao;
    }
    /**
     * @return Returns the userQuestionDao.
     */
    public UserQuestionDao getUserQuestionDao()
    {
        return userQuestionDao;
    }
    /**
     * @param userQuestionDao The userQuestionDao to set.
     */
    public void setUserQuestionDao(UserQuestionDao userQuestionDao)
    {
        this.userQuestionDao = userQuestionDao;
    }
}
