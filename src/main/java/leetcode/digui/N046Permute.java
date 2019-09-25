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
public class N046Permute {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> lists = new N046Permute().permute(nums);
        System.out.println(lists);
    }


    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        process(nums,0);
        return lists;
    }

    private void process(int[] nums, int start) {
        //如果起始位置已经到达了末尾，那么这就是一组解。
        if(start == nums.length){
            List<Integer>list = new ArrayList<>();
            for(int num:nums){
                list.add(num);
            }
            lists.add(list);
        }
        for (int i = start; i < nums.length ; i++) {
            //把第一个元素分别与后面的元素进行交换，递归的调用其子数组进行排序
            swap(nums,i,start);
            process(nums,start+1);
            swap(nums,i,start);

        }
    }

    private void swap(int[] nums, int index1, int index2){
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }




    //回溯写法
    /*List<List<Integer>> lists = new ArrayList<>();
    boolean[] visted;
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        visted = new boolean[nums.length];
        process(list,nums);
        return lists;

    }

    private void process( List<Integer> list, int[] nums) {
        //终止条件
        if(list.size() == nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length ; i++) {
            if(!visted[i]){
                visted[i] = true;
                list.add(nums[i]);
                process(list,nums);
                list.remove(list.size()-1);
                visted[i] = false;

            }

        }

    }*/


























    /*public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(lists,new ArrayList<>(),nums);
        return lists;

    }

    *//**
     * Perms( nums[0…n-1] ) = {取出一个数字} +
     * Perms( nums[{0…n-1} - 这个数字] )
     *
     *//*
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
    }*/


}
