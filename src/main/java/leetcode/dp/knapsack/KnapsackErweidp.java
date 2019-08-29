package leetcode.dp.knapsack;

public class KnapsackErweidp {
    public static void main(String[] args) {
        int c=5;
        int v[]={6,10,12},w[]={1,2,3};
        int res= knapsack(c,w,v);
        System.out.println(res);
    }
    public static int knapsack(int capacity, int[] weights, int[] values) {
        assert (weights.length == weights.length);
        int len = weights.length;
        if(len == 0){
            return 0;
        }
        //dp表示i个物品放进容量为c的背包的效益
        int[][] dp = new int[len][capacity+1];
        //初始化第一列，第一列表示背包容量为0的时候，所以第一列的值都为0
        for (int i = 0; i < len ; i++) {
            dp[i][0] = 0;
        }
        //初始化第一行。第一行表示只有一个物品。所以只要capacity >= weights[0]，就初始化为values[0]
        for (int i = 1; i <= capacity ; i++) {
            dp[0][i] = capacity >= weights[0]?values[0]:0;
        }
        for (int i = 1; i < len ; i++) {
            for (int j = 1; j <= capacity ; j++) {
                //第i个物品放不时的结果，和只有i-1个物品的结果一样
                dp[i][j] = dp[i-1][j];
                //第i个物品能放下
                if(j >= weights[i]){
                    //比较放和不放哪种能产生更高的价值
                    dp[i][j] = Math.max(dp[i][j],values[i]+dp[i-1][j-weights[i]]);
                }
            }
        }
        return dp[len-1][capacity];

    }


}
