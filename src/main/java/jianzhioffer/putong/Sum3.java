package jianzhioffer.putong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));

    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length<3){
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2;) {
            int j = i+1;
            int k = nums.length-1;
            while (j<k){
                if(nums[j]+nums[k]+nums[i] == 0){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    j++;
                    k--;
                    // 从左向右找第一个与之前处理的数不同的数的下标
                    while (j<k&&nums[j]==nums[j-1]){
                        j++;
                    }
                    // 从右向左找第一个与之前处理的数不同的数的下标
                    while (j<k&&nums[k]==nums[k+1]){
                        k--;

                    }

                }else {
                    if(nums[j]+nums[k]+nums[i] < 0){
                        j++;
                        // 从左向右找第一个与之前处理的数不同的数的下标
                        while (j<k&&nums[j]==nums[j-1]){
                            j++;
                        }
                    }else {
                        k--;
                        // 从右向左找第一个与之前处理的数不同的数的下标
                        while (j<k&&nums[k]==nums[k+1]){
                            k--;

                        }
                    }

                }

            }
            // 指向下一个要处理的数
            i++;
            // 从左向右找第一个与之前处理的数不同的数的下标
            while (i < nums.length - 2 && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return result;
    }
}
