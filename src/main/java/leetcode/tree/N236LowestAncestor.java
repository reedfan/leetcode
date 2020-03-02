package leetcode.tree;

public class N236LowestAncestor {

    /*
    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]



示例 1:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。

示例 2:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。



说明:

    所有节点的值都是唯一的。
    p、q 为不同节点且均存在于给定的二叉树中。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {


        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.right.left = new TreeNode(8);
        System.out.println(lowestAncestor(treeNode, treeNode.right.right, treeNode.right.right.left).val);

    }


    public static TreeNode lowestAncestor(TreeNode root, TreeNode node1, TreeNode node2) {

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
