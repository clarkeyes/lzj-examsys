package com.sys.exam.util;

import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sys.common.logtool.LoggerTool;
import com.sys.exam.database.bean.Options;
import com.sys.exam.database.bean.QuestionBase;
import com.sys.exam.database.bean.QuestionCategory;
import com.sys.exam.database.bean.QuestionType;
import com.sys.exam.database.bean.Questions;
import com.sys.exam.database.dao.QuestionBaseDao;
import com.sys.exam.database.dao.QuestionCategoryDao;
import com.sys.exam.listener.SprListener;
import com.sys.exam.service.ManagerService;
import com.sys.exam.service.OptionsService;
import com.sys.exam.service.QuestionCategoryService;
import com.sys.exam.service.QuestionsService;

public class DocTool
{
    private Hashtable<String, String> hashCategory = new Hashtable<String, String>();

    private ManagerService managerService;

    private QuestionCategoryService questionCategoryService;

    private QuestionsService questionsService;
    
    private OptionsService optionsService;
    
    private long qbId;

    public DocTool(long qbId,String qcName)
    {
        hashCategory.put(qcName, qcName);

//        ApplicationContext context = new ClassPathXmlApplicationContext(
//                "applicationContext-*.xml");
        managerService = (ManagerService) SprListener.getBean("managerService");
        questionCategoryService = (QuestionCategoryService) SprListener
                .getBean("questionCategoryService");

        questionsService = (QuestionsService) SprListener
                .getBean("questionsService");
        
        optionsService=(OptionsService) SprListener
        .getBean("optionsService");
        this.qbId=qbId;

    }

    public void analyseQuestionbase(String filePath) throws Exception
    {

        QuestionBaseDao qbd = managerService.getQuestionBaseDao();
        QuestionCategoryDao qcd = managerService.getQuestionCategoryDao();

        QuestionBase qb = qbd.get(qbId);
        QuestionCategory qc = null;
        Questions que = null;
        Set<Options> setOptions = new HashSet<Options>();

        FileInputStream in = new FileInputStream(filePath);
        WordExtractor extractor = new WordExtractor(in);

        String[] strArray = extractor.getParagraphText();
        String str = extractor.getText();
        
        int questioncount=0;
        for (int i = 0; i < strArray.length; ++i)
        {
            String line = strArray[i].trim();
            //System.out.println(line);
            // 判断当前行是否是分类行
            if (hashCategory.containsKey(line))
            {
                if (qc!=null)
                {
                    LoggerTool.m_logger.info(qc.getQcName()+":"+questioncount);
                }//end if
                
                List<QuestionCategory> listqcs = null;
                String valuedb = hashCategory.get(line);
                LoggerTool.m_logger.info(valuedb);
                listqcs = qcd.find("from QuestionCategory where qcName='"
                        + valuedb + "'");
                if (listqcs.size() > 0)
                {
                    qc = listqcs.get(0);
                    questioncount=0;

                }// end if
                else
                {
                    QuestionCategory qcnew = new QuestionCategory();
                    qcnew.setQcName(valuedb);
                    qcnew.setQcRatio(0);
                    questionCategoryService.saveOne(qcnew);
                    qc=qcnew;

                }// end else
                continue;

            }// end if

            // 读取分类下的内容判断是否为题，如果是入库。
            if (null != qc)
            {
                
                // 判断是不是题目，如果是题目，保存上个题目的信息
                // 如果不是题目，判断是否已经有题目存在
                // 没有的话continue
                // 有题目的话判断是否是题目的选项
                // 是选项加入选项列表
                // 不是就comtinue

                boolean isques = isQuestion(line);
                if (isques)
                {
                    if (null != que)
                    {
                        que.setOptionses(setOptions);
                        que.setQuestionBase(qb);
                        que.setQuestionCategory(qc);
                        questionsService.saveQuestion(que);
                        optionsService.saveSet(setOptions);
                        setOptions.clear();
                        questioncount++;
                    }// end if
                    que = anaLineQuestion(line);

                }// end if
                else
                {
                    if (null != que)
                    {
                        boolean isopt = isOption(line);

                        if (isopt)
                        {
                            anaOptions(line, setOptions,que);
                        }// end if
                        else {
                            LoggerTool.m_logger.info(line);
                        }//end else

                    }// end if
                    else {
                        LoggerTool.m_logger.info(line);
                    }//end else

                }// end else

            }// end if

        }
        if (que!=null)
        {
        	que.setOptionses(setOptions);
            que.setQuestionBase(qb);
            que.setQuestionCategory(qc);
            questionsService.saveQuestion(que);
            if(setOptions!=null&&setOptions.size()!=0){
            	optionsService.saveSet(setOptions);
            }
            
            questioncount++;
            LoggerTool.m_logger.info(qc.getQcName()+":"+questioncount);
        }//end if
        
        
        
    }

    /**
      * 关于方法的描述：分析选项行并加入到set中
      * @param line
      * @param setOptions 
     * @param que 
      */
    private void anaOptions(String line, Set<Options> setOptions, Questions que)
    {
        Options opt=null;
        String regex = "[ABCDEFG]\\、";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(line);
        int or=-1;
        while (m.find())
        {
            if (or!=-1)
            {
                String strtmp=line.substring(or, m.start()); 
                opt=new Options();
                opt.setQuestions(que);
                opt.setOptionOrder(setOptions.size());
                opt.setOptionDes(strtmp);
                setOptions.add(opt);
                
            }//end if
                
            or=m.start();
        }// end while
        if (or!=-1)
        {
            String strtmp=line.substring(or);
            opt=new Options();
            opt.setQuestions(que);
            opt.setOptionOrder(setOptions.size());
            opt.setOptionDes(strtmp.replaceAll("\\s+", ""));
            setOptions.add(opt);
        }//end if
        else {
            System.out.println(line);
        }//end else
        
        
       

    }

    /**
      * 关于方法的描述：判断是否为选项行
      * @param line
      * @return 
      */
    private boolean isOption(String line)
    {
        boolean ret = false;
        String regex = "[ABCDEFGHIJKLMN]、.*";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(line);
        if (m.find())
        {
            ret = true;
        }// end if

        return ret;
    }

    /**
      * 关于方法的描述：分析题目行
      * @param line
      * @return 
      */
    private Questions anaLineQuestion(String line)
    {
        
        Questions que = new Questions();
        String regex1 = "[（\\(]\\s*([ABCDEFGHIJKLMN])\\s*[）\\)]";
        String regex2 = "[（\\(]\\s*([ABCDEFGHIJKLMN]{2,})\\s*[）\\)]";
        String regex3 = "[（\\(]\\s*([√×])\\s*[）\\)]";
        String regexny = "\\[[易中难]\\]";
        Pattern p1 = Pattern.compile(regex1);
        Matcher m1 = p1.matcher(line);
        Pattern p2 = Pattern.compile(regex2);
        Matcher m2 = p2.matcher(line);
        Pattern p3 = Pattern.compile(regex3);
        Matcher m3 = p3.matcher(line);
        Pattern p4 = Pattern.compile(regexny);
        Matcher m4 = p4.matcher(line);
        

        QuestionType qt=new QuestionType();
        if (m1.find())
        {
            qt.setQtId(1);
            que.setQuestionType(qt);
            que.setQuesAnswer(countAnswer(m1.group()));
            line=line.replace(m1.group(), "（     ） ");
        }// end if
        else if (m2.find())
        {
            qt.setQtId(2);
            que.setQuestionType(qt);
            que.setQuesAnswer(countAnswer(m2.group()));
            line=line.replace(m2.group(), "（     ） ");
        }// end if
        else if (m3.find())
        {
            qt.setQtId(3);
            que.setQuestionType(qt);
            que.setQuesAnswer(countAnswer(m3.group()));
            line=line.replace(m3.group(), "（     ） ");
            
        }// end if
        else {
            qt.setQtId(-1);
            que.setQuestionType(qt);
            que.setQuesAnswer(-1);
            
        }//end else
        
        try
        {
            if (m4.find())
            {
                String yiyi=m4.group();
                que.setQuesDifficulty(coDify(yiyi));
                line=line.replaceAll(yiyi, " ");
                line=line.replaceAll("\\[", " ");
                line=line.replaceAll("\\]", " ");
                int index=line.indexOf("、");
                line=line.substring(index+1);
            }//end if;
            else {
                que.setQuesDifficulty(-1);
            }//end else
        }//end try 
        catch (Exception e)
        {
            e.printStackTrace();
        }//end catch
        
        int index=line.indexOf("、");
        line=line.substring(index+1);
        que.setQuesDes(line);
        
        
        
        

        return que;
    }

    private Integer coDify(String group)
    {
        int ret=-1;
        if (group.indexOf("易")!=-1)
        {
            ret=1;
        }//end if
        else if (group.indexOf("中")!=-1) {
            ret=2;
        }//end if
        else if (group.indexOf("难")!=-1) {
            ret=3;
        }//end if
        return ret;
    }

    private Integer countAnswer(String group)
    {
        int ret=0;
        if (group.indexOf("A")!=-1||group.indexOf("×")!=-1)
        {
            ret=ret+1;
        }//end if
        if (group.indexOf("B")!=-1||group.indexOf("√")!=-1) {
            ret=ret+2;
        }//end if
        if (group.indexOf("C")!=-1) {
            ret=ret+4;
        }//end if
        if (group.indexOf("D")!=-1) {
            ret=ret+8;
        }//end if
        if (group.indexOf("E")!=-1) {
            ret=ret+16;
        }//end if
        if (group.indexOf("F")!=-1) {
            ret=ret+32;
        }//end if
        if (group.indexOf("G")!=-1) {
            ret=ret+64;
        }//end if
        if (group.indexOf("H")!=-1) {
            ret=ret+128;
        }//end if
        if (group.indexOf("I")!=-1) {
            ret=ret+256;
        }//end if
        if (group.indexOf("J")!=-1) {
            ret=ret+512;
        }//end if
        if (group.indexOf("K")!=-1) {
            ret=ret+1024;
        }//end if
        if (group.indexOf("L")!=-1) {
            ret=ret+2048;
        }//end if
        if (group.indexOf("J")!=-1) {
            ret=ret+4096;
        }//end if
        if (group.indexOf("M")!=-1) {
            ret=ret+8192;
        }//end if
        if (group.indexOf("N")!=-1) {
            ret=ret+16384;
        }//end if
        return ret;
    }

    /**
      * 关于方法的描述：判断是否为题目
      * @param line
      * @return 
      */
    private boolean isQuestion(String line)
    {
        boolean ret = false;
        String regex = "\\d+、.*[（\\(]\\s*([ABCDEFGHIJKLMN√×]*).*";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(line);
        if (m.find())
        {
            ret = true;
        }// end if

        return ret;
    }

    public static void main(String[] args) throws Exception
    {
         DocTool td = new DocTool(1L,"dd");
         td.analyseQuestionbase("zsjs.doc");
        // String regex="\\d+\\..*[（\\(][ABCD√×][）,\\)].*\\[[易中难]\\]";
//        String line="A.2DD         B. 5AA          C.4         D. 3";
//        String regex = "[ABCDEF]\\.";
//        Pattern p = Pattern.compile(regex);
//        Matcher m = p.matcher(line);
//        int or=-1;
//        while (m.find())
//        {
//            System.out.println(m.group());
//            if (or!=-1)
//            {
//                System.out.println(line.substring(or, m.start())); 
//            }//end if
//                
//            or=m.start();
//        }// end while
//        System.out.println(line.substring(or)); 

    }
}
