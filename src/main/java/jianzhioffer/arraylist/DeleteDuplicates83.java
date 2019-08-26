package jianzhioffer.arraylist;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
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
        listNode1.next.next.next.next = new ListNode(5);
        System.out.println(new DeleteDuplicates83().deleteDuplicates(listNode1));
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode res = head;
        int tmp = head.val;
        head = head.next;
        while (head != null){
            if(tmp == head.val){
                head.next = head.next.next;
            }else {

                tmp = head.val;
            }
            head = head.next;
        }
        return res;

    }
}
