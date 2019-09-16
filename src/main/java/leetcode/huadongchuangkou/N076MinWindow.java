package leetcode.huadongchuangkou;

public class N076MinWindow {

    /*
    给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。

示例：

输入: S = "ADOBECODEBANC", T = "ABC"
输出: "BANC"

说明：

    如果 S 中不存这样的子串，则返回空字符串 ""。
    如果 S 中存在这样的子串，我们保证它是唯一的答案。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-window-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public String minWindow(String s, String t) {
        if(s == null || s == "" || t == null || t=="" || s.length()<t.length()){
            return "";
        }
        int[] help = new int[256];
        int[] window = new int[256];


        return "";

    }
}
