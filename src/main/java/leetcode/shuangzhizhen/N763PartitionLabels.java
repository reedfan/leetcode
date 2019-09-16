package leetcode.shuangzhizhen;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 * 示例 1:
 *
 * 输入: S = "ababcbacadefegdehijhklij"
 * 输出: [9,7,8]
 * 解释:
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N763PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        if(S.length() == 1){
            list.add(1);
            return list;

        }

        int[] lastindex = new int[26];

        for (int i = 0; i < S.length() ; i++) {
            lastindex[S.charAt(i)-'a'] = i;
        }

        int index = 0;
        int maxPos = lastindex[S.charAt(0)-'a'];


        for (int i = 1; i < S.length() ; i++) {
            if(maxPos >= lastindex[S.charAt(i)-'a']){

            }else {

            }
        }

        return  null;


    }

}
