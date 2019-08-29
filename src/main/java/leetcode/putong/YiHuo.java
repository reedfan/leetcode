package leetcode.putong;

import org.junit.Test;

public class YiHuo {

    public static void main(String[] args) {
        System.out.println((3&1) ==1);
    }

    @Test
    public void test(){
       // System.out.println(hammingWeight(4));
        System.out.println(countBits(5));
    }


    public int hammingWeight(int n){
        int numberOfOne = 0;
        while (n !=0){
            numberOfOne++;
            n = n&(n-1);

        }
        return numberOfOne;
    }



    public int[] countBits(int num){
        int[] res = new int[num+1];
        for (int i = 1; i <= num ; i++) {
            res[i] = res[i&(i-1)]+1;
        }
        return res;
    }



}
