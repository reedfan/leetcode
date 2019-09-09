package jianzhioffer;

import leetcode.arraylist.ListNode;

public class N16Merge {
    public ListNode merge1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode tmp = new ListNode(0);
        ListNode res = tmp;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;

            }
            tmp = tmp.next;
        }

        while (l1 != null) {
            tmp.next = l1;
            l1 = l1.next;
            tmp = tmp.next;
        }

        while (l2 != null) {
            tmp.next = l2;
            l2 = l2.next;
            tmp = tmp.next;
        }
        return res.next;
    }

    //递归写法
    public ListNode Merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if(l1.val<l2.val){
            l1.next = Merge(l1.next,l2);
            return l1;
        }else {
            l2.next = Merge(l1,l2.next);
            return l2;
        }
    }
}
