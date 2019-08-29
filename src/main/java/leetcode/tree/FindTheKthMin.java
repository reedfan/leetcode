package leetcode.tree;

import java.util.Stack;

public class FindTheKthMin {
    public TreeNode KthNode(TreeNode pRoot, int k){

        Stack<TreeNode> stack = new Stack<>();
        int count = 0;

        TreeNode cur = pRoot;

        while (cur != null || !stack.empty()){

            while (cur!=null){
                stack.add(cur);
                cur = cur.left;

            }
            cur = stack.pop();
            count++;
            if(count == k){
                return cur;
            }
            cur = cur.right;

        }

        return cur;
    }
}
