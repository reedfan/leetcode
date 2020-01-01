package leetcode.array;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode） 14
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N014LongestCommonPrefix {

    /*

当字符串数组长度为 0 时则公共前缀为空，当字符串数组长度为1时，则公共前缀为strs[0]。可直接求出结果。
令最长公共前缀 为res，并进行初始化为第一个字符串。
遍历后面的字符串，依次将其与 为res 进行比较，两两找出公共前缀，最终结果即为最长公共前缀。
如果查找过程中出现了res为空或者strs[i]为空的情况，则公共前缀不为空串，直接返回。
时间复杂度：O(n)。


     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            if (str.equals("") || res.equals("")) {
                return "";
            }
            int start = 0;
            while (start < res.length() && start < str.length() && str.charAt(start) == res.charAt(start)) {
                start++;
            }
            res = res.substring(0, start);
        }
        return res;
    }

}
