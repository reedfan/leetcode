package jianzhioffer;

import leetcode.arraylist.ListNode;

/**
 * Author 范群松.
 * Date：2018/8/17
 * Time: 17:01
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Solution1 {
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode res = new ListNode(0);
        res.next = pHead;
        ListNode pre = res;
        ListNode cur = pHead;
        while (cur != null && cur.next != null){
            if(cur.val != cur.next.val){
                pre = cur;
            }else {
                while (cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                    pre.next = cur.next;
                }
            }
            cur = cur.next;
        }
        return res.next;
    }
}
