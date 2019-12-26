package leetcode.arraylist;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N002AddTwoNumbers {

    /*
    运算规则和我们怎么做加法很像。我们做加法的时候加数和被加数的个位相加产生和的个位数，并且如果相加的结果大于10，需要向十位产生进位。同理十位、百位。
    此题中我们也可以采取这种方式。
    （head1.val + head2.val + jinwei） % 10 就是结果中此位置的值。 而新的进位为（head1.val + head2.val + jinwei） / 10 。
    有两个地方是主要注意的。
    1、可能会出现head1或者head2已经为null了的情况。
    2、最后head1和head2均为null以后，还要考虑jinwei如果不为0的情况，此时要加其加至链表末尾。

     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int jinwei = 0;
        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + jinwei;
            res.next = new ListNode(sum % 10);
            res = res.next;
            jinwei = sum / 10;
            l1 = l1.next;
            l2 = l2.next;

        }
        while (l1 != null) {
            int sum = l1.val + jinwei;
            res.next = new ListNode((sum) % 10);
            res = res.next;
            jinwei = sum / 10;
            l1 = l1.next;

        }
        while (l2 != null) {
            int sum = l2.val + jinwei;
            res.next = new ListNode((sum) % 10);
            res = res.next;
            jinwei = sum / 10;
            l2 = l2.next;

        }
        if (jinwei == 1) {
            res.next = new ListNode(1);
        }
        return tmp.next;
    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int jinwei = 0;
        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + jinwei;
            res.next = new ListNode(sum % 10);
            res = res.next;
            jinwei = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (jinwei == 1) {
            res.next = new ListNode(1);
        }
        return tmp.next;
    }
}
