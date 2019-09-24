package leetcode.array;

import java.util.Scanner;

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 * <p>
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * <p>
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 * 或者返回索引 5， 其峰值元素为 6。
 * <p>
 * 说明:
 * <p>
 * 你的解法应该是 O(logN) 时间复杂度的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N162findPeakElement {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        int res = new N162findPeakElement().findPeakElement(nums);
        System.out.println(res);
    }


    /**
     * 由于nums[-1] = nums[n] = -∞,则峰值一定存在，所以用二分的话，if(nums[mid] > nums[mid + 1])表示左侧存在，
     * 否则去右侧找
     */
    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int start = 0;

        int end = nums.length - 1;

        int mid;

        while (start < end) {

            mid = start + (end - start) / 2;
            //表示左侧存在

            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }

        }
        return start;

    }


}
