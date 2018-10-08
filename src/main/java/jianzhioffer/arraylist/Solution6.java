package jianzhioffer.arraylist;

/**
 * Author 范群松.
 * Date：2018/8/19
 * Time: 14:49
 * 输入一个链表，反转链表后，输出新链表的表头
 */
public class Solution6 {
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null){
            //将next节点信息保存
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
