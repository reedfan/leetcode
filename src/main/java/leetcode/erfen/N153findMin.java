package leetcode.erfen;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

 请找出其中最小的元素。

 你可以假设数组中不存在重复元素。

 示例 1:

 输入: [3,4,5,1,2]
 输出: 1

 示例 2:

 输入: [4,5,6,7,0,1,2]
 输出: 0

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


/**
 *       0  1   2  3  4  5  6  7
 *
 *       7   0  1  2  3  4  5  6
 *
 *       1   2  3  4  5  6  7   0   nums[mid]>nums[end]这种情况下。说明最小值在中点的右边
 *
 *
 *
 */


public class N153findMin {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(new N153findMin().findMin(nums));
    }





    public int findMin(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        return process(nums,0,nums.length-1);
    }

    private int process(int[] nums, int start, int end){
        int mid = 0;
        while (start < end){
            mid = start + (end -start) /2;
            //前半部分有序，一定在后半部分
            if(nums[mid] > nums[end]){
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        return nums[start];
    }
}
