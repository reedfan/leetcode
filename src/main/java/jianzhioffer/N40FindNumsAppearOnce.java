package jianzhioffer;

public class N40FindNumsAppearOnce {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array.length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
        }

        //得到异或的结果
        int res = 0;
        for (int num : array) {
            res = res ^ num;
        }
        //寻找异或结果第一个不一样的数
        int index = findFirst1(res);

        for (int num : array) {
            if (indexKIs1(num, index)) {
                num1[0] ^= num;

            } else {
                num2[0] ^= num;

            }
        }

    }

    private int findFirst1(int res) {
        int index = 0;
        while (index < 32 && (res & 1) == 0) {
            index++;
            res >>= 1;
        }
        return index;
    }

    private boolean indexKIs1(int num, int index) {
        return ((num >> index) & 1) == 1;
    }
}
