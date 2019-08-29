package leetcode.tree;

/**
 * created by reedfan on 2019/4/23 0023
 */
public class PingHengErChaShu {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }
        if(Math.abs(dep(root.left)-dep(root.right))>1){
            return false;
        }

        return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
    }

    private int dep(TreeNode root){
        if(root == null){
            return 0;
        }
        return dep(root.left)>dep(root.right)?dep(root.left):dep(root.right)+1;

    }




}
