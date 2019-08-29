package leetcode.arraylist;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * <p>
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * <p>
 * 来源：力扣（LeetCode）83
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteDuplicates83 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(3);
        listNode1.next.next.next.next = new ListNode(3);
        System.out.println(new DeleteDuplicates83().deleteDuplicates(listNode1));
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = head;
        while (head != null && head.next != null) {
            //相等的话就删除下一个节点
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                //不相等的话向前移动一位
                head = head.next;
            }
        }
        return res;
    }


    //递归写法
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            //如果值和下一个值相同，删掉这个节点，即直接返回下一个节点
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;

    }
}
