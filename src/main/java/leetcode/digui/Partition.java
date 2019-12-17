package leetcode.digui;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * <p>
 * 来源：力扣（LeetCode）   131
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Partition {

    List<List<String>> lists = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return lists;
        }
        List<String> list = new ArrayList<>();
        process(list,0,s);
        return lists;

    }

    private void process(List<String> list,int index,String s){
        if(s.length() == index){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = index+1; i <= s.length() ; i++) {
            String str = s.substring(index,i);
            if(isPartition(str)){
                list.add(str);
                process(list,i,s);
                list.remove(list.size()-1);

            }

        }

    }

    private boolean isPartition(String s){
        for (int i = 0; i < s.length()/2 ; i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
