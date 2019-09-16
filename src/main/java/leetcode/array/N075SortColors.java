package leetcode.array;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N075SortColors {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new N075SortColors().sortColors(nums);
    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] tmp = new int[3];
        for (int num : nums) {
            tmp[num]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tmp[0]-- > 0) {
                nums[i] = 0;
            } else {
                if (tmp[1]-- > 0) {
                    nums[i] = 1;
                } else {
                    nums[i] = 2;
                }
            }

        }
    }
}
