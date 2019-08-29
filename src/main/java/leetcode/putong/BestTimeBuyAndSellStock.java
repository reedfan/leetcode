package leetcode.putong;

public class BestTimeBuyAndSellStock {
    public static void main(String[] args) {
        int[] demo=new int[] {18, 9 ,5, 2};
        int result = computeMaxProfit3(demo);
        System.out.println("result = "+result);
    }

    /**
     * 题目的意思是说：假设您有一个数组，其中第 i 个元素是第 i 天给定股票的价格。
     * 如果你只被允许完成至多一笔交易（即买一份，卖一份股票），设计一个算法来找到最大利润。
     *
     * 请注意，在购买股票之前，您不能出售股票。
     *
     * 算法分析：
     *
     * 根据题目的意思分析出两点：（1）在购买股票之前，不能出售股票，即需要先买后买；
     * （2）只被允许完成至多一笔交易（即买一份，卖一份股票），那么第i天的价格可以看作是买入价也可以看作是卖出价。
     *
     * 算法设计
     *
     * 第一种：第i天的价格可以看作是买入价也可以看作是卖出价。假设prices[0]是最低价，记作min；最大利润profit初始值为0，记作maxProfit=0。
     *
     * 则遍历prices数组，不断的更新最低价；而利润呢？maxProfit = prices[i] - minPrice。


     */

    public static int computeMaxProfit1(int[] prices) {
        int len = prices.length;
        //处理异常情况
        if (prices == null ||  len== 0) {
            return 0;
        }

        int profit = 0;

        /*
        for (int i = 0; i < len-1 ; i++) {
            for (int j = i+1; j <len ; j++) {
                profit = (prices[j]-prices[i])>profit?(prices[j]-prices[i]):profit;

            }

        }*/
        /**
         * 存在很多重复计算，假如现在卖，那买肯定选前面价格最低的时候，因此可以用一个变量来记录前面的最小值。
         *
         */
        int minPrice = prices[0];
        for (int i = 1; i < len ; i++) {
            profit = profit>(prices[i]-minPrice)?profit:(prices[i]-minPrice);
            minPrice = minPrice<prices[i]?minPrice:prices[i];

        }

        return profit;

    }

    /**
    这个题目与“买卖股票的最佳时间问题之一”的区别在于：
    可以针对一支股票进行多次买卖；另外还有一个限制说明，即您不能同时进行多个交易（即，您必须在再次购买之前出售股票）。

     解析：明天的价格比今天的价格高，就可以今天买入，明天卖出1，3，4，2
     1买4卖  可以看成1卖 3卖 3买  4卖

     */
    public static int computeMaxProfit2(int[] prices) {
        if(prices.length ==0){
            return 0;
        }
        int profit = 0;
        int len = prices.length;
        for (int i = 1; i < len; i++) {
            if(prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];

            }

        }

        return profit;

    }

    /**
     * 最近越来越多的人都投身股市，阿福也有点心动了。谨记着“股市有风险，入市需谨慎”，阿福决定先来研究一下简化版的股票买卖问题。
     *
     * 假设阿福已经准确预测出了某只股票在未来 N 天的价格，他希望买卖两次，使得获得的利润最高。为了计算简单起见，利润的计算方式为卖出的价格减去买入的价格。
     *
     * 同一天可以进行多次买卖。但是在第一次买入之后，必须要先卖出，然后才可以第二次买入。
     *
     * 现在，阿福想知道他最多可以获得多少利润。
     * @param prices
     * @return
     */
    public static int computeMaxProfit3(int[] prices) {
        int len = prices.length;
        if(len ==0){
            return 0;
        }
        int profit = 0;

        int[] help = new int[len];  //记录以i结尾的最大收益

        int minPriceLeft = prices[0];

        //最晚在倒数第二天卖
        for (int i = 1; i <len-1 ; i++) {
            help[i] = help[i-1]>(prices[i]-minPriceLeft)?help[i-1]:(prices[i]-minPriceLeft);
            minPriceLeft = minPriceLeft<prices[i]?minPriceLeft:prices[i];
        }
        int maxPriceRight = prices[len-1];
        //最迟在倒数第二天买第二次,最早在第2天买第二次
        for (int i = len-2; i >0 ; i--) {
            profit = (maxPriceRight-prices[i]+help[i])>profit?(maxPriceRight-prices[i]+help[i]):profit;
            maxPriceRight=maxPriceRight>prices[i]?maxPriceRight:prices[i];

        }

        return profit;



    }
}
