package jianzhioffer.dp;

public class LeastCoinChange {

    public static void main(String[] args) {
        int[] coins = {1,6,7};
        System.out.println(coinChange(coins,30));
    }


    public static int coinChange(int[] coins, int amount) {

        int max = amount + 1;
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length ; i++) {
            dp[i] = max;

        }
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    //其实和跳台阶思路差不多，可以跳上给定的任一级
                    //因此这里就是选这次到期用哪种钱可以使得当前值最小
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }

            }

        }
        return dp[amount] > amount ? -1 : dp[amount];

    }

}
