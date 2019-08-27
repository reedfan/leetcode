package jianzhioffer.gredy;

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

public class Merge56 {


    public static void main(String[] args) {
        int[][] nums = {{1,3},{2,6},{8,10},{15,18}};

        new Merge56().merge(nums);


    }


    public int[][] merge(int[][] intervals) {

        if(intervals == null || intervals.length == 0){
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
