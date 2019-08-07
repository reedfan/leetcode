package jianzhioffer.putong;

import java.util.ArrayList;
import java.util.List;

/**
 * created by reedfan on 2019/5/29 0029
 */
public class Permute {

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
