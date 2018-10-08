package jianzhioffer.putong;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Author 范群松.
 * Date：2018/8/27
 * Time: 20:21
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 */

public class Solution30 {
    public int MoreThanHalfNum_Solution(int [] array) {

        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            if(map.containsKey(array[i])){
                int count = map.get(array[i]);
                map.put(array[i],++count);
            }else {
                map.put(array[i],1);
            }
        }
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            Integer val = (Integer)entry.getValue();
            Integer key = (Integer)entry.getKey();
            if(val>array.length/2){
                return key;
            }

        }
        return 0;
    }
}
