package jianzhioffer.dianxin;

import java.util.*;

/**
 * Author 范群松.
 * Date：2018/9/10
 * Time: 9:23
 */

public class Main {
    private static void findStr(String str){
        char[] ch = str.toCharArray();
        int number = Integer.MAX_VALUE;
        Map<Character,Integer> map = new TreeMap<Character,Integer>();
        for (int i = 0; i < ch.length; i++) {
            Integer aa = map.get(ch[i]);
            map.put(ch[i], (aa==null)?1:aa+1);
        }

        List<Character> list = new ArrayList<Character>();
        for (int i = 0; i < ch.length; i++) {
            if(map.get(ch[i]) < number){
                number = map.get(ch[i]);
                list.clear();
                list.add(ch[i]);
            }else if(map.get(ch[i]) == number){
                list.add(ch[i]);
            }
        }
        for (char c : list) {
            str = str.replace(String.valueOf(c), "");
        }
        System.out.println(str);

    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String str=sc.nextLine();
            if(str.length()>100){
                continue;
            }
            findStr(str);

        }
    }
}
