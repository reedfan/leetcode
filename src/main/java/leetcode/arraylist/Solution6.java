package leetcode.arraylist;

/**
 * Author 范群松.
 * Date：2018/8/19
 * Time: 14:49
 * 输入一个链表，反转链表后，输出新链表的表头
 */
public class Solution6 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);

        reverseList(listNode);

    }


    public static ListNode reverseList(ListNode head) {
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
