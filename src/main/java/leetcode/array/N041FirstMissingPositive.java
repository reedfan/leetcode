package leetcode.array;

import org.junit.Test;

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 *
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 * 说明:
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 *
 * 来源：力扣（LeetCode）  41
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N041FirstMissingPositive {
    @Test
    public void test(){
        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }

    //分两步 第一步：将数据放到他本来应该在的位置，即nums[i]=i+1,
    //第二步：遍历数组，如果哪个位置nums[i]!=i+1,则他就是缺失的数
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 1;
        }
        int len = nums.length;
        for (int i = 0; i < len ; i++) {
            while (nums[i] >0 && nums[i] <= len && nums[i]!=nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
        }
        int i = 0;

        for (; i < len; i++) {
            if(nums[i] != i+1){
                break;
            }
        }

        return i+1;
    }

    private void swap(int[] nums,int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
