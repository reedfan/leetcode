package leetcode.array;

/**
 * https://blog.csdn.net/qq_41231926/article/details/86261978
 */
public class MaxProduct {

    public int maxProduct(int[] nums){

        int[] maxdp = new int[nums.length];
        int[] mindp = new int[nums.length];
        maxdp[0] = maxdp[0] = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            if (nums[i] >= 0) {
                maxdp[i] = Math.max(maxdp[i - 1] * nums[i], nums[i]);
                mindp[i] = Math.min(mindp[i - 1] * nums[i], nums[i]);
            }else {
                maxdp[i] = Math.max(mindp[i - 1] * nums[i], nums[i]);
                mindp[i] = Math.min(maxdp[i - 1] * nums[i], nums[i]);
            }
        }
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < maxdp.length ; i++){
            if(maxdp[i] > result){
                result = maxdp[i];
            }
        }
        return result;
    }
}
