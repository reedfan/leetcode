package leetcode.arraylist;

/*
在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

示例 1:

输入: 4->2->1->3
输出: 1->2->3->4

示例 2:

输入: -1->5->3->4->0
输出: -1->0->3->4->5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N148sortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tmp.next = left;
                left = left.next;
            } else {
                tmp.next = right;
                right = right.next;
            }
            tmp = tmp.next;
        }
        tmp.next = left == null ? right : left;
        return res.next;
    }
}
