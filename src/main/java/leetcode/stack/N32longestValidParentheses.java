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

/*
这是一个典型的栈的应用类问题
举个例子，
对于)()())来说我们将其下标记为0-5，最长有效括号子串为 "()()"，最长的包含有效括号的子串的长度为4，
其实取的就是1-4这一段，1和2匹配，3和4匹配。
其过程如下所示。
0   1   2   3   4   5
)   (   )   (   )   )
)           (   )   )
)                   )

我们用一个栈来存储坐标。为了方便计算，在最开始的时候，我们将栈里面放入一个-1.
当遇到的是'('的时候，我们将其坐标入栈，
当遇到的是'）'的时候，弹出栈顶元素。此时需要分两种情况。
此时如果栈空了，其实相当于前面已经正好匹配了，然后再进来了一个'）',此时无需更新
就将当期坐标入栈。

s.charAt(i)     stack                           max
                [-1]
)               弹出栈顶变为[],当前坐标入栈[0]
)(              1入栈[0,1]
)()             弹出栈顶变为[0]                    2
)()(            3入栈[0,3]
)()()           弹出栈顶变为[0]                    4
)()())          弹出栈顶变为[],当前坐标入栈[5]
因此max输出4
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
