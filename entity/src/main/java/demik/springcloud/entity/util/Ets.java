//package demik.springcloud.entity.util;
//
//import com.google.common.collect.Lists;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * Function:
// *
// * @author liubing
// * Date: 2019/3/16 10:17 AM
// * @since JDK 1.8
// */
//public class Ets {
//    public static void main(String []args){
//        new Ets().ans();
//    }
//    //todo a..BBB..c 去掉一个B
//    //todo AABB 去掉一个B
//    //todo AABBCC 去掉一个B
//    public static void updateString(){
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        String s = "";
//        String str = "";
//        char[] chars = null;
//        boolean flag = true;
//        ArrayList<String> list = new ArrayList<String>();
//
//        for(int i = 0;i < n ;i++){
//            str = in.next();
//            chars = str.toCharArray();
//            while(flag) {
//                if(s.length()!=0){
//                    str = s;
//                    chars = str.toCharArray();
//                }
//                for (int j = 0; j < str.length(); j++) {
//                    if (j + 1 < str.length() && chars[j] == chars[j + 1]) {
//                        //三个一样的字符
//                        if (j + 2 < str.length() && chars[j] == chars[j + 2]) {
//                            s = str.substring(0, j) + str.substring(j + 1, str.length());
//                            break;
//                        }
//                        //后边又是两个一样的字符AABB
//                        else if (j + 3 < str.length() && chars[j + 2] == chars[j + 3]) {
//                            //                        //AABBCC
//                            //                        if(j+5<str.length()&&chars[j+4]==chars[j+5]){
//                            //                            str = str.substring(0,j+3) + str.substring(j+4,str.length());
//                            //                        }else str = str.substring(0,j+3) + str.substring(j+4,str.length());
//                            s = str.substring(0, j + 3) + str.substring(j + 4, str.length());
//                            break;
//                        }
//                    }
//                }
//                if (str.length() == s.length()) {
//                    flag = false;
//                }
//            }
//            list.add(s);
//        }
//        list.forEach(x->{
//            System.out.println(x);
//        });
//    }
//    //整数背包
//    public static void bag(){
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int balance = 1024-n;
//        int sum = 0;
//        for(;;){
//            if(balance>=64){
//                balance = balance-64;
//                sum = sum+1;
//                continue;
//            }else if(balance>=16){
//                balance = balance-16;
//                sum = sum+1;
//                continue;
//            }else if(balance >= 4){
//                balance = balance - 4;
//                sum = sum+1;
//                continue;
//            }else if(balance >= 1){
//                balance = balance - 1;
//                sum = sum+1;
//                continue;
//            }else if(balance == 0){
//                break;
//            }
//        }
//        System.out.println(sum);
//    }
//    public static void line(){
//
//    }
//    int maxn = 10005;
//    int[] a = new int[maxn];
//    int n,k;
//    public boolean ok(double mid){
//        int num = 0;
//        for(int i = 0;i < n;i++){
//            num+=a[i]/mid;
//        }
//        if(num>=k){
//            return true;
//        }
//        else return false;
//    }
//    public void ans(){
//        Scanner in = new Scanner(System.in);
//        n = in.nextInt();
//        k = in.nextInt();
//        int maxx = 0;
//        for(int i = 0 ; i < n; i++){
//            double v;
//            v = in.nextDouble();
//            a[i] = (int)(v*100);
//            if(a[i]>maxx){
//                maxx = a[i];
//            }
//        }
//        int l = 1;
//        int r = maxx;
//        int res = 0;
//        while(r>=1) {
//            int mid = l + (r - 1) / 2;
//            if (ok(mid)) {
//                res = mid;
//                l = mid + 1;
//            } else {
//                r = mid - 1;
//            }
//        }
//
//        System.out.println(String.format("%.2f",ans));
//    }
//}