package leetcode.shujujiegou;

/**
 * Author 范群松.
 * Date：2018/9/19
 * Time: 15:03
 */

public class EFCZ {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7,8,9};
        int value=binary(a,5);
        System.out.println(value);
    }



    private static int binary(int[] a,int target){
        int left = 0;
        int right = a.length-1;
        int mid = -1;
        while (left<right){
            mid = left+(right-left)/2;
            if(target == a[mid]){
                return mid;
            }else {
                if(target>a[mid]){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
