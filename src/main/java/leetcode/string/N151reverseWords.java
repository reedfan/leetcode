package leetcode.string;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * <p>
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * <p>
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N151reverseWords {
    public static void main(String[] args) {
        String str = new N151reverseWords().reverseWords("a");
        System.out.println(str);
    }

    public String reverseWords(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        StringBuffer res = new StringBuffer();
        //用来标记是不是第一个单词，是第一个单词，前面就不加" "；
        boolean first = true;
        //统计这个单词有几个字符
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                cnt++;
                continue;
            }
            if (cnt != 0) {

                if (first) {
                    first = false;
                } else {
                    res.append(" ");
                }
                res.append(s.substring(i + 1, i + 1 + cnt));
                cnt = 0;
            }

        }
        if (cnt != 0) {
            if(!first){
                res.append(" ");
            }

            res.append(s.substring(0, cnt));
        }

        return res.toString();

    }
}
