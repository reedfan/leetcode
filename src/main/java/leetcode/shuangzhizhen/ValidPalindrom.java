package leetcode.shuangzhizhen;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * <p>
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * <p>
 * 来源：力扣（LeetCode）   680
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ValidPalindrom {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int len = s.length();
        int start = 0;
        int end = len-1;
        for (; start < end; start++, end--) {
            if (s.charAt(start) != s.charAt(end)) {
                return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
            }

        }
        return true;
    }

    private boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

}
