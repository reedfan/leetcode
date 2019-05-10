package jianzhioffer.tree;

public class IsHouXuSouSuo {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null ||sequence.length == 0){
            return false;
        }
        return isHouXuSouSuo(sequence,0,sequence.length-1);

    }

    private static boolean isHouXuSouSuo(int[] sequence, int start, int end) {
        //递归终止条件
        if(start>=end){
            return true;
        }
        int i = start;
        while (sequence[i]<sequence[end]){
            i++;
        }
        for (int j = i; j < end ; j++) {
            if(sequence[j]<sequence[end]){
                return false;

            }

        }
        return isHouXuSouSuo(sequence,start,i-1)&&isHouXuSouSuo(sequence,i,end-1);

    }

}
