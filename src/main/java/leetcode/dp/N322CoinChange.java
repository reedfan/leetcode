package leetcode.dp;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * <p>
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * <p>
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N322CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                //如果需要组成的金额正好和某个硬币的面额相等
                if (coin == i) {
                    dp[i] = 1;
                } else {
                    //只有能凑成dp[i - coin]才能凑成dp[i]
                    if (dp[i - coin] != 0) {
                        if (dp[i] == 0) {
                            //暂时能凑成dp[i-coin]，但是凑不成dp[i]，那么直接将dp[i-coin]+1
                            dp[i] = dp[i - coin] + 1;
                        } else {
                            //既能凑成dp[i-coin]，又能凑不成dp[i]，那么取dp[i-coin]+1和dp[i]的较小值
                            dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                        }

                    }

                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];

    }

}
