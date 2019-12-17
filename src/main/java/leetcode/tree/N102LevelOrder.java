package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）102
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N102LevelOrder {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.right.left = new TreeNode(8);
        System.out.println(new N102LevelOrder().levelOrder1(treeNode).size());
    }

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        DFS(root, 0);
        return lists;

    }

    private void DFS(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        //当前层数还没有元素，先new一个空的列表
        if (lists.size() <= level) {
            lists.add(new ArrayList<>());
        }
        //当前值加入
        lists.get(level).add(root.val);
        DFS(root.left, level + 1);
        DFS(root.right, level + 1);
    }


    public List<List<Integer>> levelOrder1(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<>();

        if (root == null) {
            return lists;
        }
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        while (!nodeList.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int cnt = nodeList.size();
            while (cnt-- > 0) {
                TreeNode tmp = nodeList.removeFirst();
                list.add(tmp.val);
                if (tmp.left != null) {
                    nodeList.add(tmp.left);
                }
                if (tmp.right != null) {
                    nodeList.add(tmp.right);
                }
            }
            lists.add(list);
        }
        return lists;

    }


    //BFS

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int cnt = list.size();
            List<Integer> newList = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                TreeNode node = list.removeFirst();
                newList.add(node.val);
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }

            }
            lists.add(newList);

        }

        return lists;

    }
}
