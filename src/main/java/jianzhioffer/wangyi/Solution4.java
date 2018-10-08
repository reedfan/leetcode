package jianzhioffer.wangyi;

import java.util.Scanner;

/**
 * Author 范群松.
 * Date：2018/9/8
 * Time: 16:40
 */

public class Solution4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] input = new int[n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <2 ; j++) {
                    input[i][j] = in.nextInt();

                }
            }
        }
    }





}
