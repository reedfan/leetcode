package leetcode;

import jianzhioffer.arraylist.ListNode;

/**
 * created by reedfan on 2019/4/25 0025
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode listNode = new ListNode(-1);
        ListNode res = listNode;
        int tmp = 0;
        int sum = 0;
        while (l1!=null && l2!=null){
            sum = l1.val+l2.val+tmp;
            if(sum>9){
                tmp = 1;
                ListNode next = new ListNode(sum-10);
                listNode.next = next;
                listNode = listNode.next;
                sum = 0;
                l1 = l1.next;
                l2 = l2.next;
            }else {
                ListNode next = new ListNode(sum);
                listNode.next = next;
                sum = 0;
                l1 = l1.next;
                l2 = l2.next;
                listNode = listNode.next;
            }
        }
        while (l1!=null){
            sum = l1.val+tmp;
            if(sum>9){
                tmp = 1;
                ListNode next = new ListNode(sum-10);
                listNode.next = next;
                listNode = listNode.next;
                sum = 0;
                l1 = l1.next;
            }else {
                ListNode next = new ListNode(sum);
                listNode.next = next;
                listNode = listNode.next;
                sum = 0;
                l1 = l1.next;
            }
        }

        while (l2!=null){
            sum = l2.val+tmp;
            if(sum>9){
                tmp = 1;
                ListNode next = new ListNode(sum-10);
                listNode.next = next;
                listNode = listNode.next;
                sum = 0;
                l2 = l2.next;
            }else {
                ListNode next = new ListNode(sum);
                listNode.next = next;
                listNode = listNode.next;
                sum = 0;
                l2 = l2.next;
            }
        }
        if(tmp != 0){
            listNode.next = new ListNode(1);
        }

        return res.next;

    }
}
