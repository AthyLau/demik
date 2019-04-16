package demik.springcloud.entity.util;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/19 7:59 PM
 * @since JDK 1.8
 */

/**
 * 6    111111 222222
 * 4    1111  211 22 121
 *
 *  3  111
 *  3-1
 */

public class UPTop {
    static BigInteger a[] = new BigInteger[1000000];
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
//        System.out.println(getNumber(n));
        a[1] = new BigInteger("1");
        a[2] = new BigInteger("2");
        for(int i = 3; i<=n;i++){
            a[i] = a[i-1].add(a[i-2]);
            if(i==n){
                break;
            }
        }
//        System.out.println(a[n]);
    }
//    public static int getNumber(Integer n){
//        if(n==1) {
//            return 1;
//        }if(n==2){
//            return 2;
//        }else{
//            return getNumber(n-1)+getNumber(n-2);
//        }
//    }

    public static void kuaipai() {
        int[] a = {1, 2, 4, 5, 7, 4, 5 ,3 ,9 ,0};
        System.out.println(Arrays.toString(a));
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] a) {
        if(a.length>0) {
            quickSort(a, 0 , a.length-1);
        }
    }

    private static void quickSort(int[] a, int low, int high) {
        //1,找到递归算法的出口
        if( low > high) {
            return;
        }
        //2, 存
        int i = low;
        int j = high;
        //3,key
        int key = a[ low ];
        //4，完成一趟排序
        while( i< j) {
            //4.1 ，从右往左找到第一个小于key的数
            while(i<j && a[j] > key){
                j--;
            }
            // 4.2 从左往右找到第一个大于key的数
            while( i<j && a[i] <= key) {
                i++;
            }
            //4.3 交换
            if(i<j) {
                int p = a[i];
                a[i] = a[j];
                a[j] = p;
            }
        }
        // 4.4，调整key的位置
        int p = a[i];
        a[i] = a[low];
        a[low] = p;
        //5, 对key左边的数快排
        quickSort(a, low, i-1 );
        //6, 对key右边的数快排
        quickSort(a, i+1, high);
    }

}
