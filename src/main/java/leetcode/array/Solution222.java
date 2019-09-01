package leetcode.array;

import java.util.Scanner;

/**
 * Author 范群松.
 * Date：2018/8/20
 * Time: 21:05
 * 给定两个字符串A和B，同时给定两串的长度n和m。
   测试样例："1AB2345CD",9,"12345EF",7      返回：4
 */

public class Solution222 {

    private static int longest(String A, int n, String B, int m) {
        int[][]	dp=new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[n][m] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(A.charAt(i) == B.charAt(j)){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                    max = dp[i][j]>max?dp[i][j]:max;
                }

            }

        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < N; i++) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            int str1len = str1.length();
            int str2len = str2.length();
            System.out.println(longest(str1, str1len, str2,str2len));
        }
    }
}
