package leetcode.dp;

/*
https://blog.csdn.net/ZWB626/article/details/84938171
 */

public class UniquePath {

    public int solution(int[][] obstacleGrid) {
        int row = obstacleGrid.length; //取得行数
        if (row == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int col = obstacleGrid[0].length;
        int[][] steps = new int[row][col];

        steps[0][0] = 1;

        for (int i = 1; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                steps[i][0] = 0;
            } else {
                steps[i][0] = steps[i - 1][0];
            }
        }

        for (int i = 1; i < col; i++) {
            if (obstacleGrid[0][i] == 1) {
                steps[0][i] = 0;

            } else {
                steps[0][i] = steps[0][i - 1];

            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(obstacleGrid[i][j] == 1){
                    steps[i][j] = 0;
                }else {
                    steps[i][j] = steps[i-1][j] + steps[i][j-1];
                }

            }

        }
        return steps[row-1][col-1];

    }


}
