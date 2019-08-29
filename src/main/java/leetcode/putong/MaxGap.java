package leetcode.putong;

/**
 * https://www.cnblogs.com/xiaomoxian/p/5189782.html
 */
public class MaxGap {

    public static void main(String[] args) {
        int[] nums = {5,7,2,3,10,4};
        System.out.println(maxGap(nums));

    }

    public static int maxGap(int[] nums){

        if(nums == null || nums.length<2){
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len ; i++) {
            max = Math.max(nums[i],max);
            min = Math.min(nums[i],min);
        }
        if(min == max){
            return 0;
        }

        boolean[] hasNum = new boolean[len+1];
        int[] maxs = new int[len+1];
        int[] mins = new int[len+1];

        int bid = 0;

        for (int i = 0; i < len ; i++) {
            //算出桶号
            bid = bucket(nums[i],len,min,max);
            //更新桶中的最大值与最小值
            mins[bid] = hasNum[bid]?Math.min(mins[bid],nums[i]):nums[i];
            maxs[bid] = hasNum[bid]?Math.max(maxs[bid],nums[i]):nums[i];
            hasNum[bid] = true;

        }

        int res  =0;
        int lastMax = 0;
        int i = 0;
        //找到第一个不为空的桶
        while (i<=len){
            if(hasNum[i++]){
                lastMax = maxs[i-1];
                break;
            }
        }

        for(;i<= len;i++){
            //有数的话，当前最小值减去前面的最大值，然后更新最大值
            if(hasNum[i]){
                res = Math.max(res,mins[i]-lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    //使用long是为了防止溢出
    public static int bucket(long num,long len,long min,long max){
        return (int)((num-min)*len/(max-min));
    }


}
