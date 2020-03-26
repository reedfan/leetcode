package leetcode.tree;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * <p>
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）  105
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N105BuildTree {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        new N105BuildTree().buildTree(preorder, inorder);

    }
    /*
    因为前序遍历为根左右。 中序遍历为左右根。
    所以前序遍历的第一个元素为重建的二叉树的根节点的值。
    遍历中序遍历，直到找到和根节点值相同的位置。则此元素左边的都是根节点的左子树的元素，右边的都是根节点右子树的元素。
    通过递归很容易求出解。
    以preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7}为例。

    则新建二叉树的根节点为3，然后根的左孩子为9，右孩子以preorder = {20, 15, 7}, inorder = {15, 20, 7}新建,如下图所示。
![WeChatb077232a68834249b94e4aeadeccebf4.png](https://pic.leetcode-cn.com/8cb9341fa2b876100937dfe9ca0deff14addc14dbaa63cd0e3532694d86dba5e-WeChatb077232a68834249b94e4aeadeccebf4.png)
以preorder = {20, 15, 7}, inorder = {15, 20, 7}新建的过程和前面类似。很明显可以看出20为根，15为左，7为右
![图片.png](https://pic.leetcode-cn.com/f178727a8d97e4b58dfa8ded4a89e594cd9832f291613a5d935caa6e35c234c5-%E5%9B%BE%E7%89%87.png)







     */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        TreeNode treeNode = help(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return treeNode;
    }

    private TreeNode help(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        //递归的第一步：递归终止条件，避免死循环
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }
        //重建根节点
        TreeNode treeNode = new TreeNode(preorder[pStart]);
        int index = 0;  //index找到根节点在中序遍历的位置
        while (inorder[iStart + index] != preorder[pStart]) {
            index++;
        }
        //重建左子树
        treeNode.left = help(preorder, pStart + 1, pStart + index, inorder, iStart, iStart + index - 1);
        //重建右子树
        treeNode.right = help(preorder, pStart + index + 1, pEnd, inorder, iStart + index + 1, iEnd);
        return treeNode;

    }


}
