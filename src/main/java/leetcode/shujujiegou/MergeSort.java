package leetcode.shujujiegou;

/**
 * Author 范群松.
 * Date：2018/9/24
 * Time: 16:00
 */

public class MergeSort {

    public static void main(String args[]){
        int[] test = {9,2,6,3,5,7,10,11,12};
        merSort(test,0,test.length-1);
        for(int i=0; i<test.length;i++){
            System.out.print(test[i] + " ");
        }
    }

    public static void merSort(int[] arr,int left,int right){
        if(left<right){
            int mid = left+(right-left)/2;
            merSort(arr,left,mid);   //左边归并排序，使得左子序列有序
            merSort(arr,mid+1,right); //右边归并排序，使得右子序列有序
            merge(arr,left,mid,right);   //合并两个子序列
        }
    }

    private static void merge(int[] arr,int left,int mid,int right){
        int[] tmp = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int k = 0;
        while (i<=mid && j<= right){
            if(arr[i]<arr[j]){
                tmp[k++] = arr[i++];
            }else {
                tmp[k++] = arr[j++];
            }
        }
        while (i<=mid){
            tmp[k++] = arr[i++];
        }
        while (j <= right){
            tmp[k++] = arr[j++];
        }
        //将tmp中的元素全部拷贝到原数组中
        for (int k2 = 0; k2 < tmp.length; k2++) {
            arr[k2 + left] = tmp[k2];
        }
    }
}
