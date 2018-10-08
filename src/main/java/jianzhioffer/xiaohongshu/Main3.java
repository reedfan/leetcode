package jianzhioffer.xiaohongshu;

import java.util.Scanner;

/**
 * Author 范群松.
 * Date：2018/9/18
 * Time: 19:10
 */

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int num = in.nextInt();
            System.out.println(fun(num));

        }
    }

    private static int fun(int n) {
        if (n <= 0) {
            return 0;
        }
        int tmp = 1;
        int sum = 0;
        while(n / tmp != 0) {
            int num1 = n - n / tmp * tmp;
            int num2 = (n / tmp) % 10;
            int num3 = n / (tmp * 10);

            if (num2 == 0) {

                sum += num3 * tmp;
            } else if (num2 == 1) {

                sum += num3 * tmp + num1 + 1;
            } else {

                sum += (num3 + 1) * tmp;
            }
            tmp *= 10;
        }
        return sum;
    }
}
