package jianzhioffer.huadongchuangkou;

public class IsAnagram {
    public boolean isAnagram(String s, String p) {
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) {
            return false;
        }
        int len = p.length();
        int[] tmp = new int[26];
        int[] windonw = new int[26];

        for (int i = 0; i < len; i++) {
            tmp[p.charAt(i) - 'a']++;        // 记录p串有哪些字符
            windonw[s.charAt(i) - 'a']++;
        }
        int l = 0;
        int r = len;
        while (r < s.length()) {
            if (cmp(windonw, tmp)) {
                return true;
            }
            windonw[s.charAt(r++) - 'a']++;
            windonw[s.charAt(l++) - 'a']--;

        }
        if (cmp(windonw, tmp)) {    //末尾的那个
            return true;
        }
        return false;

    }


    private boolean cmp(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }

        }
        return true;
    }
}
