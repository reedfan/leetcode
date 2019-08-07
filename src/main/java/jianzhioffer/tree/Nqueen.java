package jianzhioffer.tree;

import org.junit.Test;

public class Nqueen {

    @Test
    public void test(){
        System.out.println(num(4));

    }


    public int num(int n){
        if(n < 1){
            return 0;
        }
        int[] record = new int[n];
        return process(0,record,n);
    }


    //record[i]表示第行皇后所在的列
    public int process(int i, int[] record, int n){

        //终止条件
        if(i==n){
            return 1;
        }
        int res = 0;
        //看每一列是否符合条件
        for (int j = 0; j < n ; j++) {
            if (isValid(record,i,j)){
                record[i] = j;
                res += process(i+1, record, n);
            }

        }
        return res;

    }


    public boolean isValid(int[] record,int i,int j){
        for (int k = 0; k <i; k++) {
            //i+j == k+record[k];    j-i = record[k]-k
            if(j == record[k] || Math.abs(record[k] -j) == Math.abs(i-k)){
                return false;
            }

        }
        return true;
    }


}
