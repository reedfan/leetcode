package leetcode.arraylist;

public class GetIntersectionNode160 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(4);
        listNode2.next = new ListNode(5);
        new GetIntersectionNode160().getIntersectionNode(listNode1,listNode2);
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB){
            pA = pA == null?headB:pA.next;
            pB = pB == null?headA:pB.next;
        }
        return pA;
    }

}
