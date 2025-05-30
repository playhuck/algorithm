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

    /*
        길이가 n인 정수 배열 height가 주어집니다. n개의 수직선이 그려져 있으며,
        i번째 선의 두 끝점은 (i, 0)과 (i, height[i])입니다.
        x축과 함께 용기를 형성하는 두 선을 찾되, 이 용기가 가장 많은 물을 담을 수 있어야 합니다.
        용기가 담을 수 있는 최대 물의 양을 반환하세요.
        주의 용기를 기울일 수 없습니다.

        1. 투포인터 접근
        2. 배열의 인덱스 중 두 값을 선택해 가장 많은 물을 채워야 한다.
        3. 가장 많은 물을 채우려면 큰 값 두개를 골라야 한다.
            3-1. 큰 값 두개를 골랐다고 해서, 가장 많은 물을 채울 수 있는 것은 아니다.
            3-2. 총 넓이의 합까지 봐야 한다.
             - 일단 넓이를 구하는 공식부터 계산한다. 두 인덱스의 length가 9인 배열에서 인덱스 8과 인덱스 1 8 - 1 * (두 값 중 작은 값 7 ) = 49
     */
    public int maxArea3(int[] height) {

        if(height.length < 2) return 0;

        // (left - right) * (Math.min(max, subMax)

        int left = 0;
        int right = height.length - 1;
        int max = Integer.MIN_VALUE;

        while (left < right) {

            int n = (right - left) * (Math.min(height[left], height[right]));

            if(n > max) max = n;

            if(height[left] < height[right]) left ++;
            else right --;

        }

        return max;

    }
}
