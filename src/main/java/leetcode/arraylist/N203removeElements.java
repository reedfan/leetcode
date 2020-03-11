package leetcode.arraylist;

public class N203removeElements {
    /*
    删除链表中等于给定值 val 的所有节点。

    示例:
    输入: 1->2->6->3->4->5->6, val = 6
    输出: 1->2->3->4->5

        head
       1->2->6->3->4->5->6

      res
   -1->1->2->6->3->4->5->6

   1->2->6->3->4->5->6, val = 1

   2->6->3->4->5->6

  head
   1->2->6->3->4->5->6, val = 6

  head.next =
     */


    /*
    递归写法
     */
    public ListNode removeElements(ListNode head, int val) {

        if(head == null){
            return head;
        }
        if(head.val == val){
            return removeElements(head.next, val);
        }else {
            head.next = removeElements(head.next, val);
        }
        return head;

    }


    public ListNode removeElements1(ListNode head, int val) {
        if(head == null){
            return head;
        }
        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        while (head != null){
            if(head.val != val){
                res.next = head;
                res = res.next;
            }
            head = head.next;
        }
        res.next = null;
        return tmp.next;

    }
}
