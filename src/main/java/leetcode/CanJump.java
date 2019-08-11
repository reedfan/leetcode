package leetcode;

/**
 * created by reedfan on 2019/8/6 0006
 */
public class CanJump {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));

    }
    public static boolean canJump(int[] nums) {

        if(nums == null){
            return false;
        }
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for(int i = 0;i< len-1;i++){
            if(dp[i]){
                for(int j = i;j<len&&j<= i+nums[i];j++){
                    dp[j] = true;

                }

            }

        }
        return dp[len-1];

    }
}
