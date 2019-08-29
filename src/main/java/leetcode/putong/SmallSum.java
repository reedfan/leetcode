package leetcode.putong;

public class SmallSum {

    private static int smallSum(int[] num){
        if(num == null || num.length<2){
            return 0;
        }

        return mergeSort(num,0,num.length-1);

    }

    private static int mergeSort(int[] num, int L, int R) {

        if(L == R){
            return 0;
        }

        int mid = L+(R-L)>>1;

        return mergeSort(num,L,mid)+mergeSort(num,mid+1,R)+merge(num,L,mid,R);




    }

    private static int merge(int[] num, int l, int mid, int r) {


        return 0;

    }





}
