package leetcode.erfen;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * <p>
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * <p>
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）35
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N035searchInsert {

    /*
    本题和34题一样，都是二分法的变形题。
    只不过我们在写二分法的时候，最后的返回值是mid，此处返回left。
    为什么这么写？证明如下：
    假设我们给的数组是[...,3,5,...]。现在要找的数字是4
    到最后定位到left==right的时候，要么在3的位置，要么在5的位置。
    假如最后定位在3的位置，nums[mid] < target,然后left = mid + 1，最后返回的left就是3后面那个位置，符合要求。
    假如最后定位在5的位置，nums[mid] > target, 此时更新的是right，与left无关，最后返回的left就是5所在的位置，符合要求。





     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
