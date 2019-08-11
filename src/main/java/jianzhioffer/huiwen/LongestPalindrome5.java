package jianzhioffer.huiwen;

public class LongestPalindrome5 {
    public static void main(String[] args) {
        System.out.println(new LongestPalindrome5().longestPalindrome("cbbd"));
    }
    public String longestPalindrome(String s) {

        if(s == null || s.length() == 0){
            return "";
        }
        int strLen = s.length();
        int left = 0;
        int right = 0;
        int len = 1;
        int maxstart = 0;
        int maxlen = 0;

        for(int i = 0;i<strLen;i++){
            left = i - 1;
            right = i + 1;
            while(left >= 0 && s.charAt(left) == s.charAt(i)){
                len++;
                left--;
            }
            while(right < strLen && s.charAt(right) == s.charAt(i)){
                len++;
                right++;
            }
            while(left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)){
                len = len + 2;
                left--;
                right++;
            }
            if(len > maxlen){
                maxlen = len;
                maxstart = left;
            }
            len = 1;
        }
        return s.substring(maxstart+1,maxstart+maxlen+1);

    }
}
