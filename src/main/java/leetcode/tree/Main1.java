package leetcode.tree;

import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * Author 范群松.
 * Date：2018/8/17
 * Time: 11:40
 */

public class Main1 {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null || k <= 0){
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode res = null;
        int count = 0;
        TreeNode p = pRoot;
        while (p != null || !stack.isEmpty()){
            while (p != null){
                stack.push(p);
                p = p.left;
            }
            TreeNode p1 = stack.pop();
            count++;
            if(count == k){
                return p1;
            }

            p = p1.right;
        }
        return res;
    }
}
