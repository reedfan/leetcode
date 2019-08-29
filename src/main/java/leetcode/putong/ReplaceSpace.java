package leetcode.putong;

/**
 * https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */

public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {

        int p1 = str.length()-1;

        for (int i = 0; i <= p1 ; i++) {
            if(str.charAt(i) == ' '){
                str.append("  ");
            }
        }
        int p2 = str.length()-1;

        for (int i = p1; i >= 0; i--) {
            char c = str.charAt(p1--);
            if(c == ' '){
                str.setCharAt(p2--,'0');
                str.setCharAt(p2--,'2');
                str.setCharAt(p2--,'%');
            }else {
                str.setCharAt(p2--,c);
            }
        }

        return str.toString();
    }
}
