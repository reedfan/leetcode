package jianzhioffer.putong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class HuaDongChuangKou {
    public static void main(String[] args) {
        int[] list = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> maxInWindows = maxInWindows(list ,3);
        for(Integer num:maxInWindows){
            System.out.println(num);
        }
    }
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        if(num==null||num.length==0||size>num.length||size==0){
            return list;
        }

        //用来记录滑动窗口中最大的值的坐标
        LinkedList<Integer> qmax = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            while (!qmax.isEmpty()&& num[qmax.getLast()]<=num[i]){
                qmax.pollLast();
            }
            qmax.add(i);
        }
        list.add(num[qmax.getFirst()]);
        for (int i = size; i < num.length; i++) {
            if(qmax.getFirst()==i-size){
                qmax.pollFirst();
            }
            while (!qmax.isEmpty()&&num[qmax.getLast()]<=num[i]){
                qmax.pollLast();
            }
            qmax.add(i);
            list.add(num[qmax.getFirst()]);

        }

        return list;
    }
}
