package jianzhioffer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class N11NumberOf1 {

    /*

    0111
  & 0110
    0110

    n  n-1


    0110
  & 0101
    0100


    0111  0110  去掉最后一个1
     */


    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }


    /*

    12 1

    10进制


    121 % 10 = 1

    121 / 10  = 12

     */



}
