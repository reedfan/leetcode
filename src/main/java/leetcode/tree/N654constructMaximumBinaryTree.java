package leetcode.tree;

/**
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * <p>
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * <p>
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * <p>
 * <p>
 * <p>
 * 示例 ：
 * <p>
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 * <p>
 * 6
 * /   \
 * 3     5
 * \    /
 * 2  0
 * \
 * 1
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定的数组的大小在 [1, 1000] 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N654constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode node = null;
        for (int num : nums) {
            node = process(node, num);

        }
        return node;

    }

    private TreeNode process(TreeNode root, int num) {
        TreeNode node = new TreeNode(num);
        if (root == null) {
            return node;
        }
        if (root.val < num) {
            node.left = root;
            return node;
        } else {
            root.right = process(root.right, num);
            return root;

        }
    }
}
