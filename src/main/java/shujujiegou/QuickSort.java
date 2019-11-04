package shujujiegou;

import java.util.Arrays;

/**
 * Author 范群松.
 * Date：2018/9/19
 * Time: 11:25
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 1, 7, 5, 0, 8, 8, 5};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));


    }


    public static void sort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int start = low;
        int end = high;
        int key = a[low];
        while (start < end) {
            while (end > start && a[end] > key) {
                end--;
            }
            while (end > start && a[start] <= key) {
                start++;
            }
            if (start < end) {
                int tmp = a[start];
                a[start] = a[end];
                a[end] = tmp;
            }
        }
        //调整key的位置
        a[low] = a[start];
        a[start] = key;
        //对左边进行排序
        sort(a, low, start - 1);
        //对右边进行排序
        sort(a, start + 1, high);
    }


}
