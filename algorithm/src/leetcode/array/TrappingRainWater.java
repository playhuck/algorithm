package leetcode.array;

import java.util.Stack;

public class TrappingRainWater {

    // dp
    public int trap(int[] height) {

        int output = 0;
        int len = height.length;
        if(len <= 2) return 0;

        int[] leftMax = new int[len];
        leftMax[0] = height[0];
        for(int i = 1; i < len; i ++) {

            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[len];
        rightMax[len-1] = height[len-1];
        for(int i = len - 2; i >= 0; i --) {

            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for(int i = 0; i < len; i ++) {

            int waterHeight = Math.min(leftMax[i], rightMax[i]);
            if(waterHeight > height[i]) {

                output = output + (waterHeight - height[i]);
            }

        }

        return output;

    }

    // tp
    public int trap2(int[] height) {

        int output = 0;
        int len = height.length;
        if(len <= 2) return 0;

        int left = 0, right = len - 1;
        int leftMax = 0, rightMax = 0;

        while(left < right) {

            if(height[left] < height[right]) {

                if(height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    output += leftMax - height[left];
                }
                left ++;
            } else {

                if(height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    output += rightMax - height[right];
                }
                right --;
            }
        }

        return output;

    }

    public int trap3(int[] height) {

        int output = 0;
        int len = height.length;
        if(len <= 2) return 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < len; i ++) {

            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {

                int bottomIndex = stack.pop();

                if(stack.isEmpty()) break;

                int leftIndex = stack.peek();
                int width = i - leftIndex - 1;
                int waterHeight = Math.min(height[i], height[bottomIndex]) - height[bottomIndex];

                output += width * waterHeight;
            }

            stack.push(i);
        }

        return output;

    }
}
