package jianzhioffer.wangyi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Author 范群松.
 * Date：2018/9/20
 * Time: 20:22
 */

public class HHHH {
    public static void main(String[] args) {
        String str1;
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<String>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        while (!(str1 = in.next()).equals("END")) {
            list.add(str1);
            int n = Integer.valueOf(str1.split("#")[0]);
            String str2 = str1.split("#")[1];
            int result = Integer.parseInt(str2, n);
            if (map.get(result) == null) {
                map.put(result, 1);
            } else {
                map.put(result, map.get(result) + 1);
            }

        }

        int flag = 0;
        for (String s : list) {
            int n = Integer.valueOf(s.split("#")[0]);
            String m = s.split("#")[1];
            Integer result = Integer.parseInt(m, n);
            Integer res = map.get(result);
            if (res == 1) {
                System.out.println(s);
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("None");
        }
    }
}
