package leetcode.tree;

public class N226InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode left = root.left;

        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}
