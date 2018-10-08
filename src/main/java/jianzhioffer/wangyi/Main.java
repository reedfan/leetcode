package jianzhioffer.wangyi;

/**
 * Author 范群松.
 * Date：2018/9/8
 * Time: 16:48
 */


import java.util.*;

public class Main {
    private static int func(String str) {

        char[] array = str.toCharArray();
        int max = 0;
        int leng = 1;
        for(int i = 1; i < array.length ; i++){
            if(array[i] != array[i-1]){
                leng++;
                max = Math.max(leng, max);
            }else{
                leng = 1;
            }
        }
        return max;
    }
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();

            int len = func(str);
            System.out.println(len);
        }

    }

}
