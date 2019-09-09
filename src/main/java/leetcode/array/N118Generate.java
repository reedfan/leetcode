package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 来源：力扣（LeetCode）  118
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N118Generate {
    public static void main(String[] args) {
        new N118Generate().generate(5);
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if(numRows <=0){
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        lists.add(list);
        if(numRows == 1){
            return lists;
        }
        for (int i = 2; i <= numRows ; i++) {
            List<Integer>newList = new ArrayList<>();
            newList.add(1);
            for (int j = 1; j < i-1 ; j++) {
                newList.add(list.get(j-1)+list.get(j));
            }
            newList.add(1);
            lists.add(new ArrayList<>(newList));
            list = newList;
        }

        return lists;

    }
}
