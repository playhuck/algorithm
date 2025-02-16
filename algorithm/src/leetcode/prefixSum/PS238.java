package leetcode.prefixSum;

import java.util.Arrays;

public class PS238 {
    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        int[] answer = new int[len];
        Arrays.fill(answer, 1);

        int curr = 1;
        for(int i = 0; i < len ; i ++) {

            answer[i] *= curr;
            curr *= nums[i];
        }

        curr = 1;
        for(int i = len - 1; i >= 0; i --) {

            answer[i] *= curr;
            curr *= nums[i];
        }

        return answer;
    }
}
