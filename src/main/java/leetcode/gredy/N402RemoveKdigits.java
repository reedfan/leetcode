package leetcode.gredy;

import org.junit.Test;

import java.util.Stack;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 *     num 的长度小于 10002 且 ≥ k。
 *     num 不会包含任何前导零。
 *
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 *
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 *
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N402RemoveKdigits {

    @Test
    public void test(){

        System.out.println(removeKdigits("1432219",3));
        System.out.println(removeKdigits("10200",1));
        System.out.println(removeKdigits("10",2));


    }


    /**
     * jianzhioffer 402
     * 整个过程分为两部分，第一部分，从前往后遍历，删除前面比后面大的数。
     * 第二部假设，k仍然大于0，就后面的数删除
     *
     */

    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0) {
            return "0";
        }
        Stack<Integer> stack = new Stack<>();
        int len = num.length();
        for (int i = 0; i < len; i++) {
            int number = num.charAt(i) - '0';
            while (!stack.isEmpty() && stack.peek() > number && k > 0) {
                stack.pop();
                k--;
            }
            //如果这个数是0的话，前面有数字就加进去，前别有数字就不加进去
            if(number != 0 || !stack.isEmpty()){
                stack.push(number);
            }
        }
        //如果栈不为空，且仍可以删除数字
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
        if (stack.isEmpty()) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
}
