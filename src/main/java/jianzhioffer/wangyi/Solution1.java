package jianzhioffer.wangyi;

import java.util.Scanner;

/**
 * Author 范群松.
 * Date：2018/9/8
 * Time: 15:57
 */

public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int num = in.nextInt();
            for (int i = 0; i < num; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                maxAndmin(a,b);
            }
        }
    }

    private static void maxAndmin(int n,int k){
        if(n - k <=1 || n==0 || k==0){
            System.out.println(0+" "+0);
        }else {
            if(k > n-k) {
                System.out.println(0 + " " + (n - k));
            }else {
                System.out.println(0 + " " + (k-1));
            }
        }

    }
}
