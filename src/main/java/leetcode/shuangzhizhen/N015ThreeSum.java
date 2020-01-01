package leetcode.shuangzhizhen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by reedfan on 2019/8/27 0027
 */
public class N015ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        new N015ThreeSum().threeSum(nums);
    }
    
       /*

本题最容易想到的方法应该就是暴力破解，但是靠暴力破解的话时间复杂度会到 O(n^3)，面试中显然不能让面试官满意。
采取如下方式可以将时间复杂度优化为 O(n^2)。
首先对数组进行排序，排序的时间复杂度 O(nlogn)。
在数组 nums 中，进行遍历，每遍历一个值取其下标i，形成一个固定值 nums[i]
再使用左指针 left = i + 1 ，右指针 right = nums.length - 1 。
根据 sum = nums[i] + nums[left] + nums[right] 的结果，
并判断 sum 与 0 的大小关系，因为数组有序，如果 sum == 0 ，则表明其实一组解，如果 sum < target 则 left++，
如果 sum > target 则 right--。
整个遍历过程时间复杂度为 O(n^2)
因此总时间复杂度：O(n^2)。

此外，还存在一些可优化的空间和一些需要注意的地方。
如果nums[i] > 0，因为数组有序，则后面的数肯定也都大于0，因此不可能找到三个数的何为0，可以直接结束循环了。
还要注意去重。本题是求三数之和。对于第一个数，如果nums[i] == nums[i - 1]，这种算是重复计算了。
同理对于第二个数，nums[left] == nums[left - 1]，对于第三个数nums[right] == nums[right + 1]也是重复计算。
*/


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
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] < 0 || (left > i + 1 && nums[left] == nums[left - 1])) {
                    left++;
                } else {
                    if (nums[left] + nums[right] + nums[i] > 0 || (right < nums.length - 1 && nums[right] == nums[right + 1])) {
                        right--;
                    } else {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[left++]);
                        list.add(nums[right--]);
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
