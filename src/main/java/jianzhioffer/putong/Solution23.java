package jianzhioffer.putong;

import java.util.HashSet;
import java.util.Set;

/**
 * Author 范群松.
 * Date：2018/8/17
 * Time: 21:44
 */

public class Solution23 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (length == 0){
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < length; i++) {
            Boolean bool = set.add(numbers[i]);
            if(! bool){
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;

    }
}
