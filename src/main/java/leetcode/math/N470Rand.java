package leetcode.math;

import java.util.Random;

public class N470Rand {
    public int rand10() {
        while (true){
            int num = (rand7()-1)*7 + rand7()-1;
            if(num < 40){
                return num%10+1;
            }
        }

    }

    private int rand7(){
        return new Random().nextInt(7);
    }
}
