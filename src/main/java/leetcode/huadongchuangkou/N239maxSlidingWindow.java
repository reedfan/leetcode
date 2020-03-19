package leetcode.huadongchuangkou;

import java.util.*;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N239maxSlidingWindow {

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(res));

    }

    /*
    新建一个双端队列 LinkedList<Integer> maxList用来记录每个窗口的最大值下标
    新建一个数组int[] res = new int[nums.length - k + 1]用来记录最后的结果。

    对于nums = {1, 3, -1, -3, 5, 3, 6, 7}   k = 3

    1、刚开始maxList为空，第一个位置0进入双端队列。maxList [0],   res[0,0,0,0,0,0]
    2、(nums[maxList最后一位] = 1) < (nums[1] = 3) 。0出队，1入队。maxList [1],   res[0,0,0,0,0,0]
    3、位置2为-1，(nums[maxList最后一位] = 3) > (nums[2] = -1).2直接入队列。maxList [1,2], res[0,0,0,0,0,0]
    4、位置3为-3，(nums[maxList最后一位] = 3) > (nums[3] = -3).3直接入队列。
       maxList [1,2,3], res[i + 1 - k] = nums[maxList.peekFirst()] res[3,0,0,0,0,0]
    5、位置4为5，(nums[maxList最后一位] = 3) < (nums[3] = 5).3直接入队列。
       maxList [1,2,3], res[i + 1 - k] = nums[maxList.peekFirst()] res[0,0,0,0,0,0]


     */



    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return nums;
        }

        assert (nums.length >= k);
        int[] res = new int[nums.length - k + 1];
        //双端队列，用来记录每个窗口的最大值下标
        LinkedList<Integer> maxList = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            //如果当前元素比队列的最后一个元素大，那么就将最后一个元素出队，重复这步直到当前元素小于队列的最后一个元素或者队列为空
            //这样能确保队列左边的元素是最大的
            while (!maxList.isEmpty() && nums[maxList.peekLast()] < nums[i]) {
                maxList.pollLast();
            }
            maxList.addLast(i);

            //判断是否超出这个窗口
            if (i - maxList.peekFirst() == k) {
                maxList.pollFirst();
            }

            if (i + 1 >= k) {
                res[i + 1 - k] = nums[maxList.peekFirst()];
            }
        }

        return res;

    }
}
