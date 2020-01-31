package leetcode.erfen;

public class N34searchRange {

    /*
 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]

示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int[] searchRange(int[] nums, int target) {
        assert nums!= null;

        if(nums.length == 0){
            return new int[]{-1,-1};
        }

        int[] res = new int[]{findLeft(nums, target),findRight(nums, target)};
        return res;


    }

    private int findLeft(int[] nums, int target){
        int len = nums.length;
        int res = -1;
        int start = 0;
        int end = len - 1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] < target){
                start = mid + 1;
            }
             else {
                if(nums[mid] == target){
                    res = mid;
                }
                end = mid - 1;
            }
        }

        return res;

    }

    private int findRight(int[] nums, int target){
        int len = nums.length;
        int res = -1;
        int start = 0;
        int end = len - 1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] > target){
                end = mid - 1;
            }
            else {
                if(nums[mid] == target){
                    res = mid;
                }
                start = mid + 1;

            }
        }

        return res;

    }
}
