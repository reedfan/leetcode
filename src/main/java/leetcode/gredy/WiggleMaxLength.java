package leetcode.gredy;

import org.junit.Test;

public class WiggleMaxLength {

    @Test
    public void test(){
        int[] nums1 = {1,7,4,9,2,5};
        System.out.println(wiggleMaxLength(nums1));

        int[] nums2 = {1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleMaxLength(nums2));

        int[] nums3 = {1,2,3,4,5,6,7,8,9};
        System.out.println(wiggleMaxLength(nums3));

    }

    /**
     *
     * jianzhioffer 376
     */

    public int wiggleMaxLength(int[] nums){
        if(nums == null){
            return 0;
        }
        if(nums.length<2){
            return nums.length;
        }

        int len = 1;
        boolean flag = false;
        for (int i = 1; i < nums.length ; i++) {
            if(nums[i] == nums[i-1]){
                continue;
            }
            if(flag != (nums[i] > nums[i-1])){
                len ++;
                flag = nums[i] > nums[i-1];

            }

        }
        return len;

    }


}
