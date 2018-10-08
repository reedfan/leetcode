package jianzhioffer.putong;


import java.util.Map;
import java.util.Scanner;

import java.util.HashMap;
import java.util.Iterator;



public class Zoom {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        int num[] = new int[n];
        for (int i = 0; i <n; i++) {
            num[i]=scanner.nextInt();
        }
        Map<Integer,Integer> map  = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            if(map.containsKey(num[i])){
                int count = map.get(num[i]);
                count++;
                map.put(num[i],count);
            }else {
                map.put(num[i],1);
            }
        }
        int jishu = 0;
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            Integer key = (Integer)entry.getKey();
            Integer value = (Integer)entry.getValue();

            if(value == 1){
                System.out.println(key);
                jishu++;

                break;
            }

        }
        if(jishu == 0){
            System.out.println("No");
        }
    }

}