package jianzhioffer.tanxin;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * <p>
 * 说明:
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）   45
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Jump45 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(new Jump45().jump(nums));
    }
    public int jump(int[] nums) {
        int cnt = 0;
        if (nums == null || nums.length == 0) {
            return cnt;
        }
        int len = nums.length;
        int maxPos = 0;
        int right = 0;   //此次最远能到达的位置

        /**
         * 这里要注意一个细节，就是 for 循环中，i < nums.length - 1，少了末尾。因为开始的时候边界是第 0 个位置，steps 已经加 1 了。
         * 如下图，如果最后一步刚好跳到了末尾，此时 steps 其实不用加 1 了。如果是 i < nums.length，i 遍历到最后的时候，会进入 if 语句中，steps 会多加 1 。
         */
        for (int i = 0; i < len - 1; i++) {
            maxPos = (nums[i] + i) > maxPos ? (nums[i] + i) : maxPos;
            if(i == right){
                cnt++;
                right = maxPos;
            }


        }

        return cnt;

    }
}
