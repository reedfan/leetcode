package file;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(8);
        arr.add(2);
        arr.add(4);
        arr.add(3);
        System.out.println(segment1(2, arr));

    }

    public static int segment(int x, List<Integer> arr) {
        if (arr == null || arr.size() == 0) {
            return -1;
        }

        Queue<Integer> min = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {

                return i1 - i2;
            }
        });

        int small = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            //移除第一个元素
            if (min.size() >= x) {
                min.remove(arr.get(i - x));
            }
            min.offer(arr.get(i));
            //更新 result
            if (i >= x - 1) {
                small = small > min.peek() ? small : min.peek();

            }
        }
        return small;

    }

    public static int segment1(int x, List<Integer> arr) {
        if (arr == null || arr.size() == 0) {
            return -1;
        }

        //单调递增队列
        LinkedList<Integer> qmin = new LinkedList<>();

        int big = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            //如果当前元素比队列的最后一个元素小，那么就将最后一个元素出队，重复这步直到当前元素小于队列的最后一个元素或者队列为空
            while (!qmin.isEmpty() && arr.get(qmin.peekLast()) > arr.get(i)) {
                qmin.pollLast();
            }
            qmin.addLast(i);
            //判断队首元素是否已经在窗口之外
            if (qmin.peekFirst() == i - x) {
                qmin.pollFirst();
            }
            if (i >= x - 1) {

                big = big > arr.get(qmin.peekFirst()) ? big : arr.get(qmin.peekFirst());
            }
        }
        return big;

    }


    public ArrayList<Integer> maxInWindows1(int[] num, int size) {
        if (num == null || num.length == 0 || size <= 0 || num.length < size) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        //双端队列，用来记录每个窗口的最大值下标
        LinkedList<Integer> qmax = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            //队列左边元素最大
            while (!qmax.isEmpty() && num[qmax.peekLast()] < num[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            //判断队首元素是否已经在窗口之外
            if (qmax.peekFirst() == i - size) {
                qmax.pollFirst();
            }
            //向result列表中加入元素
            if (i >= size - 1) {
                result.add(num[qmax.peekFirst()]);
            }
        }
        return result;
    }


}
