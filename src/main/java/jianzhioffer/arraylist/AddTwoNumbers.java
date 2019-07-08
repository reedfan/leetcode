package jianzhioffer.arraylist;

public class AddTwoNumbers {

    /**
     *  You are given two linked lists representing two non-negative numbers.
     *  The digits are stored in reverse order and each of their nodes contain a single digit.
     *  Add the two numbers and return it as a linked list.
     *
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode pHead = new ListNode(0);
        ListNode p = pHead;
        int cur = 0;

        while (l1!=null||l2!=null||cur!=0){
            if(l1!=null){
                cur+=l1.val;
                l1 = l1.next;
            }

            if(l2!=null){
                cur+=l2.val;
                l2 = l2.next;
            }
            pHead.next = new ListNode(cur%10);
            pHead = pHead.next;
            cur = cur/10;

        }
        return p.next;
    }
}
