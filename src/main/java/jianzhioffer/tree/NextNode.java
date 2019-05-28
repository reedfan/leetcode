package jianzhioffer.tree;

/**
 * created by reedfan on 2019/5/13 0013
 */
public class NextNode {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null){
            return null;
        }
        if(pNode.right!=null){
            TreeLinkNode node = pNode.right;
            while (node!=null){
                node = node.left;
            }
            return node;
        }


        return pNode;
    }
}
