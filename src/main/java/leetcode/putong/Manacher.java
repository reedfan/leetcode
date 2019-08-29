package leetcode.putong;

public class Manacher {

    public int maxLcpsLength(String str){
        if(str == null ||str.length() == 0){
            return 0;
        }
        char[] charArr = manacherString(str);

        int len = charArr.length;
        //最近一个PR更新时，那个回文中心的位置。
        int index = -1;
        //之前遍历的所有的字符的所有回文半径中，最右即将到达的位置初始化为-1
        int pR = -1;
        //pArr[i]表示以i位置作为回文中心，阔出去能得到的最大的回文半径
        int[] pArr = new int[charArr.length];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i != len ; i++) {


        }

        return max-1;



    }



    public char[] manacherString(String str){
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length()*2+1];
        int index = 0;
        for (int i = 0; i != res.length ; i++) {
            res[i] = (i&1)==0?'#':charArr[index++];

        }
        return res;
    }





}
