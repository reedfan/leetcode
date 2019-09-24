package leetcode.string;

/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如，
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "A"
 * <p>
 * 示例 2:
 * <p>
 * 输入: 28
 * 输出: "AB"
 * <p>
 * 示例 3:
 * <p>
 * 输入: 701
 * 输出: "ZY"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N168convertToTitle {

    public static void main(String[] args) {
        String res = new N168convertToTitle().convertToTitle(52);
        System.out.println(res);
    }

    // TODO: 2019-09-24  
    public String convertToTitle(int n) {
        StringBuffer res = new StringBuffer();

        while (n > 26) {
            int tmp = (n-1) / 26;

            res.append((char)(tmp+64));
            n = n % 26;
        }
        res.append((char)(n+64));
        return res.toString();

    }
}
