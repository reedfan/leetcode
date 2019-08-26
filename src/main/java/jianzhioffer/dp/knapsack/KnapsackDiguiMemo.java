package jianzhioffer.dp.knapsack;

public class KnapsackDiguiMemo {

    public static void main(String[] args) {
        int c=5;
        int v[]={6,10,12},w[]={1,2,3};
        int res= knapsack(c,w,v);
        System.out.println(res);
    }
    static int[][] memo;
    public static int knapsack(int capacity, int[] weights, int[] values) {
        int n = weights.length;
        //因为有商品和价值两个维度，所以需要用一个二维的空间来记录
        memo = new int[n][capacity+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= capacity ; j++) {
                memo[i][j] = -1;

            }
        }
        return bestValue(capacity,n-1,weights,values);
    }

    private static int bestValue(int capacity, int index, int[] weights, int[] values){
        //递归的第一步：终止条件，没有商品了或者背包没容量了就终止
        if(index <= 0 || capacity<= 0){
            return 0;
        }
        //如果已经有缓存，直接从缓存中取即可，避免重复计算
        if (memo[index][capacity] != -1){
            return memo[index][capacity];
        }
        //不放的情况
        int res = bestValue(capacity,index-1,weights,values);
        //放的情况，需要剩余满足容量>=weights[index]
        if(capacity >= weights[index]){
            //放的情况为bestValue(capacity - weights[index],index-1,weights,values)。也就是index放进去。其他的容量放
            //前面index-1
            res = Math.max(res,values[index]+bestValue(capacity - weights[index],index-1,weights,values));
        }
        //将计算的结果加入缓存
        memo[index][capacity] = res;
        return res;
    }
}
