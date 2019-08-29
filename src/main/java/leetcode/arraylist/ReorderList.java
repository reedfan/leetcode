package leetcode.arraylist;

public class ReorderList {
    /**
     *  Given a singly linked list L: L 0→L 1→…→L n-1→L n,
     * reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
     *
     * You must do this in-place without altering the nodes' values.
     *
     * For example,
     * Given{1,2,3,4}, reorder it to{1,4,2,3}.
     */

    public void reorderList(ListNode head) {
        if(head == null || head.next ==null){
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode node = reverse(next);

        while (head!=null||node!=null){

        }



    }

    private static ListNode reverse(ListNode listNode){
        ListNode pre = null;
        ListNode cur = listNode;
        ListNode next = null;

        while (cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return cur;
    }
}
