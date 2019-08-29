package leetcode.tree;

/**
 * Author 范群松.
 * Date：2018/8/18
 * Time: 20:28
 */

import java.util.Scanner;

public class Main10 {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        String N=sc.nextLine();
        int n=Integer.parseInt(N);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

        }
        int sum=0;
        long l1 =  System.currentTimeMillis();

        for (int i = 0; i < n-1; i++) {

            int small = 0;
            int big = 0;
            if(arr[i] < arr[i+1]){
                small = arr[i];
                big = arr[i+1];
            }else {
                small = arr[i+1];
                big = arr[i];
            }

            for (int j = i+1; j < n; j++) {
                if(small > arr[j]){
                    small = arr[j];
                }
                if(arr[j] > big){
                    big = arr[j];
                }
                sum += (big-small);

            }

        }

        System.out.println(sum);
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l1);

    }

}
