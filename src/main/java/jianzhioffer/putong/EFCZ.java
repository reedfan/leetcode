package jianzhioffer.putong;

/**
 * Author 范群松.
 * Date：2018/8/23
 * Time: 20:22
 */

public class EFCZ {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        int value = binary(a,9);
        System.out.println(value);
    }



    public static int binary(int[] array,int vale){
        int low = 0;
        int high = array.length-1;
        while (low <= high){

            int middle = low +(high - low)/2;
            if(vale == array[middle]){
                return middle;
            }
            if(vale > array[middle]){
                low = middle+1;
            }
            if(vale < array[middle]){
                high = middle-1;
            }
        }
        return -1;
    }


}
