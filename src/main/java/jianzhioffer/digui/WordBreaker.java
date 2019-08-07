package jianzhioffer.digui;

import java.util.Set;

/**
 * created by reedfan on 2019/5/27 0027
 * https://www.programcreek.com/2012/12/leetcode-solution-word-break/
 * https://www.cnblogs.com/grandyang/p/4257740.html
 *
 *
 *
 */
public class WordBreaker {



    public boolean wordBreaker(String str,Set<String> dict){
        return wordBreakerHelper(str,dict,0);
    }

    public boolean wordBreakerHelper(String str,Set<String> dict,int start){
        if(start == str.length()){
            return true;
        }
        for(String a:dict){
            int len = a.length();
            int end = start+len;
            if(end>str.length()){
                continue;
            }
            if(str.substring(start,start+len).equals(a)){
                if(wordBreakerHelper(str,dict,start+len)){
                    return true;
                }
            }

        }

        return false;
    }

}
