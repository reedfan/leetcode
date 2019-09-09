package jianzhioffer;

import leetcode.tree.TreeNode;

/**
 * Author 范群松.
 * Date：2018/9/27
 * Time: 20:45
 * 判断一棵树是不是另外一棵树的子树
 */

public class N17HasSubTree {
    public boolean HasSubTree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean flag = false;
        if (root1.val == root2.val) {
            flag = doesTree1HaveTree2(root1, root2);
        }
        if (!flag) {
            flag = doesTree1HaveTree2(root1.left, root2);
        }
        if (!flag) {
            flag = doesTree1HaveTree2(root1.right, root2);
        }
        return flag;
    }

    private boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        //如果node2节点已经遍历完了，都能对印上，返回true
        if (node2 == null) {
            return true;
        }
        //如果其中一个节点没有对应上，返回false
        if (node1 == null) {
            return false;
        }
        //如果其中一个节点没有对应上，返回false
        if (node1.val != node2.val) {
            return false;
        }
        //如果根节点能对应上，那么就分别取子节点里分配
        return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
    }
}
