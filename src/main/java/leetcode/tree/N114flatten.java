package leetcode.tree;

/**
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N114flatten {
    public void flatten(TreeNode root) {
        while (root != null){
            if(root.left == null){
                root = root.right;
            } else {
                TreeNode left = root.left;
                while(left.right != null){
                    left = left.right;
                }
                left.right = root.right;
                root.right = root.left;
                root.left = null;

            }
        }

    }
}
