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


    /*
    对一个数全排列可以看成如下的过程

    比如[1,2,3]的全排列可以按如下过程分解。
    首先确定第一个数1，然后再对[2,3]做全排列得到[1, 2, 3]和[1, 3, 2]。
    首先确定第一个数1，然后再对[1,3]做全排列得到[2, 1, 3]和[2, 3, 1]。
    首先确定第一个数3，然后再对[1,2]做全排列得到[3, 1, 2]和[3, 2, 1]。
    可清晰的可以得出如下结论permute({1,2,3}) = {1 + permute({2,3})} + {2 + permute({1,3})} + {3 + permute({1,2})}
    很明显这是一个递归的过程。将第一个位置的数字进行固定，然后对后面的数字进行递归。那么，如何写代码呢？
    我们可以在递归的过程中，可以将每个位置的数都和第一个数调换一下位置。此轮递归结束以后再进行一次回溯，也就是将数据换回来。
    举个例子，假如要枚举[1, 2, 3]以2开始的所有的排列。首先将2和1调换变为[2, 1, 3]。第一个数定位2.
    然后permute({1,3})。首先得到第一个解2，1，3.然后将1和3进行调换。得到第二个解2,3,1.求出两个解以后需要进行回溯，也就是将数据换回来。
    将1和3的位置换一下变为[2, 1, 3]，将1和2的位置换一下变为[1, 2, 3]。至此，以2开头的这轮过程结束。


     */
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        process(nums,0);
        return lists;
    }

    //变量start表示到达了某一层。
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










    /*
    方法二
    题目要求返回List<List<Integer>>。那么我们就新建一个 List<List<Integer>> 作为全局变量，最后将其返回。
    对于每一个位置的数，都有选和不选两种选择。加入我们用一个list来存储一次递归过程中加入的数字。

    因此在递归过程中我们大概需要有这样一段代码。

            for (int i = 0; i < nums.length ; i++){
                //加入
                list.add(nums[i]);
                process(list,nums);
                //回退
                list.remove(list.size()-1);

            }





    https://mp.weixin.qq.com/s/J9crLghcPwRjkLZBAI4Z7Q



     */







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
                //加入
                list.add(nums[i]);
                process(list,nums);
                //回退
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
