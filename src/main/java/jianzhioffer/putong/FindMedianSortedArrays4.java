package jianzhioffer.putong;

public class FindMedianSortedArrays4 {

    /**
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     * <p>
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * <p>
     * 你可以假设 nums1 和 nums2 不会同时为空。
     * <p>
     * 示例 1:
     * <p>
     * nums1 = [1, 3]
     * nums2 = [2]
     * <p>
     * 则中位数是 2.0
     * <p>
     * 示例 2:
     * <p>
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * <p>
     * 则中位数是 (2 + 3)/2 = 2.5
     * <p>
     * 来源：力扣（LeetCode）   46
     * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] nums1 = {2,3};
        int[] nums2 = {};
        System.out.println(new FindMedianSortedArrays4().findMedianSortedArrays(nums1,nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        return (find(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len1 + len2 + 1) / 2) + find(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len1 + len2) / 2 + 1)) * 0.5;
    }

    private int find(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int cnt) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //确保nums1是短的
        if (len1 > len2) {
            return find(nums2, start2, end2, nums1, start1, end1, cnt);
        }
        //如果len1已经为空，直接从nums2找
        if (len1 == 0) {
            return nums2[start2 + cnt - 1];
        }
        if (cnt == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int pos1 = start1 + Math.min(cnt / 2, len1) - 1;
        int pos2 = start2 + cnt / 2 - 1;
        if (nums1[pos1] > nums2[pos2]) {
            return find(nums1, start1, end1, nums2, pos2 + 1, end2, cnt - cnt / 2);
        } else {
            return find(nums1, pos1 + 1, end1, nums2, start2, end2, cnt - Math.min(cnt / 2, len1));
        }
    }

































   /* public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left) + getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int cnt) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2){
            return getKth(nums2, start2, end2, nums1, start1, end1, cnt);
        }
        if (len1 == 0){
            return nums2[start2 + cnt - 1];
        }

        if (cnt == 1){
            return Math.min(nums1[start1], nums2[start2]);
        }

        int i = start1 + Math.min(len1, cnt / 2) - 1;
        int j = start2 + Math.min(len2, cnt / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, cnt - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, cnt - (i - start1 + 1));
        }
    }*/

}
