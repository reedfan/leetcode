package leetcode.putong;

/**
 * Author 范群松.
 * Date：2018/8/25
 * Time: 13:42
 */

public class Solution29 {

    public static void main(String[] args) {
        int a[][] = new int[4][4];
        int b[][] = new int[4][4];
        int k = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                a[i][j] = k++;
            }

        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                b[3-j][i] = a[i][j];
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(b[i][j]);
            }
        }

    }







}
