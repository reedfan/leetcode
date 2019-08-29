package leetcode.arraylist;

/**
 *

 Sort a linked list in O(n log n) time using constant space complexity.
 */

public class LianBiaoPaiXu {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(5);
        listNode.next = new ListNode(6);
        listNode.next.next = new ListNode(4);
        sortList(listNode);

    }
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = findMid(head);
        ListNode next = mid.next;
        mid.next = null;

        ListNode node = merge(sortList(head),sortList(next));
        return node;
    }

    private static ListNode findMid(ListNode head){
        if(head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, quick = head;
        while(quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    private static ListNode merge(ListNode l1,ListNode l2){
        ListNode listNode = new ListNode(-1);
        ListNode res = listNode;

        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                listNode.next = l1;
                l1 = l1.next;
            }else {
                listNode.next = l2;
                l2 = l2.next;
            }
            listNode = listNode.next;
        }
        listNode.next = l1==null?l2:l1;
        return res.next;

    }
}
