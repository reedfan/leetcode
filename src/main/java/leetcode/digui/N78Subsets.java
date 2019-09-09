package leetcode.digui;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N78Subsets {

    private ArrayList<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res  = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        res.add(new ArrayList<>());
        generate(0, nums, list);
        return res;
    }

    private void generate(int start, int[] nums, List<Integer> list) {
        //终止条件
        if (start >= nums.length) {
            return;
        }
        //选择放入次数
        list.add(nums[start]);
        res.add(new ArrayList<>(list));
        generate(start + 1, nums, list);
        //选择不放入次数
        list.remove(list.size()-1);
        generate(start + 1, nums, list);
    }

    // 求解C(n,k), 当前已经找到的组合存储在c中, 需要从start开始搜索新的元素
    private void generateCombinations(int[] nums, int n, int k, int start, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        //减枝  i <= n-(k-list.size())+1
        for (int i = start; i < n - (k - list.size()) + 1; i++) {
            list.add(nums[i]);
            generateCombinations(nums, n, k, i + 1, list);
            list.remove(list.size() - 1);

        }
    }

    public List<List<Integer>> subsets1(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i <= len; i++) {
            generateCombinations(nums, len, i, 0, list);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = (new N78Subsets()).subsets(nums);


    }

}
