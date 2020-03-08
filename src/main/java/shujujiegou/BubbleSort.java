package shujujiegou;

import java.util.Arrays;

/**
 * Author 范群松.
 * Date：2018/9/19
 * Time: 14:57
 */

public class BubbleSort {



    /*
    2, 4, 6, 1, 8, 5, 0

                      8
       2           6, 8

     冒泡排序 O(n^2)

     */




    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 1, 8, 5, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] a) {
        int length = a.length;
        for (int i = 0; i < length - 1; i++) {  //控制循环多少轮
            for (int j = 0; j < length - i - 1; j++) {  //具体每一轮的循环排序
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }


}
