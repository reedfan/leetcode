package leetcode.array;


/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N215findKthLargest {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(new N215findKthLargest().findKthLargest(nums, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }
        return find(nums, 0, nums.length - 1, k);
    }

    //逆排序
    private int find(int[] nums, int left, int right, int k) {
        int start = left;
        int end = right;
        int key = nums[start];

        while (start < end) {
            while (start < end && nums[end] <= key) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] >= key) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = key;

        if (start == k - 1) {
            return key;
        }
        //比key大的个数少于k-1个，去后半部分找
        if (start < k - 1) {
            return find(nums, start + 1, right, k );
        }
        return find(nums, left, start - 1, k);

    }
}
