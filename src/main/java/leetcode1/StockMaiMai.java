package leetcode1;

/**
 * created by reedfan on 2019/4/28 0028
 */
public class StockMaiMai {

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfit(nums));

    }

    public static int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length-1 ; i++) {
            if(prices[i+1]>prices[i]){
                sum+= prices[i+1]-prices[i];
            }

        }
        return sum;
    }



}
