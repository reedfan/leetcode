package jianzhioffer.putong;

import java.util.Random;

/**
 * Author 范群松.
 * Date：2018/8/23
 * Time: 20:11
 */

public class BubbleSort {
    public static void main(String[] args) {
        Random random = new Random(5);
        int[] score = new int[5];
        for (int i = 0; i < 5; i++) {
            score[i] = random.nextInt(100);
        }
        for (int i = 0; i < score.length-1; i++) {
            for (int j = 0; j < score.length-1-i; j++) {
                if(score[j] > score[j+1]){
                    int temp = score[j];
                    score[j] = score[j+1];
                    score[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < score.length; i++) {
            System.out.println(score[i]);
        }

    }
}
