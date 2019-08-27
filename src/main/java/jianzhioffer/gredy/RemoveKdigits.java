package jianzhioffer.gredy;

import org.junit.Test;

import java.util.Stack;

public class RemoveKdigits {

    @Test
    public void test(){

        System.out.println(removeKdigits("1432219",3));
        System.out.println(removeKdigits("10200",1));
        System.out.println(removeKdigits("10",2));


    }


    /**
     * leetcode 402
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
