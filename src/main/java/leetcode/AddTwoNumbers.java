package leetcode;

import jianzhioffer.arraylist.ListNode;

/**
 * created by reedfan on 2019/4/25 0025
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int jishu = 0;
        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + jishu;
            res.next = new ListNode((sum) % 10);
            res = res.next;
            jishu = (sum) / 10;
            l1 = l1.next;
            l2 = l2.next;

        }
        while (l1 != null) {
            int sum = l1.val + jishu;
            res.next = new ListNode((sum) % 10);
            res = res.next;
            jishu = (sum) / 10;
            l1 = l1.next;

        }
        while (l2 != null) {
            int sum = l2.val + jishu;
            res.next = new ListNode((sum) % 10);
            res = res.next;
            jishu = (sum) / 10;
            l2 = l2.next;

        }
        if (jishu == 1) {
            res.next = new ListNode(1);
        }
        return tmp.next;
    }
}
