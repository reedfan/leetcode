package leetcode.dp;

public class N42Trap {
    public int trap1(int[] height) {
        if(height == null || height.length<3){
            return 0;
        }
        int sum = 0;

        for (int i = 1; i < height.length-1 ; i++) {
            int leftMax = height[i];
            for (int left = i-1;left>=0;left--){
                leftMax = leftMax>height[left]?leftMax:height[left];
            }
            int rightMax = height[i];
            for (int right = i+1; right < height.length ; right++) {
                rightMax = rightMax>height[right]?rightMax:height[right];
            }
            sum += Math.min(leftMax,rightMax)-height[i];

        }
        return sum;
    }

    public int trap2(int[] height) {
        if(height == null || height.length<3){
            return 0;
        }
        int sum = 0;
        //left[i]表示第i列左边的最高的列值,包含
        int[] left = new int[height.length];
        left[0] = height[0];

        for (int i = 1; i < height.length ; i++) {
            left[i] = left[i-1]>height[i]?left[i-1]:height[i];
        }

        int[] right = new int[height.length];
        right[height.length-1] = height[right.length-1];
        for (int i = height.length -2; i >=0 ; i--) {
            right[i] = right[i+1]>height[i]?right[i+1]:height[i];
        }
        for (int i = 1; i < height.length-1; i++) {
            sum += Math.min(left[i],right[i])-height[i];

        }
        return sum;

    }

}
