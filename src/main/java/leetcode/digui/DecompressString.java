package leetcode.digui;

public class
DecompressString {

    public static void main(String[] args) {
        String test1 = "3{a}2{bc}";
        String test2 = "3{a2{c}}";
        String test3 = "2{abc}3{cd}ef";
        System.out.println(decompress(test1));
        System.out.println(decompress(test2));
        System.out.println(decompress(test3));

    }
    public static String decompress(String decompressStr) {
        char[] chs = decompressStr.toCharArray();
        return process(chs, 0).str;
    }


    public static class ReturnData{
        public String str;
        public int end;

        public ReturnData(String str, int nextIndex) {
            this.str = str;
            this.end = nextIndex;
        }

    }


    public static ReturnData process(char[] chs,int index){
        StringBuilder sb = new StringBuilder();
        int times = 0;
        while (index<chs.length && chs[index] != '}'){
            if(chs[index] == '{'){
                ReturnData returnData = process(chs, index+1);
                sb.append(getTimesString(times,returnData.str));
                times = 0;
                index = returnData.end+1;
            }else {
                if(chs[index] >= '0' && chs[index] <= '9'){
                    times = times*10+chs[index]-'0';

                }
                if (chs[index] >= 'a' && chs[index] <= 'z') {
                    sb.append(String.valueOf(chs[index]));
                }
                index++;
            }
        }
        return new ReturnData(sb.toString(),index);


    }

    public static String getTimesString(int times,String base){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < times; i++) {
            res.append(base);
        }
        return res.toString();

    }


}
