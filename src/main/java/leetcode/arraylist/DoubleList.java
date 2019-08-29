package leetcode.arraylist;

public class DoubleList {
    private Node146 head, tail; // 头尾虚节点
    private int size; // 链表元素数

    public DoubleList() {
        head = new Node146(0, 0);
        tail = new Node146(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // 在链表头部添加节点 x
    public void addFirst(Node146 x) {
        x.next = head.next;
        x.prev = head;
        head.next.prev = x;
        head.next = x;
        size++;
    }

    // 删除链表中的 x 节点（x 一定存在）
    public void remove(Node146 x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    // 删除链表中最后一个节点，并返回该节点
    public Node146 removeLast() {
        if (tail.prev == head)
            return null;
        Node146 last = tail.prev;
        remove(last);
        return last;
    }

    // 返回链表长度
    public int size() { return size; }

}
