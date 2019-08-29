package leetcode.putong;

/*
给定一个未排序的整数数组，找出其中没有出现的最小的正整数。

示例 1:

输入: [1,2,0]
输出: 3

    1
    2

示例 2:

输入: [3,4,-1,1]
输出: 2

    1
    2

示例 3:

输入: [7,8,9,11,12]
输出: 1
 */

public class FirstInteger {

    public static void main(String[] args) {
        int[] nums = {7,8,9,1,11,12};
        System.out.println(firstMissingPositive(nums));
        Object o = new Object();

       // System.out.println(misNum(nums));

    }
    public static int firstMissingPositive(int[] nums) {

        int len = nums.length;

        for (int i = 0; i < len;) {
            //确定nums[i]的值对应的下标不越界，同时排除num[i]本身位置正确或者nums[i]应该放入的位置nums[i]-1原本就是nums[i](如[1,1])
            if(nums[i]>0 && nums[i]<=len&&(nums[i]!=nums[nums[i]-1])){
                swap(nums,i,nums[i]-1);
                //换位置之后需要继续判断换过来的值是否在对的位置上，因此不能i++;
            }else {
                i++;
            }
        }

        for (int i = 0; i < len; i++) {
            if(nums[i] != i+1){
                return i+1;
            }
            
        }

        return len+1;

    }

    private static void swap(int[] nums,int pos1,int pos2){
        int tmp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = tmp;
    }


    public static int misNum(int[] arr){
        int l = 0;   //已找到1-l都存在
        int r = arr.length;    //理想情况为1-r都存在
        while (l<r){
            if(arr[l] == l+1){
                l++;
            }else {
                if(arr[l]<=l||arr[l]>r||arr[arr[l]-1]==arr[l]){
                    arr[l] = arr[--r];   //arr[l]的值为这些条件的时候，r会--，然后覆盖掉这些值
                }else {
                    swap(arr,l,arr[l]-1);
                }
            }


        }
        return l+1;
    }

}
