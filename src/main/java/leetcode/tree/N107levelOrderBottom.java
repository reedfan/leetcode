package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N107levelOrderBottom {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.right.left = new TreeNode(8);
        System.out.println(new N107levelOrderBottom().levelOrderBottom(treeNode));
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        DFS(root, 0, ans);
        return ans;
    }

    private void DFS(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        // 当前层数还没有元素，先 new 一个空的列表
        if (ans.size() <= level) {
            ans.add(0, new ArrayList<>());
        }
        // 当前值加入
        ans.get(ans.size() - 1 - level).add(root.val);

        DFS(root.left, level + 1, ans);
        DFS(root.right, level + 1, ans);
    }


    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        if(root == null){
            return lists;
        }
        LinkedList<TreeNode>list = new LinkedList<>();
        list.add(root);
        List<Integer> res = new ArrayList<>();
        while(!list.isEmpty()){
            int cnt = list.size();
            while(cnt > 0){
                TreeNode first = list.removeFirst();
                res.add(first.val);
                if(first.left != null){
                    list.add(first.left);
                }
                if(first.right != null){
                    list.add(first.right);
                }
                cnt--;
            }
            lists.add(0,new ArrayList<>(res));
            res.clear();
        }
        return lists;


    }
}
