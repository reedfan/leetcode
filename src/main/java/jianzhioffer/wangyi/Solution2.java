package jianzhioffer.wangyi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Author 范群松.
 * Date：2018/9/8
 * Time: 16:14
 */

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int input = in.nextInt();
            System.out.println( ug(input));
        }
    }

    private static int ug(int n){


        if(n<=0){
            return 0;
        }

        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(1);
        int i2=0,i3=0,i5=0;
        while(list.size()<n) {
            int m2=list.get(i2)*2;
            int m3=list.get(i3)*3;
            int m5=list.get(i5)*5;
            int min=Math.min(m2,Math.min(m3,m5));
            list.add(min);
            if(min==m2){
                i2++;
            } if(min==m3){
                i3++;
            } if(min==m5){
                i5++;
            }
        }
        return list.get(list.size()-1);
    }
}
