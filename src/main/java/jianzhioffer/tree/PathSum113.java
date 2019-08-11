package jianzhioffer.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）  113
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class PathSum113 {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return lists;
        }
        process(root,sum,new ArrayList<>());
        return lists;

    }
    private void process(TreeNode root, int sum, List<Integer>list){
        if(root == null){
            return;
        }
        sum -= root.val;
        list.add(root.val);
        if(root.left == null && root.right == null && 0 == sum){
            lists.add(new ArrayList<>(list));
        }
        process(root.left,sum ,list);
        process(root.right,sum ,list);
        //java中的list传递的是引用，所以递归结束后，要把之前加入的元素删除，
        list.remove(list.size()-1);

    }
}
