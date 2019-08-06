package jianzhioffer.digui;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * created by reedfan on 2019/7/17 0017
 */
public class PaiLie {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Stack<Integer> stack = new Stack<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        generate(0, nums, stack, result);
        System.out.println(result);

    }

    private static void generate(int i, int[] nums, Stack<Integer> stack, ArrayList<ArrayList<Integer>> result) {
        if (i >= nums.length) {
            return;
        }
        stack.push(nums[i]);
        result.add(new ArrayList<>(stack));
        //放入nums[i]的情况
        generate(i + 1, nums, stack, result);
        stack.pop();
        //不放入nums[i]的情况
        generate(i + 1, nums, stack, result);
    }

}
