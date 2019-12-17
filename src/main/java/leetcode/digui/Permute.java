package leetcode.digui;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    /**
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,2,3]
     * 输出:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    List<List<Integer>> lists = new ArrayList<>();

    boolean[] visted;

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        visted = new boolean[nums.length];
        process(nums, list);
        return lists;
    }

    private void process(int[] nums, List<Integer> list) {
        if (nums.length == list.size()) {
            lists.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visted[i]) {
                visted[i] = true;
                list.add(nums[i]);
                process(nums, list);
                visted[i] = false;
                list.remove(list.size() - 1);
            }

        }


    }

    private void swap(int[] nums, int pos1, int pos2) {
        int tmp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = tmp;
    }
}
