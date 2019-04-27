package jianzhioffer.putong;

public class ZuiXiaoLuJingHe {

    public static void main(String[] args) {

        int[][] matrix = {
                {1,3,5,9},
                {8,1,3,4},
                {5,0,6,1},
                {8,8,4,0},
        };
        System.out.println(zuiChangLuJingHe(matrix));

    }

    private static int zuiChangLuJingHe(int[][]martix){
        int[][] dp = new int[martix.length][martix[0].length];
        int sum = 0;
        for (int i = 0; i < martix.length ; i++) {
            sum += martix[i][0];
            dp[i][0] = sum;

        }
        sum = martix[0][0];
        for (int i = 1; i < martix[0].length; i++) {
            sum+= martix[0][i];
            dp[0][i] = sum;

        }
        for (int i = 1; i < martix.length ; i++) {
            for (int j = 1; j < martix[0].length ; j++) {
                dp[i][j] =  Math.min(dp[i-1][j],dp[i][j-1])+martix[i][j];
            }

        }
        return dp[martix.length-1][martix[0].length-1];

    }
}
