package jianzhioffer.tree;

public class SortedArrayToBST108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }

        //包括左边界，不包括右边界
        return help(nums,0,nums.length);

    }


    private TreeNode help(int[] nums,int start,int end){
        if(start == end){
            return null;
        }
        int mid = start + (end -start)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = help(nums,start,mid);
        node.right = help(nums,mid+1,end);

        return node;


    }
}
