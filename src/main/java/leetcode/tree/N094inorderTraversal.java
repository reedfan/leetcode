package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归中序遍历二叉树
 */
public class N094inorderTraversal {

    /*
    1.申请一个新的栈stack。
    2.对于以root为根节点的这棵树，依次将左边界压入栈中。即不停的让root = root.left，不断重复此步骤
    3.不断的重复2，直到发现cur为空，此时从stack中弹出一个节点。将该节点的值加入返回结果。并且让node = node.right然后重复步骤2.
     */

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {

            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;

            }
        }
        return list;

    }
}
