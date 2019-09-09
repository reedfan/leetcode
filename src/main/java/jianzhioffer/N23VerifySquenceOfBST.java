package jianzhioffer;

/**
 * Author 范群松.
 * Date：2018/8/18
 * Time: 19:38
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */

public class N23VerifySquenceOfBST {
    public static void main(String[] args) {
        int[] array = {4, 6, 7, 5};
        System.out.println(new N23VerifySquenceOfBST().VerifySquenceOfBST(array));
    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return isBST(sequence, 0, sequence.length - 1);
    }

    private boolean isBST(int[] arr, int start, int end) {
        if (start >= end) {
            return true;
        }

        int i = start;
        for (; i < end; i++) {
            if (arr[i] > arr[end]) {
                break;
            }
        }
        for (int j = i; j < end; j++) {
            if (arr[j] < arr[end]) {
                return false;
            }
        }
        return isBST(arr, start, i - 1) && isBST(arr, i, end - 1);
    }
}
