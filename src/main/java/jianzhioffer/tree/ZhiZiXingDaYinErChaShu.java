package jianzhioffer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * created by reedfan on 2019/4/23 0023
 */
public class ZhiZiXingDaYinErChaShu {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(7);


        treeNode1.left = treeNode2;

        treeNode1.right = treeNode3;

        treeNode1.left.left = treeNode4;

        treeNode1.left.right = treeNode5;

        treeNode1.right.left = treeNode6;

        ArrayList<ArrayList<Integer>> arrayLists = Print(treeNode1);
        System.out.println(arrayLists.size());



    }

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return arrayLists;
        }
        Stack<TreeNode> even = new Stack<TreeNode>();   //偶数
        Stack<TreeNode> odd = new Stack<TreeNode>();   //奇数
        odd.push(pRoot);
        while (!(odd.isEmpty()&&even.isEmpty())){
            ArrayList<Integer> list = new ArrayList<Integer>();
            if(odd.isEmpty()){
                while (!even.isEmpty()){
                    TreeNode head = even.pop();
                    list.add(head.val);
                    if(head.right != null){
                        odd.add(head.right);
                    }
                    if(head.left != null){
                        odd.add(head.left);
                    }


                }
                arrayLists.add(list);

            }else {
                while (!odd.isEmpty()){
                    TreeNode head = odd.pop();
                    list.add(head.val);
                    if(head.left != null){
                        even.add(head.left);
                    }
                    if(head.right != null){
                        even.add(head.right);
                    }

                }
                arrayLists.add(list);

            }

        }

        return arrayLists;
    }
}
