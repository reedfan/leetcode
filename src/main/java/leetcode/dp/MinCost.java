package leetcode.dp;

public class MinCost {

    public int minCost1(String str1,String str2,int ic,int dc,int rc){
        if(str1 == null||str2 == null){
            return 0;
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int row = chs1.length+1;
        int col = chs2.length+1;
        //dp[i][j]表示str1[0...i]编辑成str2[0...j-1]的最小代价
        int[][] dp = new int[row][col];
        //变成空串当然是删除所有字符
        for (int i = 0; i < row; i++) {
            dp[i][0] = dc*i;
        }
        //由空串变成现在的字符串当然是一直加字符
        for (int i = 0; i < col; i++) {
            dp[0][i] = ic*i;
        }
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col; j++) {
                if(chs1[i-1] == chs2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = dp[i-1][j-1]+rc;
                }
                dp[i][j] = Math.min(dp[i][j],dp[i][j-1]+ic);
                dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+dc);

            }

        }
        return dp[row-1][col-1];
    }

}
