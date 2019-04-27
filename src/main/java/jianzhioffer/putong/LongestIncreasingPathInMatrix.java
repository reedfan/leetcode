package jianzhioffer.putong;

public class LongestIncreasingPathInMatrix {

    /**
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
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };
        int max = longestDp(matrix);
        System.out.println(max);
    }

    private static int longest(int[][] matrix){

        int max = Integer.MIN_VALUE;

        int hang = matrix.length;
        int lie = matrix[0].length;
        int path = 0;
        for (int i = 0; i < hang ; i++) {
            for (int j = 0; j < lie; j++) {
                path = path(matrix,i,j);
                max=max>path?max:path;

            }

        }
        return max;

    }

    private static int path(int[][] matrix,int hang,int lie){

        int num = 1;

        //zuo
        if(hang>0&&matrix[hang][lie]>matrix[hang-1][lie]){
            num = path(matrix,hang-1,lie)+1;
        }

        //you
        if((hang<matrix.length-1)&&matrix[hang][lie]>matrix[hang+1][lie]){
            num = num>(path(matrix,hang+1,lie)+1)?num:(path(matrix,hang+1,lie)+1);

        }
        //shang
        if(lie>0&&matrix[hang][lie]>matrix[hang][lie-1]){
            num = num>(path(matrix,hang,lie-1)+1)?num:(path(matrix,hang,lie-1)+1);
        }

        //xia
        if((lie<matrix[0].length-1)&&matrix[hang][lie]>matrix[hang][lie+1]){
            num = num>(path(matrix,hang,lie+1)+1)?num:(path(matrix,hang,lie+1)+1);
        }
        return num;
    }


    private static int longestDp(int[][] matrix){
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];

        int hang = matrix.length;
        int lie = matrix[0].length;
        int path = 0;
        for (int i = 0; i < hang ; i++) {
            for (int j = 0; j < lie; j++) {
                path = pathDp(matrix,dp,i,j);
                max=max>path?max:path;

            }

        }
        return max;

    }

    private static int pathDp(int[][]matrix,int[][]dp,int hang,int lie){

        if(dp[hang][lie] == 0){
            dp[hang][lie] = 1;

            //zuo
            if(hang>0&&matrix[hang][lie]>matrix[hang-1][lie]){
                dp[hang][lie] = (pathDp(matrix,dp,hang-1,lie));
            }

            //you
            if((hang<matrix.length-1)&&matrix[hang][lie]>matrix[hang+1][lie]){
                dp[hang][lie] = dp[hang][lie]>(pathDp(matrix,dp,hang+1,lie)+1)?dp[hang][lie]:(pathDp(matrix,dp,hang+1,lie)+1);

            }
            //shang
            if(lie>0&&matrix[hang][lie]>matrix[hang][lie-1]){
                dp[hang][lie] = dp[hang][lie]>(pathDp(matrix,dp,hang,lie-1)+1)?dp[hang][lie]:(pathDp(matrix,dp,hang,lie-1)+1);
            }

            //xia
            if((lie<matrix[0].length-1)&&matrix[hang][lie]>matrix[hang][lie+1]){
                dp[hang][lie] = dp[hang][lie]>(pathDp(matrix,dp,hang,lie+1)+1)?dp[hang][lie]:(pathDp(matrix,dp,hang,lie+1)+1);
            }


        }
        return dp[hang][lie];




    }

}
