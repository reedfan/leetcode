package jianzhioffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Author 范群松.
 * Date：2018/8/17
 * Time: 19:38
 * <p>
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,
 * 他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
 * Good Luck!
 * 输出描述:
 * <p>
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class N41FindContinuousSequence {
    @Test
    public void test(){
        FindContinuousSequence(9);
    }
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();

        int start = 1;
        int end = 2;
        int tmpSum = 3;
        while (start <= sum / 2) {
            if (tmpSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                lists.add(list);
                end++;
                tmpSum += (end - start);
                start++;
            } else {
                if (tmpSum < sum) {
                    end++;
                    tmpSum += end;
                } else {
                    tmpSum -= start;
                    start++;

                }
            }
        }


        return lists;
    }


}
