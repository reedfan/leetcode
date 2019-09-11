package leetcode.dp;


public class N329LongestIncreasingPath {
 
    /*
    给定一个整数矩阵matrix，每个位置你可以向左、右、下、上移动，找到其中最长的递增路径 例如:
matrix = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
返回4
最长路径是[1, 2, 6, 9].
     */

    public static void main(String[] args) {
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        int max = new N329LongestIncreasingPath().longestIncreasingPath(matrix);
        System.out.println(max);
    }
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    //先来看看暴力解法
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int row = matrix.length;
        int col = matrix[0].length;
        int path = 0;
        //从每个位置出发都尝试一遍
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                path = path(matrix, i, j);
                max = max > path ? max : path;

            }

        }
        return max;
    }

    private int path(int[][] matrix, int row, int col) {
        int num = 0;
        for (int i = 0; i < 4; i++) {
            int newRow = row + d[i][0];
            int newCol = col + d[i][1];
            if (newRow >= 0 && newCol >= 0 && newRow < matrix.length && newCol < matrix[0].length && matrix[row][col] > matrix[newRow][newCol]) {
                num = num > (path(matrix, newRow, newCol)) ? num : (path(matrix, newRow, newCol));
            }
        }

        return ++num;
    }

    //从中可以看出，在计算中进行了大量的重复计算，因此。可以想办法将重叠子问题记录下来，避免重复计算。
    //引入一个二元数组dp[][]，用来记录从某个点出发的最长路径，也就是动态规划解法。



    public int longestIncreasingPathdp(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }

        int max = -1;
        int row = matrix.length;
        int col = matrix[0].length;
        int path = 0;
        int[][] dp = new int[row][col];
        //从每个位置出发都尝试一遍
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                path = path(matrix, i, j,dp);
                max = max > path ? max : path;

            }

        }
        return max;
    }

    private int path(int[][] matrix, int row, int col,int[][] dp) {
        if(dp[row][col]!=0){
            return dp[row][col];
        }
        for (int i = 0; i < 4; i++) {
            int newRow = row + d[i][0];
            int newCol = col + d[i][1];
            if (newRow >= 0 && newCol >= 0 && newRow < matrix.length && newCol < matrix[0].length && matrix[row][col] > matrix[newRow][newCol]) {
                dp[row][col] = dp[row][col] > (path(matrix, newRow, newCol,dp)) ? dp[row][col] : (path(matrix, newRow, newCol,dp));
            }
        }
        return ++dp[row][col];
    }




}
