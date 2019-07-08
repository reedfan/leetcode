package jianzhioffer.tree;

import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root ==null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            list.add(treeNode.val);
            if(treeNode.right!=null){
                stack.add(treeNode.right);
            }
            if(treeNode.left!=null){
                stack.add(treeNode.left);
            }

        }
        return list;
    }



}
