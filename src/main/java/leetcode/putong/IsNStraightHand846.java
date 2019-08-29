package leetcode.putong;

import java.util.Arrays;

/**
 * 爱丽丝有一手（hand）由整数数组给定的牌。
 * <p>
 * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 * <p>
 * 如果她可以完成分组就返回 true，否则返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：hand = [1,2,3,6,2,3,4,7,8], W = 3
 * 输出：true
 * 解释：爱丽丝的手牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * <p>
 * 示例 2：
 * <p>
 * 输入：hand = [1,2,3,4,5], W = 4
 * 输出：false
 * 解释：爱丽丝的手牌无法被重新排列成几个大小为 4 的组。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= hand.length <= 10000
 * 0 <= hand[i] <= 10^9
 * 1 <= W <= hand.length
 * <p>
 * 来源：力扣（LeetCode）  846
 * 链接：https://leetcode-cn.com/problems/hand-of-straights
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class IsNStraightHand846 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,6,2,3,4,7,8};
        System.out.println(new IsNStraightHand846().isNStraightHand(arr,3));
    }
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand == null || hand.length < W || W <= 0 || hand.length % W != 0) {
            return false;
        }
        if (W == 1) {
            return true;
        }
        Arrays.sort(hand);
        int len = hand.length;
        boolean[] visited = new boolean[len];
        int cnt = 0;
        int tmp = -1;
        int i = 0;
        int sum = 0;

        while (sum < len) {
            while (cnt < W && i< len) {
                if (!visited[i] && (hand[i] == tmp + 1 || tmp == -1)) {
                    cnt++;
                    sum++;
                    visited[i] = true;
                    tmp = hand[i];
                }
                i++;
            }
            if (sum == len) {
                return true;
            }
            if (cnt < W) {
                return false;
            } else {
                cnt = 0;
                tmp = -1;
                i = 0;
            }

        }

        return false;

    }
}
