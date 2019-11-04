package leetcode.dp;

import org.junit.Test;

/**
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * <p>
 * 示例 2:
 * <p>
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * <p>
 * 示例 3:
 * <p>
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 * <p>
 * <p>
 * <p>
 * 注意:
 * <p>
 * 你可以假设：
 * <p>
 * 0 <= amount (总金额) <= 5000
 * 1 <= coin (硬币面额) <= 5000
 * 硬币种类不超过 500 种
 * 结果符合 32 位符号整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N518Change {

    @Test
    public void test() {
        int[] coins = {1, 2, 5};
        System.out.println(change1(5, coins));
    }

    public int change1(int amount, int[] coins) {
        if (coins == null) {
            return 0;
        }
        int[][] dp = new int[coins.length][amount + 1];

        for (int i = 0; i < coins.length; i++) {
            //都不拿就拼成0
            dp[i][0] = 1;
        }

        for (int i = 1; i * coins[0] <= amount; i++) {
            //用第0个拼成i
            dp[0][i] = 1;
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int sum = 0;
                for (int k = 0; k * coins[i] <= j; k++) {
                    sum += dp[i-1][j-k*coins[i]];

                }
                dp[i][j] = sum;
            }


        }
        return dp[coins.length - 1][amount];


    }


    public int change(int amount, int[] coins) {
        if (coins == null) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];

    }
}
