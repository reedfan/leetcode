package leetcode.array;

import java.util.Stack;

public class N084LargestRectangleArea {
    public static void main(String[] args) {
        int[] nums = {4,0,3,2,5};
        new N084LargestRectangleArea().largestRectangleArea(nums);
    }
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int maxValue = 0;
        int num;
        int top;
        for (int i = 0; i < heights.length; i++) {
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i]){
                stack.push(i);
            }else {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    top = stack.pop();
                    if(stack.empty()){
                        num = i;
                    }else {
                        num = i-stack.peek()-1;
                    }


                    maxValue = Math.max(maxValue,(num)*heights[top]);
                }
                stack.push(i);
            }

        }
        while (!stack.isEmpty()){
            top = stack.pop();
            if(stack.empty()){
                num = heights.length;
            }else {
                num = heights.length-stack.peek()-1;
            }
            maxValue = Math.max(maxValue,num*heights[top]);
        }
        return maxValue;
    }
}
