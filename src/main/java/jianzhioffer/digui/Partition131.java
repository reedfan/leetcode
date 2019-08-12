package jianzhioffer.digui;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * 来源：力扣（LeetCode）   131
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Partition131 {
    public static void main(String[] args) {
        new Partition131().partition("aad");
    }
    List<List<String>> lists = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0){
            return lists;
        }
        List<String> list = new ArrayList<>();
        process(s,list,0);
        return lists;
    }

    private void process(String s, List<String> list, int index){
        if(index == s.length()){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = index+1; i <=s.length() ; i++) {
            String str = s.substring(index,i);
            if(isParlindrome(str)){
                list.add(str);
                process(s,list,i);
                //list相当于引用传递，所以需要回退
                list.remove(list.size()-1);
            }
        }
    }
    private boolean isParlindrome(String s){   //判断是否为回文串
        if(s==""||s.length()==0){
            return false;
        }
        int len=s.length();
        for(int i=0;i<=len/2;++i){
            if(s.charAt(i)!=s.charAt(len-1-i)){
                return false;
            }
        }
        return true;
    }

}
