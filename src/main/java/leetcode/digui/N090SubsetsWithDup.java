package leetcode.digui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N090SubsetsWithDup {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return lists;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        process(list, nums, 0);
        return lists;

    }


    private void process(List<Integer> list, int[] nums, int start) {

        lists.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            process(list, nums, i+1);

            list.remove(list.size() - 1);

        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        new N090SubsetsWithDup().subsetsWithDup(nums);
    }
}
