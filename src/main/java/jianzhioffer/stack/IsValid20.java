package jianzhioffer.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class IsValid20 {
    public static void main(String[] args) {
        System.out.println(new IsValid20().isValid("{[]}"));
    }
    public boolean isValid(String s) {
        if(s.length() < 1){
            return true;
        }
        if(s.length()%2!=0){
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if((c == '('||c == '['||c == '{')&&stack.size()<s.length()-i){
                stack.push(c);
                continue;
            }
            if(!stack.empty()&&c == map.get(stack.pop())){
                continue;
            }
            return false;
        }
        return stack.empty();
    }
}
