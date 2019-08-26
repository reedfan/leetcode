package jianzhioffer.dp.knapsack;

public class KnapsackErweidpYasuo {
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
        //dp表示i个物品放进容量为capacity的背包的效益
        int[] dp = new int[capacity+1];

        for (int i = 0; i < len ; i++) {
            //注意一定为倒序，j < weights[i]的话，表示放不下了。那么可以终止循环。这是动态规划中
            //一个常用的做法。减枝
            for (int j = capacity; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j],values[i]+dp[j-weights[i]]);

            }
        }
        return dp[capacity];

    }


}
