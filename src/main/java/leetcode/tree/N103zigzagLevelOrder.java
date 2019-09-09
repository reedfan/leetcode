package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）  103
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N103zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<>();
        if(root == null){
            return lists;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        List<Integer> list = new ArrayList<>();
        while ((!stack1.isEmpty() && stack2.isEmpty())){
            while (!stack1.empty()){
                TreeNode tmp = stack1.pop();
                list.add(tmp.val);
                if(tmp.left != null){
                    stack2.push(tmp.left);
                }
                if(tmp.right != null){
                    stack2.push(tmp.right);
                }
            }
            if(!list.isEmpty()){
                lists.add(new ArrayList<>(list));
                list.clear();
            }
            while (!stack2.empty()){
                TreeNode tmp = stack2.pop();
                list.add(tmp.val);
                if(tmp.right != null){
                    stack1.push(tmp.right);
                }
                if(tmp.left != null){
                    stack1.push(tmp.left);
                }

            }
            if(!list.isEmpty()){
                lists.add(new ArrayList<>(list));
                list.clear();
            }

        }


        return lists;


    }



    public List<List<Integer>> zigzagLevelOrderDFS(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        DFS(root, 0, ans);
        return ans;
    }

    private void DFS(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        if (ans.size() <= level) {
            ans.add(new ArrayList<>());
        }
        if ((level % 2) == 0) {
            ans.get(level).add(root.val); //添加到末尾
        } else {
            ans.get(level).add(0, root.val); //添加到头部
        }

        DFS(root.left, level + 1, ans);
        DFS(root.right, level + 1, ans);
    }
}
