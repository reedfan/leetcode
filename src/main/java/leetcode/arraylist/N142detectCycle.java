package leetcode.arraylist;

public class N142detectCycle {
    public ListNode detectCycle(ListNode head) {

        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while (fast != null &&fast.next != null && fast != slow){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != slow){
            return null;
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;

    }
}
