package jianzhioffer;

import leetcode.tree.TreeNode;

/**
 * Author 范群松.
 * Date：2018/8/17
 * Time: 16:32
 *
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的
 */

public class Main4 {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null){
            return true;
        }
        return isSymmetrical(pRoot.left,pRoot.right);

    }
    private boolean isSymmetrical(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val == right.val){
            return isSymmetrical(left.left,right.right)&&isSymmetrical(left.right,right.left);
        }
        return false;
    }


}
