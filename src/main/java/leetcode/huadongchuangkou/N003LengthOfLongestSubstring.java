package leetcode.huadongchuangkou;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode） 3
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N003LengthOfLongestSubstring {


    public static void main(String[] args) {
        System.out.println(new N003LengthOfLongestSubstring().lengthOfLongestSubstring("abcd"));

    }

    /*
    本题是一个典型的滑动窗口类题目，要求滑动窗口里没有重复的字符。
    那么怎么滑动呢？
    首先，我们需要用一个数据结构来记录窗口中的字符（可以是数组或者map，这个具体代码的时候再说）。
    何时窗口右移？如果要处理的那个字符在滑动窗口里没有，那么窗口就可以右移了。因为此时还是能保证窗口里没有重复的字符。
    窗口何时左移？如果要处理的那个字符在滑动窗口里有，那么窗口就需要左移。
    左移什么时候结束？当左移到滑动窗口里面已经没有要处理的那个字符就可以结束了。
    什么时候无重复子串最长？窗口最大的时候最长。

    因此，回到刚才用来记录的数据结构那个问题，如果用数组怎么做？用数组的话，可以申请一个大小为256的数组，
    当某个字符被加进滑动窗口，其对应位置的数就加1，当某个字符被移除滑动窗口，其对应位置的数就减1.
    什么时候代表滑动窗口里面有这个字符？当其对应位置的值不为0就代表滑动窗口里面有这个字符了。

    如果用map怎么做？可以用Map<Character, Integer> map来存储窗口中的值，key表示存储的字符，value表示存储的字符在已经遍历到的最右边的位置。
    用l表示滑动窗口的左端。
    当map里包含要处理的字符的时候，此时窗口的最左边应该是l和map.get(c) + 1的较大者。当map里不包含要处理的字符的时候，此时窗口的最左边任然为l。
    最后将待处理字符加入map并计算窗口大小。

     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] tmp = new int[256];
        int maxLen = 0;
        int l = 0;
        int r = 0;

        while (l < s.length()) {
            if (r < s.length() && tmp[s.charAt(r)] == 0) {
                tmp[s.charAt(r++)] = 1;
            } else {
                maxLen = maxLen > (r - l) ? maxLen : (r - l);
                tmp[s.charAt(l++)] = 0;
            }
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 0;
        int l = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                l = l > (map.get(c) + 1) ? l : (map.get(c) + 1);
            }
            map.put(c, i);
            maxLen = maxLen > (i - l + 1) ? maxLen : (i - l + 1);
        }
        return maxLen;
    }
}
