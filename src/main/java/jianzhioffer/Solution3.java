package jianzhioffer;

import leetcode.arraylist.ListNode;

/**
 * Author 范群松.
 * Date：2018/8/18
 * Time: 15:49
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class Solution3 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int sum1 = findArrayLenth(pHead1);
        int sum2 = findArrayLenth(pHead2);
        int chaju = sum1-sum2;
        if(chaju >= 0){
            while (chaju > 0){
                pHead1 = pHead1.next;
                chaju --;
            }
        }else {
            while (chaju < 0){
                pHead2 = pHead2.next;
                chaju ++;
            }
        }
        while (pHead1 != null){
            if(pHead1 == pHead2){
                return pHead1;
            }else {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }
        return null;

    }
    private int findArrayLenth(ListNode listNode){
        int sum = 0;
        while (listNode!=null){
            sum ++;
            listNode = listNode.next;
        }
        return sum;
    }
}
