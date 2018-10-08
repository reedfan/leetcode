package jianzhioffer.arraylist;

/**
 * Author 范群松.
 * Date：2018/8/19
 * Time: 15:06
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Solution7 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode result = null;
        while (list1 != null && list2 != null){
            if(list1.val>list2.val){
                result.next = list1;
                list1 = list1.next;
            }else {
                result.next = list2;
                list2 = list2.next;
            }
        }
        while (list1 != null){
            result.next = list1;
            list1 = list1.next;
        }
        while (list2 != null){
            result.next = list2;
            list2 = list2.next;
        }
        return result;
    }
}
