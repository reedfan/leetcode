package jianzhioffer.erfen;


/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 *
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {


        double res = 0;

        int l1 = nums1.length;
        int l2 = nums2.length;
        if(l1 > l2){    //保证数组一一定最短
            return findMedianSortedArrays(nums2,nums1);
        }
        int lMax1, lMax2, rMin1, rMin2, c1, c2, lo = 0, hi = 2*l1;

        while (lo <= hi){
            // 二分
            c1 = (lo + hi)/2;   // c1是二分的结果
            c2 = l1 + l2 - c1;
            lMax1 = (c1 == 0)? Integer.MIN_VALUE:nums1[(c1-1)/2];
       //     rMin1 = (c1 == 2*l1)?Integer.MAX_VALUE





        }


        return res;





    }

    //假设nums1一定是比较长的那个
    private int findkthArrays(int[] nums1, int start1, int[] nums2, int start2, int k) {

        while (k>1){
            int mid = k/2;


            if(nums2.length - start2 >= mid){
                // nums1的小，删除nums1的
                if(nums1[k-1+start1] < nums2[k-1+start2]){
                    if(nums1.length -k/2 - start1 > nums2.length - start2 ){

                    }else {
                        findkthArrays(nums2, start2, nums1,start1+k/2,k-k/2);

                    }

                }else {
                    findkthArrays(nums1,start1,nums2, start2+k/2,k-k/2);
                }

            }else {


            }

        }







        return 0;
    }
}
