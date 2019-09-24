package jianzhioffer;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Author 范群松.
 * Date：2018/8/19
 * Time: 10:16
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
 */

public class N32PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        if(numbers.length == 0){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, new Comparator<String>() {
            public int compare(String o1, String o2) {
                String c1 = o1 + o2;
                String c2 = o2 + o1;
                return c1.compareTo(c2);
            }
        });
        for (int i = 0; i < numbers.length; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
