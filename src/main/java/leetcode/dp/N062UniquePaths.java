package leetcode.dp;

/**
 *
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 *
 * 示例 2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class N062UniquePaths {

    public static void main(String[] args) {
        System.out.println(new N062UniquePaths().uniquePaths1(7,3));
    }

    /*
    解析：本题为动态规划的基础题。何为动态规划？动态规划讲起来很高大上。说白了就是以空间换时间。类似于缓存。其实就是一个如何去填充缓存数据的问题。
    首先。定义一个和原数组一样大的数组dp。dp[m][n]表示（0，0）-->(m,n)的路径的条数。
    然后。确定初始值。二维数组一般需要第一行和第一列的值。因为只能向右或者向下。所以从开始到第一行或者第一列都只有一条路径。
    所以dp[i][0] = 1;dp[0][i] = 1;
    然后。因为只能向右或者向下。所以dp[i][j]为从dp[i - 1][j]向右走和从dp[i][j - 1]向下走。即dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
     */


    public int uniquePaths1(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
//        if (m == 1 || n == 1) {
//            return 1;
//        }
        int[][] dp = new int[m][n];

        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

            }
        }
        return dp[m - 1][n - 1];

    }

    //空间压缩
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];

            }
        }
        return dp[n - 1];
    }
}
