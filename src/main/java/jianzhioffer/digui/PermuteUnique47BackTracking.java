package jianzhioffer.digui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）  47
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class PermuteUnique47BackTracking {
    List<List<Integer>> lists = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return lists;
        }
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        List<Integer>list = new ArrayList<>();
        process(nums, 0,list);
        return lists;

    }
    private void process(int[] nums, int start, List<Integer>list){
        if(list.size() == nums.length){
            lists.add(new ArrayList<>(list));

            return;
        }
        //为什么从0开始
        /**
         *  Perms( nums[0…n-1] ) = {取出一个数字} +
         *      * Perms( nums[{0…n-1} - 这个数字] )
         */
        for (int i = 0; i < nums.length ; i++) {
            if(visited[i]){
                continue;
            }

            ////i-1和i的值相等，且i-1没被用过（之后可能会被用就产生重复）

            //基本难点就是要去掉重复的
            //以这个[1,1,2]为例
            //正常会返回6个结果：其中第一行是以下标为0的1开始，而第二行是以下标为1的1开始。
            //1，1，2；1，2，1
            //1，1，2；1，2，1
            //2，1，1；2，1，1
            //去重做法就是，在dfs时要判断i和i-1是否相等和i-1这个值是否被用。
            //相等和没有被用就跳过这个i的情况，直接去i+1判断。
            //因为没被用的话，之后就可以再用这个i-1，那就会出现重复的情况。
            //比如说第二行是i=1时的判断，此时i和i-1的值相等，且i-1的值没被用
            //那么跳过i=1这个情况，直接去i=2，所以我们就去掉了第二行所有重复的。

            if(i>0 && nums[i] == nums[i-1] &&!visited[i-1]){
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            process(nums,start+1,list);
            visited[i] = false;
            list.remove(list.size()-1);

        }

    }
}
