package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * 输出:
 * 1
 * <p>
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   5   6
 * /
 * 7
 * <p>
 * 输出:
 * 7
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N513findBottomLeftValue {
    int maxDepth = -1;
    int res = 0;

    //递归解法
    public int findBottomLeftValue(TreeNode root) {
        dfs(root,0);
        return res;
    }

    private void dfs(TreeNode root, int depth){
        if(root == null){
            return;
        }
        if(root.left != null){
            dfs(root.left, depth+1);
        }
        if(depth > maxDepth){
            res = root.val;
            maxDepth = depth;
        }

        if(root.right != null){
            dfs(root.right, depth+1);
        }

    }





    //非递归解法
    public int findBottomLeftValue1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = root.val;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int cnt = 1;
        while (!list.isEmpty()) {
            TreeNode tmp = list.getFirst();
            res = tmp.val;
            while (cnt-- > 0) {
                tmp = list.pollFirst();
                if (tmp.left != null) {
                    list.add(tmp.left);
                }
                if (tmp.right != null) {
                    list.add(tmp.right);
                }
            }
            cnt = list.size();


        }
        return res;
    }
}
