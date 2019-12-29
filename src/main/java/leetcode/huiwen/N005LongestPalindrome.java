package leetcode.huiwen;

public class N005LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new N005LongestPalindrome().longestPalindrome("ac"));
    }


    //
    // 动态规划法
    /*
    中心扩散的方法，其实做了很多重复计算。动态规划就是为了减少重复计算的问题。动态规划听起来很高大上。其实说白了就是空间换时间，
    将计算结果暂存起来，避免重复计算。作用和工程中用redis做缓存有异曲同工之妙。
    我们用一个boolean dp[l][r]表示字符串从i到j这段是否为回文。试想如果dp[l][r]=true，我们要判断dp[l-1][r+1]是否为回文。
    只需要判断字符串在(l-1)和（r+1)两个位置是否为相同的字符，是不是减少了很多重复计算。

    进入正题，动态规划关键是找到初始状态和状态转移方程。
    初始状态,l=r时，此时dp[l][r]=true。
    状态转移方程,dp[l][r]=true并且(l-1)和（r+1)两个位置为相同的字符,此时dp[l-1][r+1]=true

     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;

                    }
                }

            }

        }
        return s.substring(maxStart, maxEnd + 1);

    }

    /*

本题最容易想到的一种方法应该就是中心扩散法。
中心扩散法怎么去找回文串？从每一个位置出发，向两边扩散即可。遇到不是回文的时候结束。
举个例子，str = "acdbbdaa"。我们需要寻找从第一个b（位置为3）出发最长回文串为多少。怎么寻找？
首先往左寻找与当期位置相同的字符，直到遇到不相等为止。
然后往右寻找与当期位置相同的字符，直到遇到不相等为止。
最后左右双向扩散，直到左和右不相等。如下图所示:

每个位置向两边扩散都会出现一个窗口大小（len）。如果len>maxLen(用来表示最长回文串的长度）。则更新maxLen的值。
因为我们最后要返回的是具体子串，而不是长度，因此，还需要记录一下maxLen时的起始位置（maxStart），即此时还要maxStart=len。


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
        int maxStart = 0;
        int maxLen = 0;

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
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);

    }
}
