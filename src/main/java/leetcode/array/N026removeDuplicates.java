package leetcode.array;

public class N026removeDuplicates {

    /*
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

示例 1:

给定数组 nums = [1,1,2],

函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

你不需要考虑数组中超出新长度后面的元素。

示例 2:

给定 nums = [0,0,1,1,1,2,2,3,3,4],

函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

你不需要考虑数组中超出新长度后面的元素。

说明:

为什么返回数值是整数，但输出的答案是数组呢?

请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

你可以想象内部操作如下:

// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
int len = removeDuplicates(nums);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
for (int i = 0; i < len; i++) {
    print(nums[i]);
}

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        removeDuplicates(nums);
    }

    /*
    本题其实是一个很典型的双指针题。如果数组的长度小于2，直接返回数组的长度即可。
    我们在遍历过程中只需要指定两个变量，一个是遍历到了哪个位置ahead，另一个是最后存放最后无重复数组的最后的位置cur。
    当nums[ahead] != nums[cur]时表示nums[ahead]是可以加进最后无重复数组的，反之，则不能加入。
    最后返回的数组的长度即为cur+1
    对于nums={1,2,2,3,3,3},其过程如下图所示。

     */
    public static int removeDuplicates(int[] nums) {
        assert nums != null;
        if(nums.length < 2){
            return nums.length;
        }
        int cur = 0;
        int ahead = 1;
        while(ahead < nums.length){
            if(nums[ahead] != nums[cur]){
                nums[++cur] = nums[ahead];
            }
            ahead ++;
        }
        return ahead;

    }
}
