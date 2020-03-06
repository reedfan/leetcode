package leetcode.arraylist;

public class ShowMeBug {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(5);
        listNode1.next = new ListNode(2);
       // listNode1.next.next = new ListNode(3);
      //  listNode1.next.next.next = new ListNode(4);
      //  listNode1.next.next.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(3);
        listNode2.next = new ListNode(4);

        System.out.println(findMid(listNode1,listNode2));


    }

    private static ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        while(left != null && right != null){
            if(left.val < right.val){
                tmp.next = left;
                left = left.next;
            } else{
                tmp.next = right;
                right = right.next;
            }
            tmp = tmp.next;
        }
        if(left != null){
            tmp.next = left;
        }
        if(right != null){
            tmp.next = right;
        }
        return res.next;
    }

    private static double findMid(ListNode l1, ListNode l2){
        assert (l1 != null && l2 != null);
        l1 = sortList(l1);
        l2 = sortList(l2);
        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                res.next = l1;
                l1 = l1.next;
            }else{
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        if(l1 != null){
            res.next = l1;
        }
        if(l2 != null){
            res.next = l2;
        }
        ListNode fast = tmp.next.next;
        ListNode slow = tmp.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //  1 2 3 4
        if(fast == null){
            return 1.0*slow.val;
        }
        return 1.0*(slow.val+slow.next.val)/2;



    }
}
