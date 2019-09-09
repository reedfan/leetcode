package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 *
 *
 * 来源：力扣（LeetCode）102
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N102LevelOrder {

    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        DFS(root,0);
        return lists;

    }

    private void DFS(TreeNode root, int level){
        if(root == null){
            return;
        }
        //当前层数还没有元素，先new一个空的列表
        if(lists.size() <= level){
            lists.add(new ArrayList<>());
        }
        //当前值加入
        lists.get(level).add(root.val);
        DFS(root.left,level+1);
        DFS(root.right,level+1);
    }






    //BFS

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null){
            return lists;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()){
            int cnt = list.size();
            List<Integer> newList = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                TreeNode node = list.peekFirst();
                newList.add(node.val);
                if(node.left!=null){
                    list.add(node.left);
                }
                if(node.right!=null){
                    list.add(node.right);
                }

            }
            lists.add(newList);

        }

        return lists;

    }
}
