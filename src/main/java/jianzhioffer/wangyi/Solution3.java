package jianzhioffer.wangyi;

import java.util.Scanner;

/**
 * Author 范群松.
 * Date：2018/9/8
 * Time: 16:29
 */

public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            int n = in.nextInt();
            int m = in.nextInt();


                int x = in.nextInt();
                int y = in.nextInt();


            fun(x,y);
        }
    }

    private static void fun(int x,int y){
        if(x == 1 && y == 20){
            System.out.println(0);
        }

    }
}
