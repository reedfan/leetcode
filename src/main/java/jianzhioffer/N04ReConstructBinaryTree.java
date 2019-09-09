package jianzhioffer;

import leetcode.tree.TreeNode;

/**
 * created by reedfan on 2019/5/6 0006
 */
public class N04ReConstructBinaryTree {
    /**
     *输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
     * 则重建二叉树并返回
     */
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        return reConBtree(pre,0,pre.length-1,in,0,in.length-1);

    }

    private TreeNode reConBtree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {

        if(preStart>preEnd ||inStart>inEnd){
            return null;
        }
        //根节点
        TreeNode root = new TreeNode(pre[preStart]);

        for (int i = inStart; i <= inEnd ; i++) {
            if(pre[preStart] == in[i]){
                //重构左子树
                root.left = reConBtree(pre,preStart+1,preStart+i-inStart,in,inStart,i-1);
                //重构右子树
                root.right = reConBtree(pre,preStart+i+1-inStart,preEnd,in,i+1,inEnd);
                break;

            }

        }
        return root;
    }
}
