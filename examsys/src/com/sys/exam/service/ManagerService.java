package com.sys.exam.service;

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

public interface ManagerService
{
    /**
     * @return Returns the examDao.
     */
    public ExamDao getExamDao();
   
   
    
    
    /**
     * @return Returns the optionsDao.
     */
    public OptionsDao getOptionsDao();
    
    /**
     * @return Returns the questionBaseDao.
     */
    public QuestionBaseDao getQuestionBaseDao();
    
    /**
     * @return Returns the questionCategoryDao.
     */
    public QuestionCategoryDao getQuestionCategoryDao();
    
    /**
     * @return Returns the questionsDao.
     */
    public QuestionsDao getQuestionsDao();
   
    /**
     * @return Returns the userDao.
     */
    public UserDao getUserDao();
   
    /**
     * @return Returns the userExamDao.
     */
    public UserExamDao getUserExamDao();
   
    /**
     * @return Returns the userGroupDao.
     */
    public UserGroupDao getUserGroupDao();
    
    /**
     * @return Returns the userGroupRelDao.
     */
    public UserGroupRelDao getUserGroupRelDao();
    
    /**
     * @return Returns the userQuestionDao.
     */
    public UserQuestionDao getUserQuestionDao();
    
    
    /**
     * @return Returns the examCateRatioDao.
     */
    public ExamCateRatioDao getExamCateRatioDao();
    /**
     * @return Returns the examQuesTypeDao.
     */
    public ExamQuesTypeDao getExamQuesTypeDao();
    /**
     * @return Returns the questionTypeDao.
     */
    public QuestionTypeDao getQuestionTypeDao();
   
}
