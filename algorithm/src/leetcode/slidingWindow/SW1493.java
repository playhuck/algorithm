package leetcode.slidingWindow;

public class SW1493 {
    public int longestSubarray(int[] nums) {

        int len = nums.length;
        if(len == 1 && nums[0] == 0) {
            return 0;
        }

        int left = 0;
        int count = 0;

        int max = Integer.MIN_VALUE;

        for(int right = 0; right < len; right ++) {

            if(nums[right] == 0) {
                count ++;
            }

            while(count > 1) {

                if(nums[left] == 0) {
                    count --;
                }

                left ++;
            }

            max = Math.max(max, right - left + 1 - count);

        }

        return max == len ? max - 1 : max;

    }
}
