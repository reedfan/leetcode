package leetcode.tree;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderUnRec {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);
        while (!stack1.isEmpty()){
            TreeNode tmp = stack1.pop();
            stack2.add(tmp);
            if(tmp.left!=null){
                stack1.add(tmp.left);
            }
            if(tmp.right!=null){
                stack1.add(tmp.right);
            }

        }
        while (!stack2.isEmpty()){
            list.add(stack2.pop().val);
        }
        return list;
    }
}
