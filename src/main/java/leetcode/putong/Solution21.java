package leetcode.putong;

import java.util.ArrayList;

/**
 * Author 范群松.
 * Date：2018/8/17
 * Time: 19:38
 *
 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,
 他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
 Good Luck!
 输出描述:

 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class Solution21 {
    public  ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();

        int begin = 1;
        int end = 2;
        while (begin != sum/2 +1){
            int tmp = this.total(begin,end);
            if(tmp == sum){
                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                for (int i = begin; i <=sum ; i++) {
                    arrayList.add(i);
                }
                lists.add(arrayList);
                begin++;
                end++;
            }else {
                if(sum > tmp){
                    end++;
                }else {
                    begin++;
                }
            }
        }
        return lists;
    }
    private int total(int s1,int s2){
        return (s1+s2)*(s2-s1+1)/2;
    }

}
