package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 您需要在二叉树的每一行中找到最大的值。
 * <p>
 * 示例：
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 * <p>
 * 输出: [1, 3, 9]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N515largestValues {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        int cnt = 1;
        int maxValue = Integer.MIN_VALUE;

        while (nodeList.size() > 0) {
            while (cnt > 0) {
                cnt--;
                TreeNode tmp = nodeList.removeFirst();
                maxValue = maxValue > tmp.val ? maxValue : tmp.val;
                if (tmp.left != null) {
                    nodeList.add(tmp.left);
                }
                if (tmp.right != null) {
                    nodeList.add(tmp.right);
                }
            }
            list.add(maxValue);
            maxValue = Integer.MIN_VALUE;
            cnt = nodeList.size();
        }

        return list;


    }
}
