package jianzhioffer.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * created by reedfan on 2019/7/14 0014
 */
public class PathSum {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(12);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(7);
        pathSum(treeNode,22);
    }
    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        Stack<Integer> stack = new Stack<>();
        int pathValue = 0;
        preOrder(root, pathValue, target, stack, lists);
        return lists;
    }

    private static void preOrder(TreeNode node, int pathValur, int sum, Stack<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if (node == null) {
            return;
        }
        pathValur += node.val;
        path.add(node.val);
        if (node.left == null && node.right == null && pathValur == sum) {
            result.add(new ArrayList<>(path));
        }
        preOrder(node.left, pathValur, sum, path, result);
        preOrder(node.right, pathValur, sum, path, result);
        //回退 剪枝
        pathValur -= node.val;
        path.pop();
    }
}
