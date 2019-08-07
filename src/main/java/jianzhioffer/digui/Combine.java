package jianzhioffer.digui;

import java.util.ArrayList;
import java.util.List;

public class Combine {

    private ArrayList<List<Integer>> res;
    // 求解C(n,k), 当前已经找到的组合存储在c中, 需要从start开始搜索新的元素
    private void generateCombinations(int n, int k, int start, List<Integer> list){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n ; i++) {
            list.add(i);
            generateCombinations(n,k,start+1,list);
            list.remove(list.size()-1);

        }
    }

    public List<List<Integer>> combine(int n, int k) {

        res = new ArrayList<>();
        if(n<=0 || k<=0 || k>n){
            return res;
        }
        List<Integer> list = new ArrayList<>();
        generateCombinations(n,k,1,list);

        return res;

    }
}
