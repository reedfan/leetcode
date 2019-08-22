package jianzhioffer.tree;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）  105
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class BuildTree105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length){
            return null;
        }

        return help(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode help(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd){
        if(pStart == pEnd){
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[0]);
        int index= 0;

        while (inorder[index] != preorder[0]){
            index++;
        }
        treeNode.left = help(preorder,pStart+1,pStart+index,inorder,iStart,iStart+index-1);
        treeNode.right = help(preorder,pStart+index+1,pStart+index,inorder,iStart,iEnd);

        return treeNode;




    }


}
