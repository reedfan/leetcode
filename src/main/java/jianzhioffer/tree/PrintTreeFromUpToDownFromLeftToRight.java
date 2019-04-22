package jianzhioffer.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * created by reedfan on 2019/4/23 0023
 */
public class PrintTreeFromUpToDownFromLeftToRight {

    /*
    45ms
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return arrayLists;
        }

        LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();
        linkedList.add(pRoot);
        int size,cur;

        while (!linkedList.isEmpty()){
            cur = 0;
            size = linkedList.size();
            ArrayList<Integer>arrayList = new ArrayList<Integer>();
            while (cur<size){
                TreeNode head = linkedList.poll();
                arrayList.add(head.val);
                cur++;
                if(head.left != null){
                    linkedList.add(head.left);
                }
                if(head.right != null){
                    linkedList.add(head.right);
                }

            }
            if(!arrayList.isEmpty()){
                arrayLists.add(arrayList);
            }

        }
        return arrayLists;

    }
}
