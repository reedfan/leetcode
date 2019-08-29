package leetcode.putong;

public class UglyNumber {

    public static void main(String[] args) {
        System.out.println(uglyNumber(7));
    }

    private static int uglyNumber(int n){

        int[] help = new int[n];
        help[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int index = 1;
        while (index<n){
            help[index] = Math.min(2*help[i2],Math.min(3*help[i3],5*help[i5]));
            if(help[index] == 2*help[i2]){
                i2++;
            }
            if(help[index] == 3*help[i3]){
                i3++;
            }
            if(help[index] == 5*help[i5]){
                i5++;
            }
           index++;
        }

        return help[n-1];


    }

}
