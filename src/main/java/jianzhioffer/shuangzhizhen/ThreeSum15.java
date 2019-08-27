package jianzhioffer.shuangzhizhen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by reedfan on 2019/8/27 0027
 */
public class ThreeSum15 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        new ThreeSum15().threeSum(nums);
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //减枝
            if (nums[i] > 0) {
                break;
            }
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] + nums[i] < 0 || (start > i + 1 && nums[start] == nums[start - 1])) {
                    start++;
                } else {
                    if (nums[start] + nums[end] + nums[i] > 0 || (end < nums.length - 1 && nums[end] == nums[end + 1])) {
                        end--;
                    } else {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[start++]);
                        list.add(nums[end--]);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }


    /*public List<List<Integer>> threeSum(int[] nums) {
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

    }*/
}
