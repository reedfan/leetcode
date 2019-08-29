package leetcode.arraylist;


/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * <p>
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * <p>
 * 来源：力扣（LeetCode）82
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteDuplicates82 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(3);
    //    listNode1.next.next.next.next = new ListNode(5);
        System.out.println(new DeleteDuplicates82().deleteDuplicates(listNode1));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = new ListNode(-1);
        ListNode node = res;
        while (head != null) {
            boolean dup = false;
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
                dup = true;
            }
            if (!dup) {
                res.next = head;
                res = res.next;

            }
            head = head.next;
        }
        res.next = null;  //防止res后面还有重复的节点
        return node.next;
    }
}
