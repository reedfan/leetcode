package jianzhioffer.dp.knapsack;

public class KnapsackDigui {
    public static void main(String[] args) {
        int c=5;
        int v[]={6,10,12},w[]={1,2,3};
        int res= knapsack(c,w,v);
        System.out.println(res);
    }
    public static int knapsack(int capacity, int[] weights, int[] values) {
        int n = weights.length;
        //递归的套路，加一个index索引，控制递归到了哪一层
        return bestValue(capacity,n-1,weights,values);
    }

    private static int bestValue(int capacity, int index, int[] weights, int[] values){
        //递归的第一步：终止条件，没有商品了或者背包没容量了就终止
        if(index <= 0 || capacity<= 0){
            return 0;
        }
        //不放的情况
        int res = bestValue(capacity,index-1,weights,values);
        //放的情况，需要剩余满足容量>=weights[index]
        if(capacity >= weights[index]){
            //放的情况为bestValue(capacity - weights[index],index-1,weights,values)。也就是index放进去。其他的容量放
            //前面index-1
            res = Math.max(res,values[index]+bestValue(capacity - weights[index],index-1,weights,values));
        }
        return res;
    }
}
