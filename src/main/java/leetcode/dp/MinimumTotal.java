package leetcode.dp;

import org.junit.Test;

public class MinimumTotal {

    @Test
    public void test(){
        int[][] triangle = {
                {2},
                {3,4},
                {6,5,7},
                {4,1,8,3}};

        System.out.println(minimumTotal(triangle));
    }

    /**
     * 分析：考虑自底向上的解法简单点，
     * 动态转移方程为：
     * dp[m][n] = min(dp[m + 1][n], dp[m + 1][n + 1]) + triangle[m][n].
     */
    public int minimumTotal(int[][] triangle){
        if(triangle == null || triangle.length == 0){
            return 0;
        }
        int row = triangle.length;
        int[] dp = new int[row];
        for (int i = 0; i < row ; i++) {
            dp[i] = triangle[row-1][i];
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j <= i ; j++) {
                dp[j] = triangle[i][j]+Math.min(dp[j], dp[j+1]);
            }

        }
        return dp[0];
    }

}
