package leetcode.tree;

/**
 * Author 范群松.
 * Date：2018/8/17
 * Time: 21:59
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度
 */

public class Main5 {
    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return TreeDepth(root.left)>TreeDepth(root.right)?TreeDepth(root.left)+1:TreeDepth(root.right)+1;
    }
}
