package jianzhioffer;

import leetcode.arraylist.ListNode;

import java.util.ArrayList;

/**
 * Author 范群松.
 * Date：2018/8/19
 * Time: 11:17
 * 从头到尾打印链表
 */
public class N03PrintListFromTailToHead {
    ArrayList<Integer> result = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null){
            printListFromTailToHead(listNode.next);
            result.add(listNode.val);
        }
        return result;
    }
}
