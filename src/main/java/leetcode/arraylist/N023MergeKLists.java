package leetcode.arraylist;

import leetcode.tree.TreeNode;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）23
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N023MergeKLists {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);

        ListNode[] lists = {listNode1, listNode2, listNode3};
        new N023MergeKLists().mergeKLists(lists);

    }

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode res = new ListNode(-1);
        if (lists == null || lists.length == 0) {
            return res.next;
        }
        //表示此链表是否已经全加上去
        boolean[] tmp = new boolean[lists.length];
        int min = Integer.MAX_VALUE;
        int minPos = -1;
        //已经遍历完成的链表的数量
        int cntTmp = 0;

        ListNode head = res;

        while (cntTmp < lists.length) {
            for (int i = 0; i < lists.length; i++) {
                if (!tmp[i]) {
                    if (lists[i] == null) {
                        tmp[i] = true;
                        cntTmp++;
                        continue;
                    }
                    if (min > lists[i].val) {
                        min = lists[i].val;
                        minPos = i;
                    }

                }
            }
            if (min != Integer.MAX_VALUE) {
                res.next = lists[minPos];
                res = res.next;
                lists[minPos] = lists[minPos].next;
                min = Integer.MAX_VALUE;

            }


        }
        return head.next;
    }

    /*
    模仿归并排序的思想，先分再合。
     */


    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);

    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode node1 = merge(lists, left, mid);
        ListNode node2 = merge(lists, mid + 1, right);
        return merge(node1, node2);


    }

    private ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == null ? node2 : node1;
        }
        if (node1.val < node2.val) {
            node1.next = merge(node1.next, node2);
            return node1;
        } else {
            node2.next = merge(node1, node2.next);
            return node2;
        }

    }


}
