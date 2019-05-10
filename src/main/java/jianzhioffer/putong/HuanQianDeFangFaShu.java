package jianzhioffer.putong;


public class HuanQianDeFangFaShu {

    public static void main(String[] args) {
        int[] arr = {5,10,25,1};
        System.out.println(coin3(arr,50));



    }

    /*
    普通解法
     */

    public int coins1(int[] arr,int aim){

        if(arr == null || arr.length == 0 || aim<0){
            return 0;
        }
        return process1(arr,0,aim);

    }
    private int process1(int[] arr,int index,int aim){
        int res = 0;
        if(index == arr.length){
            res = aim==0?1:0;
        }else {
            for (int i = 0; arr[index]*i <= aim ; i++) {
                res += process1(arr,index+1,aim-arr[index]*i);

            }
        }
        return res;

    }




    /*
    动态规划解法
     */
    public static int coin3(int[] arr,int aim){
        if(arr == null || arr.length == 0 || aim<0){
            return 0;
        }

        int[][] dp = new int[arr.length][aim+1];

        /**
         * dp[][0]组成钱数为0的方法数，很明显都是1种，也就是
         * 不使用任何货币
         */
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;

        }
        /**
         * dp[0][],只使用第一种货币的话，第一种货币的整数倍是1
         * 其他的为0
         */

        for (int i = 1; arr[0]*i <=aim ; i++) {
            dp[0][arr[0]*i] = 1;

        }

        int num = 0;
        for (int i = 1; i < arr.length ; i++) {
            for (int j = 1; j <=aim ; j++) {
                num = 0;
                /**
                 * 完全不用arr[i]货币，方法数为arr[i-1][j]
                 * 用一张arr[i],剩下的由arr[0...i-1]组成
                 *方法数为dp[i-1][j-n*arr[i]]

                 */
                for (int k = 0; k*arr[i] <= j ; k++) {
                    num += dp[i-1][j-arr[i]*k];

                }
                dp[i][j] = num;

            }

        }
        return dp[arr.length-1][aim];


    }


}
