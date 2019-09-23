package leetcode.array;

/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N739dailyTemperatures {
    public int[] dailyTemperatures(int[] t) {
        if (t.length == 0) {
            return t;
        }
        int len = t.length;
        int[] res = new int[len];
        res[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j += res[j]) {
                if (t[j] > t[i]) {
                    res[i] = j - i;
                    break;
                }
                if (res[j] == 0) {
                    res[i] = 0;
                    break;
                }
            }
        }
        return res;
    }
}
