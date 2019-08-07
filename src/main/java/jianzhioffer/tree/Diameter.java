package jianzhioffer.tree;

public class Diameter {
    /**
     *
     * leetcode 543
     */
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;

    }

    private int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDep = depth(root.left);
        int rightDep = depth(root.right);
        max =  Math.max(max,leftDep+rightDep);
        return Math.max(leftDep,rightDep)+1;
    }


}
