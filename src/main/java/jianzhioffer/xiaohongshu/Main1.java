package jianzhioffer.xiaohongshu;

import java.util.Scanner;

/**
 * Author 范群松.
 * Date：2018/9/18
 * Time: 19:19
 * 字符串压缩
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while ((scanner.hasNext())){
            String str = scanner.nextLine();
            System.out.println(reedyasuo(str));
        }
    }
    private static String reedyasuo(String str){
        StringBuffer sb = new StringBuffer();

        int tmp = 1;
        int count = 1;
        while (tmp<str.length()){
            if(str.charAt(tmp) == str.charAt(tmp-1)){
                tmp++;
                count++;
            }else {
                sb.append(str.charAt(tmp-1));

                sb.append(count);
                count = 1;



            }
        }






        return sb.toString();
    }
}
