package com.sys.exam.util;



import java.io.FileInputStream;
import java.util.HashSet;

import org.apache.poi.hwpf.extractor.WordExtractor;

public class DocTool
{
    private HashSet<String> hashCategory = new HashSet<String>();

    public DocTool()
    {
        hashCategory.add("1.马克思列宁主义（250题）");
        hashCategory.add("2.毛泽东思想（100题）");
        hashCategory.add("3.中国特色社会主义理论体系、党的路线方针政策（350题）");
        hashCategory.add("4.时事政治（50题）");
        hashCategory.add("1.公安工作（25题）");
        hashCategory.add("2.部队军事工作（115题）");
        hashCategory.add("4.后勤管理工作（240题）");
        hashCategory.add("5.廉政建设（380题）");
        hashCategory.add("（三）法律法规（1065题）");
        hashCategory.add("（四）领导科学（135题）");
        hashCategory.add("（五）信息化应用（250题）");
    }

    public void analyseQuestionbase(String filePath) throws Exception
    {
        FileInputStream in = new FileInputStream(filePath);
        WordExtractor extractor = new WordExtractor(in);

        String[] strArray = extractor.getParagraphText();
        String str = extractor.getText();
        for (int i = 0; i < strArray.length; ++i)
        {
            String line = strArray[i];

            // 判断当前行是否是分类行
            if (hashCategory.contains(line.trim()))
            {
                System.out.println(line);
            }// end if
        }
    }

    public static void main(String[] args) throws Exception
    {

        DocTool td = new DocTool();
        td.analyseQuestionbase("base.doc");

    }
}
