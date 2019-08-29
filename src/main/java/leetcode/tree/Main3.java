package leetcode.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Author 范群松.
 * Date：2018/8/17
 * Time: 14:36
 *
 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。

 */

public class Main3 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>>arrayLists = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return arrayLists;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        //存奇数层节点
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
     //   Queue<TreeNode> arrayListJishu = new LinkedList<TreeNode>();
        //存偶数层节点
      //  Queue<TreeNode> arrayListOushu = new LinkedList<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();

        stack1.add(pRoot);
        while (! stack1.isEmpty() || !stack2.isEmpty()){
            while (!stack1.isEmpty()){
                TreeNode treeNode = stack1.pop();
                arrayList.add(treeNode.val);
                if(treeNode.left != null){
                    stack2.push(treeNode.left);
                }
                if(treeNode.right != null){
                    stack2.push(treeNode.right);
                }
            }
            if(!arrayList.isEmpty()){
                arrayLists.add(arrayList);
                arrayList = new ArrayList<Integer>();
            }

            while (!stack2.isEmpty()){
                TreeNode treeNode = stack2.pop();
                arrayList.add(treeNode.val);
                if(treeNode.right != null){
                    stack1.push(treeNode.right);
                }
                if(treeNode.left != null){
                    stack1.push(treeNode.left);
                }
            }
            if(!arrayList.isEmpty()){
                arrayLists.add(arrayList);
                arrayList = new ArrayList<Integer>();
            }

        }
        return arrayLists;
    }
}
