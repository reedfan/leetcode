package leetcode.tree;

public class N543DiameterOfBinaryTree {
    /**
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
     * <p>
     * 示例 :
     * 给定二叉树
     * <p>
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     * <p>
     * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
     * <p>
     * 注意：两结点之间的路径长度是以它们之间边的数目表示。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    private int max = 0;

   /* public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        max = max > (left + right) ? max : (left + right);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return max;

    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }*/

   /*
   直径肯定为某个节点为根节点的左右子树之和
    */

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDep = depth(root.left);
        int rightDep = depth(root.right);
        max = max > (leftDep + rightDep) ? max : (leftDep + rightDep);
        return (leftDep > rightDep ? leftDep : rightDep) + 1;
    }


}
