package jianzhioffer.arraylist;

/**
 * Author 范群松.
 * Date：2018/8/17
 * Time: 17:43
 * 找到环的入口节点
 */
public class Solution2 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                fast = pHead;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
