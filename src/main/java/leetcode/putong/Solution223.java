package leetcode.putong;

import java.util.Scanner;

/**
 * Author 范群松.
 * Date：2018/8/20
 * Time: 21:07
 */

public class Solution223 {
    private static int num(int n) {
        if (n == 0) {
            return 0;
        }
        int[] numbers=new int[n+1];
        numbers[0]=0;
        numbers[1]=1;
        for (int i = 2; i <= n; i++) {
            numbers[i]=numbers[i-1]+numbers[i-2];
        }
        return numbers[n];
    }
    public static void main(String [] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        for (int i = 0; i <n; i++) {
            int month=scanner.nextInt();
            System.out.println(num(month));
        }
    }

}
