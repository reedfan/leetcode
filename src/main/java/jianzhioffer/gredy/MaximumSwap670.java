package jianzhioffer.gredy;

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
public class MaximumSwap670 {
    public static void main(String[] args) {
        int num = new MaximumSwap670().maximumSwap(98368);
        System.out.println(num);
    }


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
        while (i >= 0) {
            arr[i--] = num % 10;
            num /= 10;
        }
        int[] help = new int[cnt];
        int max = arr[cnt - 1];
        help[cnt - 1] = cnt - 1;
        for (int j = cnt - 2; j >= 0; j--) {
            if (arr[j] <= max) {
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
