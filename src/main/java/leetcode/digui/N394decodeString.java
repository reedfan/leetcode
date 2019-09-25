package leetcode.digui;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N394decodeString {
    public static void main(String[] args) {
        System.out.println(new N394decodeString().decodeString("2[abc]3[cd]ef"));
    }
    public String decodeString(String s) {

        int times = 0;
        int begin = 0;
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {

            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                times = times*10 + (s.charAt(i) - '0');
                continue;
            }

            if(s.charAt(i) == '['){
                begin = i+1;
                continue;
            }
            if(s.charAt(i) == ']'){
                for (int j = 0; j < times ; j++) {
                    sb.append(s.substring(begin,i));
                }
                times = 0;
                continue;
            }
            if(times == 0){
                sb.append(s.charAt(i));
            }

        }
        return sb.toString();

    }
}
