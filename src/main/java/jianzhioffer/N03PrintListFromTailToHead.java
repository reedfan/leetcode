package jianzhioffer;

import leetcode.arraylist.ListNode;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Author 范群松.
 * Date：2018/8/19
 * Time: 11:17
 * 从头到尾打印链表
 */
public class N03PrintListFromTailToHead {
    ArrayList<Integer> result = new ArrayList<Integer>();

    @Test
    public void test(){
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        printListFromTailToHead(listNode);
    }


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null){
            printListFromTailToHead(listNode.next);
            result.add(listNode.val);
        }
        return result;
    }
}
