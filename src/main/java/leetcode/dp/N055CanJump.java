package leetcode.dp;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N055CanJump {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new N055CanJump().canJump(nums));

    }


    //倒着推，速度比较快
    public boolean canJump(int[] nums) {
        if(nums == null){
            return false;
        }
        //pos表示需要到达的位置
        int pos = nums.length - 1;
        for (int i = nums.length - 2 ; i >= 0 ; i--) {
            if(nums[i] + i >= pos){
                pos = i;
            }

        }
        return pos == 0;

    }

    //顺着推，速度比较慢
    public boolean canJump1(int[] nums) {

        if (nums == null) {
            return false;
        }
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for (int i = 0; i < len - 1; i++) {
            if (dp[i]) {
                for (int j = i; j < len && j <= i + nums[i]; j++) {
                    dp[j] = true;

                }

            }

        }
        return dp[len - 1];

    }
}
