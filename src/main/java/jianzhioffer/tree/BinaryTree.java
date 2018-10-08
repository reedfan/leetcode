package jianzhioffer.tree;

import java.util.HashMap;

/**
 * Author 范群松.
 * Date：2018/8/18
 * Time: 21:21
 */

public class BinaryTree {


    public Node init() {
        // 注意必须逆序建立，先建立子节点，再逆序往上建立，因为非叶子结点会使用到下面的节点，而初始化是按顺序初始化的，不逆序建立会报错
        Node J = new Node(8, null, null);		Node H = new Node(4, null, null);		Node G = new Node(2, null, null);		Node F = new Node(7, null, J);		Node E = new Node(5, H, null);		Node D = new Node(1, null, G);		Node C = new Node(9, F, null);		Node B = new Node(3, D, E);		Node A = new Node(6, B, C);		return A; // 返回根节点	}
    }



    public void printNode(Node node) {
        System.out.print(node.getData());
    }
    //先序遍历
    public void theFirstTraversal(Node root){
        printNode(root);
        if(root.getLeftNode()!=null){
            this.theFirstTraversal(root.getLeftNode());
        }
        if(root.getRightNode()!=null){
            this.theFirstTraversal(root.getRightNode());
        }
    }

    //中虚遍历
    public void theOrderTraversal(Node root){
        if(root.getLeftNode() != null){
            this.theOrderTraversal(root.getLeftNode());
        }
        printNode(root);
        if(root.getRightNode()!=null){
            this.theOrderTraversal(root.getRightNode());
        }
    }

    //后续遍历
    public void thePostOrderTraversal(Node root) {
        if(root.getLeftNode()!=null){
            this.thePostOrderTraversal(root.getLeftNode());
        }
        if(root.getRightNode()!=null){
            this.thePostOrderTraversal(root.getRightNode());
        }
        printNode(root);
    }


        public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = tree.init();
        System.out.println("先序遍历");
        tree.theFirstTraversal(root);
        System.out.println("");
        System.out.println("中序遍历");
        tree.theOrderTraversal(root);
        System.out.println("");
        System.out.println("后序遍历");
        tree.thePostOrderTraversal(root);
        System.out.println("");
    }


}
