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
public class N082DeleteDuplicates {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(3);
        listNode1.next.next.next.next = new ListNode(5);
        System.out.println(new N082DeleteDuplicates().deleteDuplicates1(listNode1));
    }

    //递归写法
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        if (head.next != null && head.val == head.next.val) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            //去掉所有重复的数字，然后进行递归
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
    //非递归写法
    /*
    新建一个链表res表示最后返回的链表。
    用一个bool型变量dup表示是否有重复的节点。如果一个节点的值与其next节点的值相等。表示是重复节点，将dup设置为true。往后顺移，直到不相等为止。
    将当前节点加入最后返回的链表res的时候，需要判断一下dup是否为true。如果为true的话，表示当前节点是重复的。举个例子：
    2->2->3。 刚开始第一个2和第二个2相等。顺移一位，dup设为true。此时2和3不相等。但是这个2其实不能加到最后的返回结果中。
    因此，需要判断一下dup是否为true。如果不为true，才能加到最后的返回结果中。

     */
    public ListNode deleteDuplicates1(ListNode head) {
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
