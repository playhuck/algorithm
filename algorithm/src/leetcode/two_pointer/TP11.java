package leetcode.two_pointer;

import java.util.*;

public class TP11 {
    public int maxArea(int[] height) {

        int len = height.length;
        int result = Integer.MIN_VALUE;

        for(int i = 0; i < len; i ++) {

            for(int j = len - 1; j >= 0; j -- ) {

                int min = Math.min(height[i], height[j]);
                int minIndex = height[i] == min ? i : j;

                if(min <= height[i]) {
                    result = Math.max(result, (min * (j - i)));
                    if(height[i] > height[j]) {
                        continue;
                    } else {
                        break;
                    }
                }
            }
        }

        return result;

    }

    public int maxArea2(int[] height) {

        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;

        while(left < right) {

            max = Math.max(max, (Math.min(height[left], height[right]) * ( right - left) ));

            if(height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
        }

        return max;

    }
}
