package leetcode.stack;

import java.util.Stack;

public class EvalRPN {

    /**
     *  Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     *
     * Valid operators are+,-,*,/. Each operand may be an integer or another expression.
     *
     * Some examples:
     *
     *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
     *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     */

    public static void main(String[] args) {
        String[] strings = {"0","3","/"};
        evalRPN(strings);
    }

    public static int evalRPN(String[] tokens) {
        if(tokens == null ||tokens.length<1){
            return 0;
        }
        Integer num1,num2;
        Stack<Integer> stack = new Stack<>();

        for (String str:tokens){

            if(str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")){
                num2 = stack.pop();
                num1 = stack.pop();

                if(str.equals("+")){
                    stack.push(num1+num2);
                }
                if(str.equals("-")){
                    stack.push(num1-num2);
                }
                if(str.equals("*")){
                    stack.push(num1*num2);
                }
                if(str.equals("/")){
                    stack.push(num1/num2);
                }
            }else {
                stack.push(Integer.parseInt(str));
            }
        }


        return stack.peek();

    }

}
