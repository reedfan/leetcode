package leetcode.gredy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * <p>
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N057Insert {
    @Test
    public void test() {
        int[][] intervals = {{1, 2},{3, 5},{6, 7},{8, 10},{12, 16}};
        int[] newInterval = {-1, 0};
        insert(intervals, newInterval);


    }


    //如果
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] res = {{newInterval[0], newInterval[1]}};
            return res;
        }

        List<int[]> resList = new ArrayList<>();
        boolean add = false;

        for (int i = 0; i < intervals.length; i++) {
            if(add){
                resList.add(intervals[i]);
                continue;
            }

            if (intervals[i][0] > newInterval[0]) {
                //  intervals[i][0] = newInterval[0];
                if (intervals[i][0] > newInterval[1]) {
                    resList.add(newInterval);
                    resList.add(intervals[i]);
                    add = true;
                } else {
                    if (intervals[i][1] > newInterval[1]) {
                        newInterval[1] = intervals[i][1];
                    }  //else 不需要做
                }
            } else {
                if (intervals[i][1] < newInterval[0]) {
                    resList.add(intervals[i]);
             //       add = true;
                } else {
                    newInterval[0] = intervals[i][0];
                    if (intervals[i][1] > newInterval[1]) {

                        newInterval[1] = intervals[i][1];
                    }

                }
            }

        }
        if (!add) {
            resList.add(newInterval);
        }
        return resList.toArray(new int[resList.size()][2]);

    }
}
