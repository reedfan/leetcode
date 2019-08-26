package jianzhioffer.dp.jingdianwenti;

public class Zcggzul {
//    https://www.nowcoder.com/questionTerminal/c996bbb77dd447d681ec6907ccfb488a
    //最长公共子序列不需要连续
    public static void main(String[] args) {

        String str1 = "1A2C3D4B56";
        String str2 = "B1D23CA45B6A";

        int m = str1.length()-1;
        int n = str2.length()-1;

        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();

        int[][] dp = getdp(chs1,chs2);


        char[] res = new char[dp[m][n]];

        int index = res.length-1;

        while (index >= 0){
            if(n > 0 && dp[m][n] == dp[m][n-1]){
                n--;
            }else {
                if(m > 0 && dp[m][n] == dp[m-1][n]){
                    m--;
                }else {
                    res[index--] = chs1[m];
                    m--;
                    n--;
                }
            }
        }

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);

        }
        System.out.println();
    }



    public static int[][] getdp(char[] str1,char[] str2){
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0]==str2[0]?1:0;
        for (int i = 1; i < str1.length ; i++) {
            dp[i][0] = Math.max(dp[i-1][0],str1[i] == str2[0]?1:0);
        }
        for (int i = 1; i < str2.length; i++) {
            dp[0][i] = Math.max(dp[0][i-1],str1[0] == str2[i]?1:0);
            
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if(str1[i] == str2[j]){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]+1);

                }
                
            }

        }
        return dp;


    }

}
