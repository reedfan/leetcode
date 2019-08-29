package leetcode.putong;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestKNumber {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer>list = new ArrayList<>();
        if(input.length<k || k==0){
            return list;
        }

        PriorityQueue<Integer>maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < input.length; i++) {
            if(maxHeap.size()<k){
                maxHeap.add(input[i]);
            }else {
                if(maxHeap.peek()>input[i]){
                    maxHeap.poll();
                    maxHeap.offer(input[i]);
                }
            }

        }

        for(Integer num:maxHeap){
            list.add(num);
        }

        return list;

    }
}
