package leetcode.dp;

import org.junit.Test;

/**
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。

 示例 1:
 输入:

 "bbbab"

 输出:

 4

 一个可能的最长回文子序列为 "bbbb"。

 示例 2:
 输入:

 "cbbd"

 输出:

 2

 一个可能的最长回文子序列为 "bb"。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



 状态

 f[i][j] 表示 s 的第 i 个字符到第 j 个字符组成的子串中，最长的回文序列长度是多少。

 转移方程

 如果 s 的第 i 个字符和第 j 个字符相同的话
 f[i][j] = f[i + 1][j - 1] + 2
 如果 s 的第 i 个字符和第 j 个字符不同的话
 f[i][j] = max(f[i + 1][j], f[i][j - 1])

 然后注意遍历顺序，i 从最后一个字符开始往前遍历，j 从 i + 1 开始往后遍历，这样可以保证每个子问题都已经算好了。

 初始化

 f[i][i] = 1 单个字符的最长回文序列是 1

 结果

 f[0][n - 1]

 作者：davidly
 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence/solution/zui-chang-hui-wen-zi-xu-lie-cyu-yan-shi-xian-by-da/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class N516longestPalindromeSubseq {
    @Test
    public void test(){
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];


        for (int i = len-1; i >=0 ; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < len ; j++) {
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }

            }

        }
        for (int i = 0; i < len ; i++) {
            for (int j = 0; j < len ; j++) {
                System.out.print(dp[i][j]);

            }
            System.out.println();

        }

        return dp[0][len-1];

    }
}
