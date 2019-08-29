package jianzhioffer.arraylist;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseBetween92 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(4);
        listNode1.next.next.next.next = new ListNode(5);
        System.out.println(new ReverseBetween92().reverseBetween(listNode1,2,4));
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode res = new ListNode(0);
        res.next = head;
        ListNode node = res;
        for (int i = 1; i < m ; i++) {
            node = node.next;
        }
        ListNode tmp = node;
        ListNode pre = null;
        ListNode next = null;
        for (int i = 0; i < n-m; i++) {
            next = tmp.next;
            tmp.next = pre;
            pre = tmp;
            tmp = next;
        }

        return res.next;
    }
}
