package leetcode.tree;

import java.util.ArrayList;

/**
 * Author 范群松.
 * Date：2018/8/18
 * Time: 19:10
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */

public class Main7 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        while (! list.isEmpty()){
            TreeNode first = list.remove(0);
            result.add(first.val);
            if(first.left != null){
                list.add(first.left);
            }
            if(first.right != null){
                list.add(first.right);
            }
        }
        return result;

    }
}
