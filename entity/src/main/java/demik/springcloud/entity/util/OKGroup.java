package demik.springcloud.entity.util;

import java.util.Scanner;
/**
 *       时间限制：C/C++语言 1000MS；其他语言 3000MS
 内存限制：C/C++语言 65536KB；其他语言 589824KB
 题目描述：
 编写一个函数实现字符串的压缩：连续相同的字符用字符和出现次数（次数大于1）表示。

 例如：

 原文：a   编码后：a

 原文：aaaabc   编码后：a4bc

 原文：aaaabcccde   编码后：a4bc3de
 */

/**
 * Function:
 *
 *
 * @author liubing
 * Date: 2019/3/19 7:19 PM
 * @since JDK 1.8
 */
public class OKGroup {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        String resultString = chars[0]+"";
        int lastNum = 1;
        for(int i = 1; i< chars.length;i++){
            if(chars[i]==chars[i-1]){
                lastNum = lastNum+1;
            }else{
                if(lastNum!=1){
                    resultString = resultString+lastNum+chars[i];
                }else{
                    resultString = resultString+chars[i];
                }
                lastNum = 1;
            }
        }
        if(lastNum!=1){
            resultString = resultString+lastNum;
        }
        System.out.println(resultString);
    }
}
