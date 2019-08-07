package jianzhioffer.putong;

/**
 * https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8?tpId=13&tqId=11203&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */

public class Duplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || numbers.length < 2 || length <2){
            return false;
        }

        for (int i = 0; i < length; i++) {
            while (numbers[i] != i){
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }else {
                    swap(numbers,i,numbers[i]);

                }
            }

        }
        return false;

    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
