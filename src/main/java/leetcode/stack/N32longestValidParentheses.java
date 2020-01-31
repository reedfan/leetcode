package leetcode.stack;

import java.util.Stack;

public class N32longestValidParentheses {

    /*
 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"

示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int longestValidParentheses(String s) {
        assert s != null;
        if (s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        stack.add(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = max > (i - stack.peek()) ? max : (i - stack.peek());
                }

            }

        }
        return max;

    }
}
