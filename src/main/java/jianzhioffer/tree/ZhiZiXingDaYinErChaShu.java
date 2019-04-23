package jianzhioffer.tree;

import java.util.ArrayList;
import java.util.LinkedList;

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
        LinkedList<TreeNode>list = new LinkedList<TreeNode>();
        list.add(pRoot);
        int cur,size;
        Boolean odd = true;
        while (!list.isEmpty()){
            cur = 0;
            size = list.size();
            ArrayList<Integer>arrayList = new ArrayList<Integer>();

            while (cur<size){
                cur++;
                TreeNode head = list.poll();
                arrayList.add(head.val);
                if(odd){
                    if(head.right!=null){
                        list.add(head.right);
                    }
                    if(head.left != null){
                        list.add(head.left);
                    }
                }else {
                    if(head.left != null){
                        list.add(head.left);
                    }
                    if(head.right!=null){
                        list.add(head.right);
                    }

                }

            }
            odd = !odd;
            arrayLists.add(arrayList);


        }

        return arrayLists;
    }
}
