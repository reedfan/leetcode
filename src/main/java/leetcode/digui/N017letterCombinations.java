package leetcode.digui;

import java.util.ArrayList;
import java.util.List;

public class N017letterCombinations {
    String[] telMap = {"_","!@#","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> res = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return res;
        }
        process(digits, "", 0);

        return res;

    }

    private void process(String digits, String letter, int index){
        if(index == digits.length()){
            res.add(letter);
            return;
        }
        String str = telMap[digits.charAt(index)-'0'];
        for(int i = 0; i < str.length(); i++){
            process(digits,letter+str.charAt(i),index+1);
        }
    }
}
