package leetcode.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class N217containsDuplicate {

    /*
    给定一个整数数组，判断是否存在重复元素。

如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

示例 1:

输入: [1,2,3,1]
输出: true

示例 2:

输入: [1,2,3,4]
输出: false

示例 3:

输入: [1,1,1,3,3,4,3,2,4,2]
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/contains-duplicate
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

     */

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 1};
        //int[] nums = new int[4];
        // nums[0] = 1;
        System.out.println(containsDuplicate(nums));
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        /*N217containsDuplicate n217containsDuplicate = new N217containsDuplicate();

        n217containsDuplicate.containsDuplicate(nums);*/

        System.out.println(containsDuplicate(nums));

    }


    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        Set<Integer> set = new HashSet<>();



        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }


        return false;
    }



}
