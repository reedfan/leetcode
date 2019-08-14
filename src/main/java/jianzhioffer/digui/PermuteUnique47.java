package jianzhioffer.digui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）  47
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PermuteUnique47 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        new PermuteUnique47().permuteUnique(nums);

    }

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return lists;
        }
        Arrays.sort(nums);
        process(nums, 0);
        return lists;

    }

    private void process(int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<Integer>();
            for (int num : nums) {
                list.add(num);
            }
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            swap(nums, start, i);
            //这里是start+1
            process(nums, i + 1);
            swap(nums, start, i);
        }
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
