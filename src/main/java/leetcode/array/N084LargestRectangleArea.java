package leetcode.array;

import java.util.Stack;

public class N084LargestRectangleArea {
    public static void main(String[] args) {
        int[] nums = {2,1,5,6,2,3};
        int res = new N084LargestRectangleArea().largestRectangleArea(nums);
        System.out.println(res);
    }

    /*
    本题其实可以这么算。对于nums = {2,1,5,6,2,3};
    2*1，1*6，5*2，6*1，2*4，3*1的最大值，即为柱形图的最大面积。
    高度我们很容易知道，但是宽度怎么计算呢？宽度其实就是从当前位置向左右两边扩散。找到比自己小的或者到达边界截止。
    我们可以借用一个栈stack来完成这个功能。stack中的位置对于nums的值保持严格递增。
    首先位置0进栈，stack = {0};
    然后位置1要进栈的话，显然就不满足递增的条件了。栈里面的数需要出栈，一直到栈为空栈顶小于等于待入栈的值为止。这样做有什么好处？
    首先，我们已经知道了栈顶的在nums的值比待入栈位置在nums的值小。又因为栈里面位置在nums的值是严格递增的。
    因为栈是严格递增的。所以弹出某个数的时候，剩余的栈顶就是其左边界的前一位。而待入栈的数就是其右边界。
    因此。如果stack不为空，宽度width = i-stack.peek()-1，如果为空的话。宽度为i。




     */

    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        //保证stack中对应的位置在height中递增。
        Stack<Integer> stack = new Stack<>();
        int maxValue = 0;
        int width;
        int top;
        for (int i = 0; i < heights.length; i++) {
            //因为stack是递增的，因此比栈顶大的话可以直接入栈
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i]){
                stack.push(i);
            }else {
                //不然的话就出栈，算出以当前值为结尾的情况下的面积
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    top = stack.pop();
                    if(stack.empty()){
                        width = i;
                    }else {
                        width = i-stack.peek()-1;   //i是右边能到达的位置，stack.peek()是左边的位置，因此宽度为i-stack.peek()-1
                    }


                    maxValue = Math.max(maxValue,(width)*heights[top]);
                }
                stack.push(i);
            }

        }
        while (!stack.isEmpty()){
            top = stack.pop();
            if(stack.empty()){
                width = heights.length;
            }else {
                width = heights.length-stack.peek()-1;
            }
            maxValue = Math.max(maxValue,width*heights[top]);
        }
        return maxValue;
    }
}
