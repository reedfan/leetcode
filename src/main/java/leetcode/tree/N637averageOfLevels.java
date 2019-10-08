package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 *
 * 示例 1:
 *
 * 输入:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N637averageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        int cnt = 1;
        double sum = 0;
        int flag = 0;

        while (nodeList.size() > 0) {
            flag = cnt;
            while (cnt > 0) {
                cnt--;
                TreeNode tmp = nodeList.removeFirst();
                sum += tmp.val;
                if (tmp.left != null) {
                    nodeList.add(tmp.left);
                }
                if (tmp.right != null) {
                    nodeList.add(tmp.right);
                }
            }
            list.add(sum/flag);
            sum = 0;
            cnt = nodeList.size();
        }

        return list;
    }
}
