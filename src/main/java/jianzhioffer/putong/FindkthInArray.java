package jianzhioffer.putong;

public class FindkthInArray {

    public static void main(String[] args) {
        int[] array =  {92, 5, 88, 13, 80,7};
        System.out.println(findKthLargest(array,2));
    }

    public static int findKthLargest(int[] nums,int k){
        return findK(nums,k,0,nums.length-1);
    }

    private static int findK(int[] nums, int k, int start, int end) {

        int low = start;
        int high = end;
        int key = nums[low];
        while (low<high){

            while (low<high&&nums[high]>=key){
                high --;
            }
            nums[low] = nums[high];
            while (low<high &&nums[low]<=key){
                low++;
            }
            nums[high] = nums[low];
        }

        nums[low] = key;
        if(low == k-1){
            return key;
        }else if(low>k-1){
            return findK(nums, k, start, low-1);
        }else {
            return findK(nums, k, low+1, end);
        }

    }

}
