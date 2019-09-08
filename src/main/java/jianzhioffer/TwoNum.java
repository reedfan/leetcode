package jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * created by reedfan on 2019/4/25 0025
 */
public class TwoNum {
    public static void main(String[] args) {
        int[] numbers = { 7,2, 11, 15};
        int[] twoSum = twoSum(numbers,9);
        System.out.println(twoSum[1]);

    }
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> hashMap = new HashMap<Integer, Integer>();

        for(int i = 0;i<numbers.length;i++){
            if(hashMap.containsKey(target-numbers[i])){
                if(numbers[i]<(target-numbers[i])){
                    res[0] = i;
                    res[1] = hashMap.get(target-numbers[i]);
                }else {
                    res[1] = i;
                    res[0] = hashMap.get(target-numbers[i]);
                }
                return res;

            }
            else{
                hashMap.put(numbers[i],i);
            }
        }
        return res;
    }
}
