package leetcode.digui;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）   22
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class GenerateParenthesis22 {


    public static void main(String[] args) {
        new GenerateParenthesis22().generateParenthesis(3);
    }


    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return list;
        }

        process(0, 0, n, "");
        return list;

    }

    private void process(int left, int right, int sum, String tmp) {
        if (2 * sum == tmp.length()) {
            list.add(tmp);
            return;
        }
        //左括号的个数小于n
        if (left < sum) {
            process(left + 1, right, sum, tmp + "(");
        }
        //右括号的个数不能超过左括号的个数
        if (left > right) {
            process(left, right + 1, sum, tmp + ")");

        }
    }
}
