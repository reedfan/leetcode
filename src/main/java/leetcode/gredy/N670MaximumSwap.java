package leetcode.gredy;

/**
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * <p>
 * 示例 1 :
 * <p>
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * <p>
 * 示例 2 :
 * <p>
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * <p>
 * 注意:
 * <p>
 * 给定数字的范围是 [0, 10^8]
 * <p>
 * 来源：力扣（LeetCode）  670
 * 链接：https://leetcode-cn.com/problems/maximum-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N670MaximumSwap {
    public static void main(String[] args) {
        int num = new N670MaximumSwap().maximumSwap(98368);
        System.out.println(num);
    }

    /**
     * 这题我们的想法肯定是，尽量交换前面的大数位，并且和它交换的数还得是在它后面大于它的最大数
     *
     *     倒序使用数组存储下来每个位置，在它及它以后的最大数的索引
     *     然后再正序从一个数开始遍历，如果它及它以后的最大数不是它本身，那么这个数就是我们需要交换的。
     */

    public int maximumSwap(int num) {
        int tmp = num;
        int cnt = 0;
        while (tmp > 0) {
            tmp /= 10;
            cnt++;
        }
        if (cnt == 0) {
            return num;
        }
        int[] arr = new int[cnt];
        int i = cnt - 1;
        //记录下每一位
        while (i >= 0) {
            arr[i--] = num % 10;
            num /= 10;
        }
        int[] help = new int[cnt];
        //记录这个位置以及他之后的最大值
        int max = arr[cnt - 1];
        //记录这个位置以及他之后的最大值的索引
        help[cnt - 1] = cnt - 1;
        for (int j = cnt - 2; j >= 0; j--) {
            if (arr[j] <= max) {
                //最大值不变，最大值的索引同他后面一个数
                help[j] = help[j + 1];
            } else {
                help[j] = j;
                max = arr[j];
            }

        }

        for (int j = 0; j < cnt - 1; j++) {
            if (help[j] != j && arr[help[j]] != arr[j]) {
                swap(arr, j, help[j]);
                break;
            }

        }
        int res = 0;
        for (int j = 0; j < cnt; j++) {
            res = res * 10 + arr[j];

        }

        return res;

    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
