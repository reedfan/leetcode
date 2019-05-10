package jianzhioffer.tree;

/**
 * Author 范群松.
 * Date：2018/9/27
 * Time: 11:33
 */

public class Node {
    private int data;
    private Node leftNode;
    private Node rightNode;
    public Node(int data, Node leftNode, Node rightNode) {
        this.setData(data);
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
    public int getData() {		return data;	}	public void setData(int data) {		this.data = data;	}	public Node getLeftNode() {		return leftNode;	}	public void setLeftNode(Node leftNode) {		this.leftNode = leftNode;	}	public Node getRightNode() {		return rightNode;	}	public void setRightNode(Node rightNode) {		this.rightNode = rightNode;	}


}
