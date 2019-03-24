package demik.springcloud.entity.util;

import java.math.BigInteger;
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
}
