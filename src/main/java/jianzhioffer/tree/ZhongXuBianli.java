package jianzhioffer.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZhongXuBianli {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                root = root.left;
                stack.push(root);
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            root = node.right;
        }
        return list;

    }
}
