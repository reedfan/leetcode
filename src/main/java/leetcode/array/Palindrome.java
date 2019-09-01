package leetcode.array;

/**
 * Author 范群松.
 * Date：2018/8/24
 * Time: 10:27
 * 最长回文串
 */

public class Palindrome {

    public static void main(String[] args) {
        String str = "abc1234321ab";
        System.out.println(getLongestPalindrome(str,str.length()));
    }


    public static int getLongestPalindrome(String A,int n){
        int[][] dp = new int[n][n];
        int max = 1;
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        char[] a = A.toCharArray();
        for (int len = 2;len <= n;len++){   //枚举子串长度
            for (int i = 0; i < n-len ; i++) {      //枚举子串的起始节点
                int j = i + len -1;   //枚举子串的终止
                if(len == 2 && a[i] == a[j]){
                    dp[i][j] = len;
                    max = 2;
                    continue;
                }
                if(a[i] == a[j] && dp[i+1][j-1] != 0){
                    dp[i][j] = len;
                    max = len;
                }
            }
        }
        return max;
    }

}
