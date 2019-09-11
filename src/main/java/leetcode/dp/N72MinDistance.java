package leetcode.dp;

public class N72MinDistance {
    public static void main(String[] args) {
        System.out.println(new N72MinDistance().minDistance("horse", "ros"));

    }


    /**
     * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
     * <p>
     * 你可以对一个单词进行如下三种操作：
     * <p>
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * <p>
     * 示例 1:
     * <p>
     * 输入: word1 = "horse", word2 = "ros"
     * 输出: 3
     * 解释:
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     * <p>
     * 示例 2:
     * <p>
     * 输入: word1 = "intention", word2 = "execution"
     * 输出: 5
     * 解释:
     * intention -> inention (删除 't')
     * inention -> enention (将 'i' 替换为 'e')
     * enention -> exention (将 'n' 替换为 'x')
     * exention -> exection (将 'n' 替换为 'c')
     * exection -> execution (插入 'u')
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/edit-distance
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param word1
     * @param word2
     * @return
     */

    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        }
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }
        int row = word1.length() + 1;
        int col = word2.length() + 1;
        //dp[i][j] word1的前i个字符变成word2的前j个字符的距离
        int[][] dp = new int[2][col];

        //全加上
        for (int i = 0; i < col; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < row; i++) {
            dp[i % 2][0] = dp[(i - 1) % 2][0] + 1;
            for (int j = 1; j < col; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1];
                } else {
                    //替换
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + 1;
                }
                //删除
                dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j] + 1, dp[i % 2][j]);
                //增加
                dp[i % 2][j] = Math.min(dp[i % 2][j - 1] + 1, dp[i % 2][j]);

            }

        }

        return dp[(row-1) % 2][col - 1];

    }

    public int minDistance1(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        }
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }
        int row = word1.length() + 1;
        int col = word2.length() + 1;
        //dp[i][j] word1的前i个字符变成word2的前j个字符的距离
        int[][] dp = new int[row][col];
        //空串的时候，   把字符全删了
        for (int i = 0; i < row; i++) {
            dp[i][0] = i;
        }

        //全加上
        for (int i = 0; i < col; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //替换
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                //删除
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j]);
                //增加
                dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i][j]);

            }

        }

        return dp[row - 1][col - 1];

    }


}
