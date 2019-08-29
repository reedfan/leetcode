package leetcode.shuangzhizhen;

import java.util.List;

/**
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
 * 如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * <p>
 * 输出:
 * "apple"
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * s = "abpcplea", d = ["a","b","c"]
 * <p>
 * 输出:
 * "a"
 * <p>
 * <p>
 * 来源：力扣（LeetCode）524
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLongestWord524 {
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String str : d) {
            if(str.length()<result.length()||(str.length() == result.length() && str.compareTo(result)>0)){
                continue;
            }
            if(isSub(s,str)){
                result = str;
            }
        }

        return result;
    }
    private boolean isSub(String source,String target){
        int i1 = 0;
        int i2 = 0;
        for(;i1<source.length()&&i2<target.length();i1++){
            if(source.charAt(i1) == target.charAt(i2)){
                i2++;
            }
        }
        return i2 == target.length();
    }
}
