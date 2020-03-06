package leetcode.gredy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）   56
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N056Merge {


    public static void main(String[] args) {
        int[][] nums = {{1,3},{2,6},{8,10},{15,18}};

        new N056Merge().merge(nums);


    }

    /*

    首先对待合并的数组按照第一个数字大小进行排序，排序以后数组的第一个数字.
    假如待排序数组为{{8,10},{1,6},{2,3},{15,18}}，按照第一个数字大小排序以后变为{{1,6},{2,3},{8,10},{15,18}}
    然后从头到尾两两合并。合并的时候分两种情况，假如待合并的两个数组记为[A1,A2]和[B1,B2]。现在已知条件为A1<=B1,
    1.1假如A2>=B1,则两个数组存在交集，那么将两个数组合并，若A2>B2,合并完以后为[A1,A2].若A2<=B2,合并完以后为[A1,B2]。
    1.2假如A2<B1,则两个数组不存在交集，直接将[A1,A2]加入结果。下次比较[B1,B2]和[C1,C2]。


     */

    public int[][] merge(int[][] intervals) {

        if(intervals == null || intervals.length < 2){
            return intervals;
        }

        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length ; i++) {
            if(intervals[i][0] > end){
                list.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }else {
                end = end > intervals[i][1]? end : intervals[i][1];
            }

        }
        list.add(new int[]{start,end});
        return list.toArray(new int[list.size()][2]);

    }
}
