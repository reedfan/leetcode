package jianzhioffer;

import leetcode.tree.TreeNode;

/**
 * Author 范群松.
 * Date：2018/8/17
 * Time: 22:07
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */

public class N39IsBalanced_Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }
        if(TreeDepth(root.left)-TreeDepth(root.right)>1 || TreeDepth(root.right)-TreeDepth(root.left)>1){
            return false;
        }
        return (IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right));
    }

    private int TreeDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int max = TreeDepth(root.left)>TreeDepth(root.right)?TreeDepth(root.left)+1:TreeDepth(root.right)+1;
        return max;
    }
}
