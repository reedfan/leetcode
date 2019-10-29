package leetcode.dp;

import org.junit.Test;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。

 示例:

 输入: [1,2,3,0,2]
 输出: 3
 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N309maxProfit {
    @Test
    public void test(){
        int nums[] = {1,2,3,0,2};
        System.out.println(maxProfit(nums));
    }
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int len = prices.length;
        //sell、buy和rest，分别对应了到第i天为止最后一个操作是买入、卖出和冷冻所对应的最大利润
        int[] buy = new int[len];
        int[] sell = new int[len];
        int[] rest = new int[len];


        buy[0] = -prices[0];
        for (int i = 1; i < len ; i++) {
            sell[i] = Math.max(sell[i-1],buy[i-1]+prices[i]);     //buy[i-1]+prices[i]表示今天卖出  sell[i-1]今天不卖
            buy[i] = Math.max(buy[i-1],rest[i-1]-prices[i]);  //rest[i-1]-prices[i]表示今天买入   buy[i-1]今天不买
            rest[i] = Math.max(rest[i-1],sell[i-1]);
        }


        for (int i = 0; i < len ; i++) {
            System.out.print(sell[i]);

        }
        System.out.println();
        for (int i = 0; i < len ; i++) {

            System.out.print(buy[i]);


        }
        System.out.println();
        for (int i = 0; i < len ; i++) {
            System.out.print(rest[i]);

        }
        System.out.println();
        return sell[len-1];

    }
}
