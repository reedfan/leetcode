package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N001twoSum {
    /*
    本题最简单的方法为两重循环暴力破解，但是这种方式时间复杂度为O(n^2),效率很低，面试中这种代码显然是不能让面试官满意的。我们可以利用hashMap来减少查询时间。hashmap的key为某个位置上的值，value为此位置的坐标。如果target - nums[i]为hashmap的某个key。则找到了两个数的和为target，返回这两个值即可。如果target - nums[i]不在hashmap的key中。则将其加入hashmap中。
     */

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (map.containsKey(value)) {
                return new int[] { map.get(value), i };
            }
            map.put(nums[i], i);
        }
        return null;

    }
}
