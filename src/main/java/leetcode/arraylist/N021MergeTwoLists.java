package leetcode.arraylist;

/**
 * 合并两个链表
 */

/*
新建一个链表res用来存储最后的结果
本题的思路还是很清晰的，因为l1和l2都是有序的。
因此每次比较l1和l2的头节点的大小。将较小的加入res。

 */
public class N021MergeTwoLists {
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
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
        if (l1 != null) {
            tmp.next = l1;

        }

        if (l2 != null) {
            tmp.next = l2;

        }

        return res.next;
    }

    //递归写法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if(l1.val<l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
