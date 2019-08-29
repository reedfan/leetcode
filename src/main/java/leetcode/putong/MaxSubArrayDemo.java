package leetcode.putong;

/**
 * 数组预处理
 */
public class MaxSubArrayDemo {

    public static void main(String[] args) {
        int[][] array = {
                {0 ,-2 ,-7, 0},
                {9 ,2 ,-6 ,2},
                {-4 ,1 ,-4 ,1},
                {-1, 8 ,0 ,-2}
        };
        int row = array.length;
        int col = array[0].length;
        /*
        从00开始
         */
        int[][] sum = new int[row][col];
        sum[0][0] = array[0][0];
        for (int i = 1; i < col; i++) {
            sum[i][0]=sum[i-1][0]+array[i][0];
        }
        for (int i = 1; i < row; i++) {
            sum[0][i] = sum[0][i-1]+array[0][i];
        }
        for (int i = 1; i < col ; i++) {
            for (int j = 1; j <row ; j++) {
                sum[i][j] = sum[i-1][j]+sum[i][j-1]+array[i][j]-sum[i-1][j-1];
            }

        }
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(sum[i][j]+" ");

            }
            System.out.println();

        }

        int[][] res = new int[row][col];

    }
}
