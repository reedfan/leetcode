package jianzhioffer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author 范群松.
 * Date：2018/8/17
 * Time: 13:49
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */

public class Main2 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>>arrayLists = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return arrayLists;
        }

        //使用队列，先进先出
        Queue<TreeNode> queue = new LinkedList();
        //存放每行的列表
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        //记录本层打印了多少个
        int start = 0;
        //记录下层打印多少个
        int end = 1;
        queue.add(pRoot);
        while (! queue.isEmpty()){
            TreeNode temp = queue.remove();
            //添加到本行的arrayList
            arrayList.add(temp.val);
            start++;
            //没打印一个节点，就将此节点下一层的左右节点加入队列
            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
            //判断本层是否打印完成
            if(start == end){
                arrayLists.add(arrayList);
                start = 0;
                end = queue.size();
                arrayList = new ArrayList<Integer>();

            }

        }
        return arrayLists;

    }
}
