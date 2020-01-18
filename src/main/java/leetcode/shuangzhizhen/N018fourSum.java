package leetcode.shuangzhizhen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by reedfan on 2020/1/8 0008
 */
public class N018fourSum {
    /*
本题最容易想到的方法应该就是暴力破解，但是靠暴力破解的话时间复杂度会到 O(n^4)，面试中显然不能让面试官满意。
采取如下方式可以将时间复杂度优化为 O(n^3)。
首先对数组进行排序，排序的时间复杂度 O(nlogn)。
在数组 nums 中，进行遍历，每遍历一个值取其下标first，形成一个固定值 nums[first]。first的取值范围应该是[0,second < length - 3)
紧接着可以取第二个数nums[second]，second的取值范围应该是[first + 1,second < length - 2)
再使用左指针 third = second + 1 ，右指针 fourth = nums.length - 1 。
根据 sum = nums[first] + nums[second] + nums[third]+ nums[fourth] 的结果，
并判断 sum 与 target 的大小关系，因为数组有序，如果 sum == target ，则表明其实一组解，如果 sum < target 则 third++，
如果 sum > target 则 fourth--。
整个遍历过程时间复杂度为 O(n^3)
因此总时间复杂度：O(n^3)。

此外，还存在一些可优化的空间和一些需要注意的地方。
如果nums[i] > 0，因为数组有序，则后面的数肯定也都大于0，因此不可能找到三个数的何为0，可以直接结束循环了。
还要注意去重。本题是求四数之和。对于第一个数，如果nums[first] == nums[first - 1]，这种算是重复计算了。同理注意后面三个数也要考虑这种情况。
可以优化的点在于nums[first] + nums[first + 1] + nums[first + 2] + nums[first + 3]其实表示最小的和，如果其结果>target,
其他的结果肯定也大于target，可以提前结束循环，可以理解为剪枝。具体细节见代码。
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        /*定义4个指针first，second，third，fourth  first从0开始遍历，second从first+1开始遍历，third指向second+1，fourth指向数组最后一个数*/
        for (int first = 0; first < length - 3; first++) {
            /*当first的值与前面的值相等时忽略*/
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            int min1 = nums[first] + nums[first + 1] + nums[first + 2] + nums[first + 3];
            if (min1 > target) {
                break;
            }
            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            int max1 = nums[first] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (max1 < target) {
                continue;
            }
            /*第二层循环second，初始值指向first+1*/
            for (int second = first + 1; second < length - 2; second++) {
                /*当second的值与前面的值相等时忽略*/
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                /*定义指针third指向second+1*/
                int third = second + 1;
                /*定义指针fourth指向数组末尾*/
                int fourth = length - 1;
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，剪枝操作*/
                int min2 = nums[first] + nums[second] + nums[third] + nums[third + 1];
                if (min2 > target) {
                    continue;
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，剪枝操作*/
                int max2 = nums[first] + nums[second] + nums[fourth] + nums[fourth - 1];
                if (max2 < target) {
                    continue;
                }
                /*开始third指针和fourth指针的表演，计算当前和，如果等于目标值，third++并去重，fourth--并去重，当当前和大于目标值时fourth--，当当前和小于目标值时third++*/
                while (third < fourth) {
                    int curr = nums[first] + nums[second] + nums[third] + nums[fourth];
                    if (curr == target) {
                        result.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
                        third++;
                        while (third < fourth && nums[third] == nums[third - 1]) {
                            third++;
                        }
                        fourth--;
                        while (third < fourth && nums[fourth] == nums[fourth + 1]) {
                            fourth--;
                        }
                        continue;
                    }
                    if (curr > target) {
                        fourth--;
                    } else {
                        third++;
                    }
                }
            }
        }
        return result;
    }

}
