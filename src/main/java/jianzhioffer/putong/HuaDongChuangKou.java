package jianzhioffer.putong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class HuaDongChuangKou {
    public static void main(String[] args) {
        int[] list = {2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> maxInWindows = maxInWindows(list, 3);
        for (Integer num : maxInWindows) {
            System.out.println(num);
        }
    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        //参数校验，考虑要严谨
        if (num == null || num.length == 0 || size > num.length || size == 0) {
            return list;
        }

        //用来记录滑动窗口中最大的值的坐标
        LinkedList<Integer> qmax = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            //qmax里面的数比num[i]小的话，永远都不会是最大的，所以需要淘汰
            while (!qmax.isEmpty() && num[qmax.getLast()] <= num[i]) {
                qmax.pollLast();
            }
            qmax.add(i);
        }
        //此时，队首元素就是最大的，将他加入list
        list.add(num[qmax.getFirst()]);
        for (int i = size; i < num.length; i++) {
            if (qmax.getFirst() == i - size) {
                qmax.pollFirst();
            }
            while (!qmax.isEmpty() && num[qmax.getLast()] <= num[i]) {
                qmax.pollLast();
            }
            qmax.add(i);
            list.add(num[qmax.getFirst()]);

        }

        return list;
    }
}
