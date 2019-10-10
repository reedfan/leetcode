package leetcode.array;

import java.util.Stack;

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N085maximalRectangle {


    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }

        int[][] arr = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix[0].length ; i++) {
            if(matrix[0][i] == '1'){
                arr[0][i] = 1;
            }
        }
        if(matrix.length == 1){
            return largestRectangleArea(arr[0]);
        }



        for (int i = 1; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1'){
                    arr[i][j] = arr[i-1][j] +  1;

                }else {
                    arr[i][j] = 0;
                }

            }

        }
        int max = 0;
        for (int i = 0; i < arr.length ; i++) {
            max = max > largestRectangleArea(arr[i])?max : largestRectangleArea(arr[i]);

        }


        return max;
    }

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
