package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * created by reedfan on 2019/11/28 0028
 */
public class N094inorderTraversal {
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
