package leetcode.digui;

import java.util.ArrayList;
import java.util.Arrays;
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

public class N022GenerateParenthesis {


    public static void main(String[] args) {
       // System.out.println(new N022GenerateParenthesis().generateParenthesis(3));
        String[] s = new String[3];
        s[0] = "a";
        System.out.println(Arrays.toString(s));
    }


    /*
    以n=2模拟一下生成的过程，如下图所示


    当前左右括号都有大于 000 个可以使用的时候，才产生分支；

产生左分支的时候，只看当前是否还有左括号可以使用；

产生右分支的时候，还受到左分支的限制，右边剩余可以使用的括号数量一定得在严格大于左边剩余的数量的时候，才可以产生分支；

在左边和右边剩余的括号数都等于 000 的时候结算。


     */



    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return list;
        }
        process(0, 0, n, "");
        return list;
    }

    private void process(int left, int right, int sum, String tmp) {
        //递归的第一步，确定终止条件，防止死循环。
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
