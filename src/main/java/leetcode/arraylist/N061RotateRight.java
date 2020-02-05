package leetcode.arraylist;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * <p>
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * <p>
 * 来源：力扣（LeetCode）  61
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N061RotateRight {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
      //  listNode1.next.next = new ListNode(3);
     //   listNode1.next.next.next = new ListNode(4);
     //   listNode1.next.next.next.next = new ListNode(5);
        new N061RotateRight().rotateRight1(listNode1, 2);
    }


    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int len = 0;
        ListNode tmp = head;
        while(tmp != null){
            len++;
            tmp = tmp.next;
        }
        k = k % len;
        ListNode fast = head;
        ListNode slow = head;

        while(k-- > 0){
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode res = slow.next;
        fast.next = head;
        slow.next = null;
        return res;


    }

    public ListNode rotateRight1(ListNode head, int k) {

        if (head == null || k == 0) {
            return head;
        }
        ListNode tmp = head;
        int len = 0;
        //求出链表的长度
        while (tmp != null) {
            tmp = tmp.next;
            len++;
        }
        k = k % len;  //以len为一个周期
        if (k == 0) {
            return head;
        }
        //保存一下头节点
        ListNode node = head;
        //快慢指针
        tmp = head;
        while (k > 0) {
            k--;
            tmp = tmp.next;
        }
        while (tmp.next != null) {
            head = head.next;
            tmp = tmp.next;
        }
        //记录next的位置，也就是返回值的头结点
        ListNode res = head.next;
        //断开连接
        head.next = null;
        //后一段的末尾指向前一段的开头
        tmp.next = node;
        return res;

    }
}
