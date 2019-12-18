package leetcode.shuangzhizhen;

/**
 * created by reedfan on 2019/12/19 0019
 */
public class N011maxArea {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            int width = right - left;
            if (height[left] < height[right]) {
                res = res > height[left] * width ? res : height[left] * width;
                left++;
            } else {
                res = res > height[right] * width ? res : height[right] * width;
                right--;
            }
        }
        return res;

    }
}
