package leetcode.putong;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Author 范群松.
 * Date：2018/8/18
 * Time: 21:37
 *
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */

public class Solution24 {
    public static void main(String[] args) {
        int k = 4;
        int[] arr = {4,5,1,6,2,7,3,8};
        System.out.println(GetLeastNumbers_Solution(arr,k));
    }


    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if(k > length || k==0){
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < length; i++) {
            if(maxHeap.size() != k){
                maxHeap.add(input[i]);
            }else if(maxHeap.peek() > input[i]){
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }

        }

        for (Integer integer:maxHeap){
            result.add(integer);
        }
        return result;

    }
}
