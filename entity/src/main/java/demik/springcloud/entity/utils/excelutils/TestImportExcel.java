package demik.springcloud.entity.utils.excelutils;


import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class TestImportExcel {
    public static void main(String[] args) throws IOException, Exception {
    // /Users/liubing/IdeaProjects/utils/src/main/java/demik/commonbox/excelutils/大学生信息导入模版.xlsx
        String fileName="大学生信息导入模版.xlsx";
        InputStream in = new FileInputStream(new File("/Users/liubing/IdeaProjects/utils/src/main/java/demik/commonbox/excelutils/"+fileName));
        Workbook wb = ExcelUtils.chooseWorkbook(fileName, in);

//        StudentStatistics studentStatistics = new StudentStatistics();
//        //读取一个对象的信息
//        StudentStatistics readDateT = ExcelUtils.readDateT(wb, studentStatistics, in, new Integer[] {12, 5}, new Integer[] {13, 5});
//        System.out.println(readDateT);
//        //读取对象列表的信息
//        StudentBaseInfo studentBaseInfo = new StudentBaseInfo();
//        //第二行开始，到倒数第三行结束（总数减去两行）
//        List<StudentBaseInfo> readDateListT = ExcelUtils.readDateListT(wb, studentBaseInfo, 2, 2);
//        System.out.println(readDateListT);
        StudentInfo studentInfo = new StudentInfo();
        List<StudentInfo> studentInfos = ExcelUtils.readDateListT(wb,studentInfo,11,0);
        System.out.println(studentInfos);
    }
}
