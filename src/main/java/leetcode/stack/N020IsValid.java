package leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N020IsValid {
    public static void main(String[] args) {
        System.out.println(new N020IsValid().isValid("{[]}"));
    }

    /*
    本题是一个典型的栈的应用
    首先s的长度必须为偶数，如果为奇数，直接返回false即可。
    记c = s.charAt(i)，如果c为括号的左半边（即c == '(' || c == '[' || c == '{'），此时直接入栈即可。此处其实还可以进行下剪枝，
    那就是stack.size() < s.length() - i。因为不满足这个条件的话，右边全是右括号也无法匹配。

    如果c为右半边，栈不为空，且栈顶字符正好和c匹配，此时，弹出栈顶元素即可，否则直接返回false。


     */

    public boolean isValid(String s) {
//        assert s != null;
//        if (s.length() % 2 == 1) {
//            return false;
//        }
//        Map<Character, Character> map = new HashMap<>();
//        map.put('(', ')');
//        map.put('{', '}');
//        map.put('[', ']');
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' && stack.size() < s.length() - i) {
//                stack.push(s.charAt(i));
//            } else {
//                if (stack.isEmpty() || map.get(stack.pop()) != s.charAt(i)) {
//                    return false;
//                }
//
//            }
//        }
//        return stack.empty();
        assert s != null;
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c == '(' || c == '[' || c == '{') && stack.size() < s.length() - i) {
                stack.push(c);
                continue;
            }
            if (!stack.empty() && c == map.get(stack.pop())) {
                continue;
            }
            return false;
        }
        return stack.empty();
    }
}
