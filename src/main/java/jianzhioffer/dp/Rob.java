package jianzhioffer.dp;

import java.util.ArrayList;
import java.util.List;

public class Rob {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,5,4,6};
//        System.out.println(rob(nums));
//        System.out.println(robdigui(nums,nums.length-1));
//        System.out.println(robdp(nums));



    }
    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i< len;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[len-1];
    }


    public static int robdp(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        int a = nums[0];
        int b = Math.max(nums[0],nums[1]);
        int c = 0;
        for(int i = 2;i< len;i++){
            c = Math.max(b,a+nums[i]);
            a = b;
            b = c;

        }
        return c;
    }


    public static int robdigui(int[] nums,int index) {
        if(index == 0){
            return nums[0];
        }
        if(index == 1){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(robdigui(nums,index-1),robdigui(nums,index-2)+nums[index]);
    }



}
