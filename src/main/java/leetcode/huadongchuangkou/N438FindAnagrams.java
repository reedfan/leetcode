package leetcode.huadongchuangkou;

import java.util.ArrayList;
import java.util.List;

/*
给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

说明：

    字母异位词指字母相同，但排列不同的字符串。
    不考虑答案输出的顺序。

示例 1:

输入:
s: "cbaebabacd" p: "abc"

输出:
[0, 6]

解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。

 示例 2:

输入:
s: "abab" p: "ab"

输出:
[0, 1, 2]

解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N438FindAnagrams {
    public static void main(String[] args) {
        System.out.println(new N438FindAnagrams().findAnagrams("abab", "ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) {
            return list;
        }
        int len = p.length();
        int[] tmp = new int[26];
        int[] windonw = new int[26];

        for (int i = 0; i < len; i++) {
            tmp[p.charAt(i) - 'a']++;        // 记录p串有哪些字符
            windonw[s.charAt(i) - 'a']++;
        }
        int l = 0;
        int r = len;
        while (r < s.length()) {
            if (cmp(windonw, tmp)) {
                list.add(l);
            }
            windonw[s.charAt(r++) - 'a']++;
            windonw[s.charAt(l++) - 'a']--;

        }
        if (cmp(windonw, tmp)) {    //末尾的那个
            list.add(l);
        }
        return list;

    }

    private boolean cmp(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }

        }
        return true;
    }

}
