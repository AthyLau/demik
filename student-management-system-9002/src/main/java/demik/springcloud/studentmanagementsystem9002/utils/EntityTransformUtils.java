package demik.springcloud.studentmanagementsystem9002.utils;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/14 3:54 PM
 * @since JDK 1.8
 */
public class EntityTransformUtils {

    public static Object getDTOfromVO(Object o){
        String className = o.getClass().toString();
        int lastIndexOf = className.lastIndexOf(".");
        String myStr = className.substring(lastIndexOf+1,className.length());
        System.out.println(className);
        System.out.println(myStr);
        return new Object();
    }

    public static void main(String[] args){
//        String str = new String();
////        String className = str.getClass().toString();
////        int lastIndexOf = className.lastIndexOf(".");
////        String myStr = className.substring(lastIndexOf+1,className.length());
////        System.out.println(className);
////        System.out.println(myStr);
////        getDTOfromVO(str);
        String str = new String();
        Class T = str.getClass();
    }
}
