package leetcode.putong;

public class ZuiChangDiZengZiXulie {


    public static void main(String[] args) {
        int[] arr = {2,1,5,3,6,4,8,9,7};
        int[] dp = getdp1(arr);

        int[] lis = generateLIS(arr,dp);
        for (int i = 0; i < lis.length; i++) {
            System.out.println(lis[i]);

        }

    }

    public static int[] generateLIS(int[] arr,int[] dp){
        int len = arr.length;
        int max = Integer.MIN_VALUE;
        int pos = 0;
        for (int i = 0; i < len; i++) {
            if(dp[i]>max){
                max = dp[i];
                pos = i;
            }
        }
        int[] tmp = new int[max];

        tmp[max-1] = arr[pos];
        max--;

        for (int i = pos-1; i >=0 ; i--) {
            if(dp[i] == max){
                tmp[max-1] = arr[i];
                max--;

            }

        }
        return tmp;

    }



    /*
      获取最长递增子序列长度
     */

    public static int[] getdp1(int[] arr){
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }

            }
        }
        return dp;
    }
}
