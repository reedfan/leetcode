package leetcode.tree;

public class N236LowestAncestor {

    public static void main(String[] args) {


        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.right.left = new TreeNode(8);
        System.out.println(lowestAncestor(treeNode,treeNode.right.right,treeNode.right.right.left).val);

    }


    public static TreeNode lowestAncestor(TreeNode root,TreeNode node1,TreeNode node2){

        //如果root为null，返回null，
        //如果root是当前任意一个节点，那最近的祖先结点就是当前节点了。
        if (root == null || root == node1 || root == node2) {
            return root;
        }

        TreeNode left = lowestAncestor(root.left, node1, node2);
        TreeNode right = lowestAncestor(root.right, node1, node2);
        //一个节点在左子树，一个节点在右子树。那最近的祖先结点就是当前节点
        if (left != null && right != null) {
            return root;
        }
        //不然的话
        return left != null ? left : right;
    }




}
