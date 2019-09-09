package jianzhioffer;

import leetcode.digui.PermuteUnique47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 *
 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 输入描述:

 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。


 */

public class N27Permutation {
    public static void main(String[] args) {
        int[] nums = {1,1,3};
        new N27Permutation().Permutation(nums);

    }

    // TODO: 2019-09-08
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> Permutation(int[] nums) {
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

        HashSet<Integer> set = new HashSet<>();  //保存当前要交换的位置已经有过哪些数字了
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) {   //如果存在了就跳过，不去交换
                continue;
            }
            set.add(nums[i]);
            swap(nums, start, i);
            //这里是start+1
            process(nums, start + 1);
            swap(nums, start, i);
        }
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
