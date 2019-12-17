package leetcode.digui;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum {




    List<List<Integer>> lists = new ArrayList<>();

    @Test
    public void test(){
        int[] candidates = {2,3,5};
        System.out.println(combinationSum(candidates,8));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {


        List<Integer> list = new ArrayList<>();
        process(candidates,target,0,list);

        return lists;


    }

    private void process(int[] candidates, int target, int index, List<Integer> list) {
        if (target < 0){
            return;
        }
        if(target == 0 ){
            lists.add(new ArrayList<>(list));
        } else {
            for (int i = index; i < candidates.length ; i++) {

                list.add(candidates[i]);
                process(candidates, target - candidates[i], i, list);
                list.remove(list.size()-1);


            }
        }


    }
}
