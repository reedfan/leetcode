package jianzhioffer.digui;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * <p>
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * 来源：力扣（LeetCode）  216
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class combinationSum216 {

    public static void main(String[] args) {
        new combinationSum216().combinationSum3(3,7);
    }
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n <= 0 || k <= 0 || n < k) {
            return lists;
        }
        process(n, k, new ArrayList<Integer>(), 1);
        return lists;
    }

    private void process(int sum, int cnt, List<Integer> list, int start) {
        if (sum == 0 && cnt == list.size()) {
            lists.add(new ArrayList<>(list));
            return;
        }
        if (sum <= 0 || cnt <= 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            process(sum - i, cnt, list, i + 1);
            //回溯
            list.remove(list.size() - 1);
        }

    }

}
