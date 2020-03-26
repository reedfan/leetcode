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

    /*

    以[2, 3, 1, 1, 4]为例，我们的目标是到达最后一个位置。
      1、因为倒数第二个位置为1，所以从倒数第二个位置可以到达最后一个位置。因此只要我们能到达倒数第二个位置就能到达最后一个位置。
      2、因为倒数第三个位置为1，所以从倒数第三个位置可以到达倒数第二个位置。因此只要我们能到达倒数第三个位置就能到达倒数第二个位置从而能到达最后一个位置。
      3、因为倒数第四个位置为3，所以从倒数第四个位置可以到达倒数第三个位置。因此只要我们能到达倒数第四个位置就能到达倒数第三个位置从而能到达最后一个位置。
      4、因为倒数第五个位置为2，所以从倒数第五个位置可以到达倒数第四个位置。因此只要我们能到达倒数第五个位置（也就是第一个位置)就能到达倒数第三个位置从而能到达最后一个位置。
      因此，可以到达最后一个位置。
    因此，我们用一个变量pos来表示需要到达的位置，并初始化为nums.length - 1表示需要到达的位置为最后一个位置。
    然后从nums.length - 2向前遍历，if(nums[i] + i >= pos)表示从当前位置出发能够到达pos，因此只要能到达当前位置i就可以到达pos，因此可以更新pos为i的值。
    遍历到最后如果pos==0，也就表示从开始能够跳到末尾。

     */


    //倒着推，速度比较快
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        //pos表示需要到达的位置
        int pos = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= pos) {
                pos = i;
            }

        }
        return pos == 0;

    }

    //顺着推，速度比较慢
    /*

    我们新建一个boolean[] dp来表示能否到达该位置。初始化dp[0]=true，此时dp为[true,false,false,false,false]。
    以nums = [2, 3, 1, 1, 4]为例，
    1、dp[0] = true, nums[0] = 2, 因此往后推两个位置也可到达，此时dp为[true,true,true,false,false]。
    2、dp[1] = true, nums[1] = 3, 因此往后推两个位置也可到达，此时dp为[true,true,true,true,true]。
       此时dp[4] = true,其实已经可以表示能到达末尾了。这种表示方法在下面的代码中用表示一
    3、dp[2] = true, nums[2] = 1, 因此往后推一个位置也可到达，此时dp为[true,true,true,true,true]。
    4、dp[3] = true, nums[3] = 1, 因此往后推一个位置也可到达，此时dp为[true,true,true,true,true]。
       此种方式用方式二表示

     */
    public boolean canJump1(int[] nums) {

        if (nums == null || nums.length == 0) {
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
            if (dp[len - 1]) {
                return true;
            }

        }
        return dp[len - 1];

    }


    public boolean canJump2(int[] nums) {

        if (nums == null || nums.length == 0) {
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
