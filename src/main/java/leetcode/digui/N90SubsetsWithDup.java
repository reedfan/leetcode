package leetcode.digui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode-cn.com/problems/subsets-ii       90
public class N90SubsetsWithDup {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null || nums.length == 0){
            return lists;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        process(list,nums,0);
        return lists;

    }


    private void process(List<Integer> list, int[] nums, int start){
        lists.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if(i>start  &&  nums[i] == nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            process(list,nums,+1);

            list.remove(list.size()-1);

        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        new N90SubsetsWithDup().subsetsWithDup(nums);
    }
}
