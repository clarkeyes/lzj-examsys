package com.sys.exam.service.impl;

import com.sys.exam.service.ExamQuestionService;
import com.sys.exam.service.ExamService;
import com.sys.exam.service.OptionsService;
import com.sys.exam.service.QuestionBaseService;
import com.sys.exam.service.QuestionCategoryService;
import com.sys.exam.service.QuestionsService;
import com.sys.exam.service.UserExamService;
import com.sys.exam.service.UserGroupService;
import com.sys.exam.service.UserQuestionService;
import com.sys.exam.service.UserService;

public class ServiceManager {
	private ExamQuestionService examQuestionService;
	private ExamService examService;
	private OptionsService optionsService;
	private QuestionBaseService questionBaseService;
	private QuestionCategoryService questionCategoryService;
	private QuestionsService questionsService;
	private UserExamService userExamService;
	private UserGroupService userGroupService;
	private UserQuestionService userQuestionService;
	private UserService userService;
	public ExamQuestionService getExamQuestionService() {
		return examQuestionService;
	}
	public void setExamQuestionService(ExamQuestionService examQuestionService) {
		this.examQuestionService = examQuestionService;
	}
	public ExamService getExamService() {
		return examService;
	}
	public void setExamService(ExamService examService) {
		this.examService = examService;
	}
	public OptionsService getOptionsService() {
		return optionsService;
	}
	public void setOptionsService(OptionsService optionsService) {
		this.optionsService = optionsService;
	}
	public QuestionBaseService getQuestionBaseService() {
		return questionBaseService;
	}
	public void setQuestionBaseService(QuestionBaseService questionBaseService) {
		this.questionBaseService = questionBaseService;
	}
	public QuestionCategoryService getQuestionCategoryService() {
		return questionCategoryService;
	}
	public void setQuestionCategoryService(
			QuestionCategoryService questionCategoryService) {
		this.questionCategoryService = questionCategoryService;
	}
	public QuestionsService getQuestionsService() {
		return questionsService;
	}
	public void setQuestionsService(QuestionsService questionsService) {
		this.questionsService = questionsService;
	}
	public UserExamService getUserExamService() {
		return userExamService;
	}
	public void setUserExamService(UserExamService userExamService) {
		this.userExamService = userExamService;
	}
	public UserGroupService getUserGroupService() {
		return userGroupService;
	}
	public void setUserGroupService(UserGroupService userGroupService) {
		this.userGroupService = userGroupService;
	}
	public UserQuestionService getUserQuestionService() {
		return userQuestionService;
	}
	public void setUserQuestionService(UserQuestionService userQuestionService) {
		this.userQuestionService = userQuestionService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
