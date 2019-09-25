package leetcode.arraylist;

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
 * <p>
 * 1.找到起点切断
 */
public class N092ReverseBetween {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(4);
        listNode1.next.next.next.next = new ListNode(5);
        System.out.println(new N092ReverseBetween().reverseBetween(listNode1, 2, 5));
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode res = new ListNode(0);
        res.next = head;
        ListNode node = res;
        //找到需要反转的那一段的上一个节点。
        for (int i = 1; i < m; i++) {
            node = node.next;
        }

        //node.next就是需要反转的这段的起点。
        ListNode nextHead = node.next;
        ListNode next = null;

        ListNode pre = null;

        //反转n到m这一段
        for (int i = 0; i <= n - m; i++) {
            next = nextHead.next;
            nextHead.next = pre;
            pre = nextHead;
            nextHead = next;
        }
        //需要反转的那一段的上一个节点的next节点指向反转后链表的头结点
        node.next = pre;
        //找到反转这段的最后一个节点。
        while (pre.next != null) {
            pre = pre.next;
        }
        pre.next = next;
        return res.next;
    }
}
