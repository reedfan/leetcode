package leetcode.array;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "0011"
 * 输出: "10101"
 * <p>
 * 来源：力扣（LeetCode）   67
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N067AddBinary {
    public static void main(String[] args) {
        System.out.println(new N067AddBinary().addBinary("1", "1"));
    }

    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }
        int len = a.length() + 1;
        char[] newCharArray = new char[len];
        int flag = 0;
        int num = 0;
        int gap = a.length() - b.length();
        for (int i = a.length() - 1; i >= gap; i--) {
            num = flag + a.charAt(i) + b.charAt(i - gap) - '0' * 2;
            newCharArray[--len] = num % 2 == 0 ? '0' : '1';
            flag = num / 2;
        }
        for (int i = gap - 1; i >= 0; i--) {
            num = flag + a.charAt(i) - '0';
            newCharArray[--len] = num % 2 == 0 ? '0' : '1';
            flag = num / 2;
        }
        if (flag == 1) {
            newCharArray[0] = '1';
        }
        if (newCharArray[0] == '1') {
            return new String(newCharArray);
        }
        return new String(newCharArray, 1, a.length());

    }
}
