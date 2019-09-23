package leetcode.array;

/**
 * 时间复杂度为O(n)
 * 复杂度：平均情况下，遍历一次数组找到哨兵是n，下一次就是n/2，最后到1，中间最多需要k次（k=lg2n）
 * 等比数列求和：n+n/2+n/4+n/8+…+1 = 2n
 */

public class FindkthInArray {

    public static void main(String[] args) {
        int[] array =  {3,3,3,3,4,3,3,3,3};
        System.out.println(findKthLargest(array,1));
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
