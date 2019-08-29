package leetcode.tree;

public class TianJiaZuiShaoZiFuChuan {
    public static void main(String[] args) {

        String str  ="";
        char[] chars = str.toCharArray();
        int[][] dp = getDp(chars);





    }





    public static int[][] getDp(char[] str){
        /**
         * dp[i][j]值代表子串str[i...j]最少添加几个字符使
         * str[i...j]整体都是回文
         */
        int[][] dp = new int[str.length][str.length];
        for(int j = 1;j<str.length;j++){
            dp[j-1][j] = str[j-1]==str[j]?0:1;
            for (int i = j-2; i >-1 ; i--) {
                if(str[i] == str[j]){
                    dp[i][j] = dp[i+1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1])+1;
                }

            }

        }
        return dp;


    }
}
