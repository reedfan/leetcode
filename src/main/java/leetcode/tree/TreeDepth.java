package leetcode.tree;

import java.util.LinkedList;

/**
 * created by reedfan on 2019/4/22 0022
 */
public class TreeDepth {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(6);


        treeNode1.left = treeNode2;

        treeNode1.right = treeNode3;

        System.out.println(TreeDepth1(treeNode1));

    }

    public static int TreeDepth1(TreeNode root){
        /*
        15ms
         */
        if(root == null){
            return 0;
        }
        return  Math.max(TreeDepth1(root.left),TreeDepth1(root.right))+1;
    }


    public static int TreeDepth(TreeNode root) {
        /*
        29ms
         */
        if(root == null){
            return 0;
        }
        int dep = 0;
        int cur;
        int size;
        LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();
        linkedList.add(root);
        while (!linkedList.isEmpty()){
            size = linkedList.size();
            cur = 0;
            while (cur < size){
                cur++;
                TreeNode head = linkedList.poll();
                if(head.left != null){
                    linkedList.add(head.left);
                }
                if(head.right != null){
                    linkedList.add(head.right);
                }
            }

            dep++;
        }
        return dep;
    }
}
