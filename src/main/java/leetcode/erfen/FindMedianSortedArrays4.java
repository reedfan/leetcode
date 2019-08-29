package leetcode.erfen;

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

    /** 题目要求时间复杂度为O(log(m + n))。基本可以确定本题应该用二分查找，对于数组arr的中位数，如果数组长度为len，
     len为奇数，则中位数为第（len+1）/2 位，如果len为偶数，我们需要知道第 len/2和 len/2+1 个数。


     我们需要找出两个排序数组的第k个数的问题。比较两个数组的第k/2位，然后将第k/2位较小的数组中的前k/2位删除。
     然后继续此过程

     举个例子
     A={1,3,4,9} lenA=4  B={1,2,3,4,5,6,7,8,9} lenB=9  lenA+lenB=13 ，因此找第7个数

     7/2 = 3   A的第3个数为4，B的第3个数为3，  因此接下来A={1,3,4,9}   B={4,5,6,7,8,9}  找第7-3=4个数，
     4/2=2 A的第2个数为3，B的第3个数为6，  因此接下来A={4,9}   B={4,5,6,7,8,9}   找第4-2=2个数，
     2/2=1 A的第1个数为4，B的第1个数为4，  因此接下来A={4}   B={5,6,7,8,9}   找第2-1=1个数，
     现在找第1个数，比较A[0]和B[0]谁更小即可，因此最后结果为4


     */

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
        //找第1个数，比较nums1[0]和nums2[0]谁更小即可
        if (cnt == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        //因为nums1比较短，因此取位置时要考虑实际长度
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
