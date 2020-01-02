package leetcode.arraylist;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 *
 *
 * 来源：力扣（LeetCode）  19
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N019RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(4);
        listNode1.next.next.next.next = new ListNode(5);
        System.out.println(new N019RemoveNthFromEnd().removeNthFromEnd1(listNode1,5));
    }



    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        while (n-- > 0){
            fast = fast.next;
        }
        //为了找到要删除的节点的前一个节点，所以此处让fast.next!=null
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        //此时head为倒数第n个节点的前一个节点。
        slow.next = slow.next.next;
        return head.next;
    }


    /*
    本题是一个经典的双指针问题。解题思路如下。
    1、新建一个新链表res，并让res的next指针指向head。并新建fast和slow，他们均指向res。
    2、将fast往后移n个距离。
    3、同时移动fast和slow，直到fast.next == null为止。
    4、此时slow为倒数第n个节点的前一个节点。slow.next = slow.next.next就可以将倒数第n个节点移除。

     */


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode fast = res;
        ListNode slow = res;

        while (n-- > 0){
            fast = fast.next;
        }
        //为了找到要删除的节点的前一个节点，所以此处让fast.next!=null
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        //此时slow为倒数第n个节点的前一个节点。
        slow.next = slow.next.next;
        return res.next;

    }
}
