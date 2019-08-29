package leetcode.dp.knapsack;

public class WanQuanBeiBao {
    public static void main(String[] args) {
        int c = 4;
        int v[] = {1, 1, 1}, w[] = {1, 2, 3};
        int res = knapsack(c, w, v);
        System.out.println(res);
    }

    public static int knapsack(int capacity, int[] weights, int[] values) {
        assert (weights.length == weights.length);
        int len = weights.length;
        if (len == 0) {
            return 0;
        }
        //dp表示i个物品放进容量为capacity的背包的效益
        int[] dp = new int[capacity + 1];
        for (int i = 0; i < len; i++) {
            //必须满足容量>=weights[i]才能放入
            for (int j = weights[i]; j <= capacity; j++) {
                dp[j] = Math.max(dp[j], values[i] + dp[j - weights[i]]);
            }
        }
        return dp[capacity];

    }


}
