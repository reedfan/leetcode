package leetcode.tree;

public class N530getMinimumDifference {
    /**
     * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
     * <p>
     * 示例 :
     * <p>
     * 输入:
     * <p>
     * 1
     * \
     * 3
     * /
     * 2
     * <p>
     * 输出:
     * 1
     * <p>
     * 解释:
     * 最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
     * <p>
     * 注意: 树中至少有2个节点。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */

    int res = Integer.MAX_VALUE;

    TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        help(root);
        return res;
    }

    private void help(TreeNode root) {
        if (root.left != null) {
            help(root.left);
        }
        if (pre != null) {
            res = res < (root.val - pre.val) ? res : (root.val - pre.val);
        }
        pre = root;
        if (root.right != null) {
            help(root.right);
        }

    }
}
