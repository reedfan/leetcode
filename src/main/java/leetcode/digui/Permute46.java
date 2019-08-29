package leetcode.digui;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permute46 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> lists = permute(nums);
        System.out.println(lists);

    }

    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(lists,new ArrayList<>(),nums);
        return lists;

    }

    /**
     * Perms( nums[0…n-1] ) = {取出一个数字} +
     * Perms( nums[{0…n-1} - 这个数字] )
     *
     */
    private static void backtrack(List<List<Integer>>lists, List<Integer> tempList,int[] nums){
        if(tempList.size() == nums.length){
            lists.add(new ArrayList<>(tempList));
        }else {
            for (int num:nums) {
                if(tempList.contains(num)){
                    continue;
                }
                tempList.add(num);
                backtrack(lists, tempList, nums);
                tempList.remove(tempList.size()-1);

            }
        }
    }


}
