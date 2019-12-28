package leetcode.huiwen;

public class N005LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new N005LongestPalindrome().longestPalindrome("ac"));
    }


    //动态规划法
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxend = 0;    //最长回文串的终点
        int maxlen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxlen) {
                        maxlen = r - l + 1;
                        maxStart = l;
                        maxend = r;

                    }
                }

            }

        }
        return s.substring(maxStart, maxend + 1);

    }

    /*

本题最容易想到的一中方法应该就是中心扩散法。
中心扩散法怎么去找回文串？从每一个位置出发，向两边扩散即可。遇到不是回文的时候结束。
举个例子，str = "acdbbdaa"。我们需要寻找从第一个b（位置为3）出发最长回文串为多少。怎么寻找？
首先往左和往右寻找与当期位置相同的字符，

     */

    //中心扩散法
    public String longestPalindrome1(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        int strLen = s.length();
        int left = 0;
        int right = 0;
        int len = 1;
        int maxstart = 0;
        int maxlen = 0;

        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > maxlen) {
                maxlen = len;
                maxstart = left;
            }
            len = 1;
        }
        return s.substring(maxstart + 1, maxstart + maxlen + 1);

    }
}
