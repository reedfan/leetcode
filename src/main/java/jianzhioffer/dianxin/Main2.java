package jianzhioffer.dianxin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author 范群松.
 * Date：2018/9/10
 * Time: 9:39
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            System.out.println(findLen(str1,str2));


    }

    private static int findLen(String str1,String str2){
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        List<Integer> res = new ArrayList<Integer>();

        int max = 0;
        int j = 0;
        for (int i = 0; i < str1.length(); i++) {
            int tmp = i;
            while (tmp<str1.length()&&j<str2.length()&& ch1[tmp] == ch2[j] ){
                j++;
                tmp++;
            }
            res.add(j);
            j=0;

        }
        for(Integer num:res){
            max = max>num?max:num;
        }
        return max;


    }


}
