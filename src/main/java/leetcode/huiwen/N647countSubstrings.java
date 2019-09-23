package leetcode.huiwen;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * <p>
 * 示例 2:
 * <p>
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N647countSubstrings {
    public static void main(String[] args) {
        new N647countSubstrings().countSubstrings("fdsklf");
    }

    //中心扩散法效果更佳
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += process(s, i, i);
            count += process(s, i, i + 1);
        }
        return count;

    }

    private int process(String s, int left, int right) {
        int cnt = 0;
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) {
            cnt++;
        }
//        while (left >= 0 && right < s.length()) {
//            if (s.charAt(left--) == s.charAt(right++)) {
//                cnt++;
//            }else {
//                break;
//            }
//        }
        return cnt;
    }


    public int countSubstrings1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        int len = s.length();
        //dp[i][j] s.subString(i,j+1)是否为回文
        boolean[][] dp = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                if (left == right) {
                    dp[left][right] = true;
                    count++;
                    continue;
                }
                if (s.charAt(right) == s.charAt(left) && (right - left < 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                    count++;
                }
            }



            /*
            不能把左放在第一层
            dp[i][i] = true;
            count++;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    count++;
                }
            }*/


        }
        return count;

    }
}
