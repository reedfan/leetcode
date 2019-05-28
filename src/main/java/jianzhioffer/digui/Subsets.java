package jianzhioffer.digui;

import java.util.ArrayList;
import java.util.List;

/**
 * created by reedfan on 2019/5/28 0028
 * https://blog.csdn.net/versencoder/article/details/52071930
 */
public class Subsets {

    static List<List<Integer>> result=new ArrayList<List<Integer>>();

    public static void main(String[] args) {
        combine(4,2);

    }
    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> list=new ArrayList<Integer>();
        backtracking(n,k,1,list);
        return result;
    }

    public static void backtracking(int n,int k,int start,List<Integer>list){
        if(k<0){
            return;
        }else {
            if(k==0){
                result.add(new ArrayList<>(list));
            }else {

                for (int i = start; i <=n ; i++) {
                    list.add(i);
                    backtracking(n,k-1,i+1,list);
                    list.remove(list.size()-1);

                }

            }

        }


    }


}
