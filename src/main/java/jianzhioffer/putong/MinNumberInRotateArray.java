package jianzhioffer.putong;

/**
 * created by reedfan on 2019/4/24 0024
 */
public class MinNumberInRotateArray {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        System.out.println(minNumberInRotateArray(a));
    }
    public static int minNumberInRotateArray(int [] array) {
        return erfen(array,0,array.length-1);



    }

    private static int erfen(int[] array,int start,int end){
        int mid = 0;
        while (start<=end){
            mid = start+(end-start)/2;
            if(array[mid]<=array[start]&&array[mid]<=array[end]){
                return array[mid];
            }else {
                if(array[mid]<=array[start]){
                    end = mid-1;
                }else {
                    start = mid+1;
                }
            }
            erfen(array,start,end);
        }
        return array[mid];
    }

}
