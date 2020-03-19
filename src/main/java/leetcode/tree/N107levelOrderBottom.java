package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N107levelOrderBottom {

    /*
    给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

返回其自底向上的层次遍历为：

[
  [15,7],
  [9,20],
  [3]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.right.left = new TreeNode(8);
        System.out.println(new N107levelOrderBottom().levelOrderBottom1(treeNode));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        DFS(root, 0, ans);
        return ans;
    }

    /*

    []

     */


    private void DFS(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        // 当前层数还没有元素，先 new 一个空的列表
        if (ans.size() <= level) {
            List<Integer> list = new ArrayList<>();
            ans.add(0, list);
        }
        // 当前值加入
        ans.get(ans.size() - 1 - level).add(root.val);

        DFS(root.left, level + 1, ans);
        DFS(root.right, level + 1, ans);
    }


    public List<List<Integer>> levelOrderBottom1(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<>();

        if (root == null) {
            return lists;
        }

        // 用来暂存树的节点
        LinkedList<TreeNode> list = new LinkedList<>();

        list.add(root);
        // 取出每一层的数据，最后放到lists
        List<Integer> res = new ArrayList<>();

        while (!list.isEmpty()) {

            int cnt = list.size();
            while (cnt > 0) {
                TreeNode first = list.removeFirst();
                res.add(first.val);
                if (first.left != null) {
                    list.add(first.left);
                }
                if (first.right != null) {
                    list.add(first.right);
                }
                cnt--;
            }
            lists.add(0, new ArrayList<>(res));
            res.clear();
        }
        return lists;
    }
}
