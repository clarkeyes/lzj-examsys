package com.sys.exam.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.sys.common.logtool.LoggerTool;
import com.sys.exam.database.Pager;
import com.sys.exam.database.bean.Exam;
import com.sys.exam.database.bean.ExamCateRatio;
import com.sys.exam.database.bean.ExamQuesType;
import com.sys.exam.database.bean.Options;
import com.sys.exam.database.bean.QuestionBase;
import com.sys.exam.database.bean.QuestionCategory;
import com.sys.exam.database.bean.QuestionType;
import com.sys.exam.database.bean.Questions;
import com.sys.exam.database.bean.UserExam;
import com.sys.exam.database.bean.UserQuestion;
import com.sys.exam.database.model.ExamModel;
import com.sys.exam.database.model.QcModel;
import com.sys.exam.database.model.QuesType;
import com.sys.exam.database.model.UqModel;
import com.sys.exam.database.model.UqType;
import com.sys.exam.service.ExamService;
import com.sys.exam.service.ManagerService;
import com.sys.exam.util.Constant;
import com.sys.exam.util.DateOperator;

/**
 * Exam generated by MyEclipse Persistence Tools
 */

public class ExamServiceImpl implements ExamService
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

    @Override
    public Pager findExamList(Pager pager) throws Exception
    {
        StringBuilder hsql = new StringBuilder();
        hsql.append("from Exam exam");
        List<Exam> examList = managerService.getExamDao().find(hsql.toString());
        List<ExamModel> examModelList = new ArrayList<ExamModel>();
        for (Exam exam : examList)
        {
            ExamModel em = new ExamModel();
            em.setExamId(exam.getExamId());
            em.setExamName(exam.getExamName());
            em.setExamTime(exam.getExamTime());
            if (null != exam.getUserExams())
            {
                em.setUserNum(exam.getUserExams().size());
            }
            examModelList.add(em);
        }
        // 分页
        int pageBegin = (pager.getCurrentPage() - 1) * pager.getPageSize();
        int pageEnd = pageBegin + pager.getPageSize();
        int total = examModelList.size();
        if (pageEnd > total)
            pageEnd = total;
        Pager p = new Pager(total, pager.getPageSize());
        p.setElements(examModelList.subList(pageBegin, pageEnd));
        return p;
    }


	@Override
	public String deleteExam(Long examId) throws Exception {
		managerService.getExamDao().deleteByKey(examId);
		return null;
	}
   
    @Override
    public String addExam(String examName, Long qbId, List<QcModel> qcs,
            List<QuesType> typeList) throws Exception
    {
        String ret = null;
        //  判断各种题型数量是否超过题库中数量
        // 创建考试
        Exam exam = new Exam();
        exam.setExamName(examName);
        exam.setExamTime(Constant.EXAM_TIME);
        QuestionBase qb=new QuestionBase();
        qb.setQbId(qbId);
        exam.setQuestionBase(qb);
        exam.setExamCreateTime(DateOperator
                .getCurrentTime(Constant.DATE_FORMAT));
        managerService.getExamDao().save(exam);
        
        List<ExamQuesType> listeqts=new ArrayList<ExamQuesType>();
        List<ExamCateRatio> listcrs=new ArrayList<ExamCateRatio>();
        //保存题型比例
        ExamQuesType eqt=null;
        for (QuesType qt : typeList) {
        	eqt=new ExamQuesType();
        	eqt.setEqtNum(qt.getNum());
        	eqt.setEqtValue(qt.getScore());
        	eqt.setExam(exam);
        	QuestionType qtt=new QuestionType();
        	qtt.setQtId(qt.getType());
        	eqt.setQuestionType(qtt);
        	listeqts.add(eqt);
		}
        
        //保存分类比例
        ExamCateRatio ecr=null;
        for (QcModel qcm : qcs) {
        	ecr=new ExamCateRatio();
        	ecr.setExam(exam);
        	ecr.setEcrRatio(qcm.getQcRatio());
        	QuestionCategory qctmp=new QuestionCategory();
        	qctmp.setQcId(qcm.getQcId());
        	ecr.setQuestionCategory(qctmp);
        	listcrs.add(ecr);
		}
        
       
        // 添加到数据库
        managerService.getExamQuesTypeDao().saveOrUpdateAll(listeqts);
        managerService.getExamCateRatioDao().saveOrUpdateAll(listcrs);
        return ret;
    }

   

	@Override
	public List<UqType> findEqTypeList(long examId) throws Exception {
	  
        List<UqType> listUqTypes = new ArrayList<UqType>();

        return listUqTypes;
	}

	@Override
	public Exam findExamById(long examId) throws Exception {
	    Exam exam=managerService.getExamDao().get(examId);
		return exam;
	}

}
