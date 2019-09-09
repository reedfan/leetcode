package jianzhioffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class N06MinNumberInRotateArray {
    public static void main(String[] args) {
        int[] a = {3,4,5,1,2};
        System.out.println(new N06MinNumberInRotateArray().minNumberInRotateArray(a));
    }

    public int minNumberInRotateArray(int[] array){
        if (array.length == 0) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if(array[mid] == array[end]){
                end --;
                continue;
            }
            //4 5 1 2 3 或者 5 1 2 3 4这种，后半部分有序，说明一定在前半部分。
            if(array[mid] < array[end]){
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return array[mid];

    }

    //这种是错的
    public int minNumberInRotateArray1(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (array[mid] == array[start]) {
                start++;
                continue;
            }
            //后半部分有序，说明最小数在前半部分,但是不能是end = mid-1，因为这样会漏掉array[mid]这个数
            if (array[mid] < array[start]) {
                end = mid ;
            } else {
                start = mid + 1;
            }
        }
        return array[mid];


    }




    /*private static int erfen(int[] array, int start, int end) {
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (array[mid] <= array[start] && array[mid] <= array[end]) {
                return array[mid];
            } else {
                if (array[mid] <= array[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            erfen(array, start, end);
        }
        return array[mid];
    }*/

}
