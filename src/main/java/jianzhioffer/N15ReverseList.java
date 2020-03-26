package jianzhioffer;

import leetcode.arraylist.ListNode;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 *
 */

/*
     head
      1->  2   3  4  5

 */

public class N15ReverseList {
    public ListNode ReverseList1(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            //1.  保存next
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;

        }
        return pre;

    }


    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }
}
