package jianzhioffer;

/**
 * created by reedfan on 2019/7/8 0008
 */



public class zeroonebag {

    public static void main(String[] args) {
        int c=5;
        int v[]={6,10,12},w[]={1,2,3};
        int res= knapsack(c,w,v);
        System.out.println(res);
    }

    public static int knapsackDp(int capacity, int[] weights, int[] values) {
        assert (weights.length == weights.length);
        int len = weights.length;
        if(len == 0){
            return 0;
        }
        //dp表示i个物品放进容量为c的背包的效益
        int[] dp = new int[capacity+1];
        for (int i = 0; i <= capacity ; i++) {
            dp[i] = i >= weights[0]?weights[0]:0;
        }
        for (int i = 1; i < len ; i++) {
            for (int j = capacity; j >= weights[i]; j--) {

                dp[j] = Math.max(dp[j],values[i]+dp[j-weights[i]]);


            }
        }
        return dp[capacity];
    }





    static int[][] memo;

    /**
     *  记忆搜索解法
     */
    public static int knapsack(int capacity, int[] weights, int[] values) {
        int n = weights.length;
        //因为有两个参数
        memo = new int[n][capacity+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= capacity ; j++) {
                memo[i][j] = -1;

            }
        }
        return bestValue(capacity,n-1,weights,values);
    }

    private static int bestValue(int capacity, int index, int[] weights, int[] values){
        if(index <= 0 || capacity<= 0){
            return 0;
        }
        if (memo[index][capacity] != -1){
            return memo[index][capacity];
        }
        int res = bestValue(capacity,index-1,weights,values);
        if(capacity >= weights[index]){
            res = Math.max(res,values[index]+bestValue(capacity - weights[index],index-1,weights,values));
        }
        memo[index][capacity] = res;
        return res;
    }
}
