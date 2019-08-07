package jianzhioffer.digui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode-cn.com/problems/combination-sum-ii/submissions/      40

public class combinationSum2 {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0 || target < 0){
            return lists;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        process(0,candidates,target,list);
        return lists;
    }

    private void process(int start,int[] candidates, int target, List<Integer> list){
        if(target<0){
            return;
        }
        if(target == 0){
            lists.add(new ArrayList<>(list));
        }else {
            for (int i = start; i < candidates.length; i++) {
                if(i > start && candidates[i] == candidates[i-1]) {
                    continue;

                }

                list.add(candidates[i]);
                process(i+1,candidates,target-candidates[i],list);
                list.remove(list.size()-1);
            }
        }

    }
}
