package jianzhioffer;

import org.junit.Test;
//统计一个数字在排序数组中出现的次数。

public class N37GetNumberOfK {


    @Test
    public void test() {
        int[] arr = {1, 2, 3, 3, 3, 3};
        System.out.println(GetNumberOfK(arr, 3));
        // System.out.println(GetNumberOfK(arr, 4));

    }


    public int GetNumberOfK(int[] array, int k) {

        if (array == null || array.length == 0) {
            return 0;
        }
        int len = array.length;
        int firstK = getFirstK(array, 0, len - 1, k);

        int lastK = getLastK(array, 0, len - 1, k);

        if (firstK == -1 || lastK == -1) {
            return 0;
        }
        return lastK - firstK + 1;


    }

    private int getLastK(int[] array, int start, int end, int target) {

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] > target) {
                end = mid - 1;
            } else {
                if (array[mid] < target || (mid < end && array[mid + 1] == target)) {
                    start = mid + 1;
                } else {
                    return mid;
                }

            }
        }
        return -1;
    }

    private int getFirstK(int[] array, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (array[mid] < target) {
            return getFirstK(array, start + 1, end, target);
        } else {
            if (array[mid] < target || (mid > 0 && array[mid - 1] == target)) {

                return getFirstK(array, start, mid - 1, target);
            } else {
                return mid;
            }
        }
    }


}
