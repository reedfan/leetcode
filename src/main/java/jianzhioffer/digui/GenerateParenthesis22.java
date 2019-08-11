package jianzhioffer.digui;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 *
 * 来源：力扣（LeetCode）   22
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class GenerateParenthesis22 {
    List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        new GenerateParenthesis22().generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        if(n <= 0){
            return list;
        }

        process(0,0,n,"");
        return list;

    }
    private void process(int left,int right,int sum,String tmp){
        if(sum*2 == tmp.length()){
            list.add(tmp);
        }
        if(left < sum){
            process(left+1,right,sum,tmp+"(");
        }
        if(left > right){
            process(left,right+1,sum,tmp+")");

        }
    }
}
