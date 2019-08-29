package leetcode.putong;

public class MaxOneBorderSize {
    public static int getMaxSize(int[][] m) {

        int[][] right = new int[m.length][m[0].length];
        int[][] down = new int[m.length][m[0].length];
        setBorderMap(m,right,down);
        return 0;



    }
    public static void setBorderMap(int[][] m, int[][] right, int[][] down) {

        int row = m.length;
        int col = m[0].length;
        if(m[row-1][col-1] == 1){
            right[row-1][col-1] = 1;
            down[row-1][col-1] = 1;
        }
        for (int i = row-2; i >=0 ; i--) {
            if(m[i][col-1]==1){
                right[i][col-1] = 1;
            }

        }

        for (int i = row-2; i >=0 ; i--) {
            for (int j = col-2; j >=0 ; j--) {
                if(m[i][j] == 1){
                    right[i][j] = right[i][j+1] +1;
                    down[i][j] = down[i+1][j]+1;
                }

            }

        }




    }
}
