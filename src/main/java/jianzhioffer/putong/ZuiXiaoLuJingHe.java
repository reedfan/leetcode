package jianzhioffer.putong;

public class ZuiXiaoLuJingHe {

    public static void main(String[] args) {

        int[][] matrix = {
                {1,3,5,9},
                {8,1,3,4},
                {5,0,6,1},
                {8,8,4,0},
        };
       // System.out.println(zuiChangLuJingHe(matrix));
        System.out.println(minPathSum2(matrix));

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

    /**
     * 空间压缩方法
     */

    private static int minPathSum2(int[][] m){
        if(m == null||m.length==0||m[0]==null||m[0].length==0){
            return 0;
        }
        int more = Math.max(m.length,m[0].length);
        int less = Math.min(m.length,m[0].length);
        boolean rowmore = more == m.length;  //行数是否大于列数
        int[] arr = new int[less];
        arr[0] = m[0][0];
        for (int i = 1; i < less; i++) {
            arr[i] = arr[i-1]+(rowmore?m[0][i]:m[i][0]);

        }
        for (int i = 1; i < more; i++) {
            arr[0]+=(rowmore?m[i][0]:m[0][i]);
            for (int j = 1; j < less; j++) {
                arr[j] = Math.min(arr[j-1],arr[j])+(rowmore?m[i][j]:m[j][i]);

            }

        }

        return arr[less-1];

    }
}
