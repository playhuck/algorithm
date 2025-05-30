package leetcode.slidingWindow;

public class SW209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {

        if(nums.length == 0) return 0;

        if(nums.length == 1) {
            if(nums[0] >= target) return 1;
            else return 0;
        }

        int sum = 0, left = 0, min = Integer.MAX_VALUE;

        for(int right = 0; right < nums.length; right ++) {

            sum += nums[right];

            while(sum >= target) {
                min = Math.min(right - left + 1, min);
                sum -= nums[left];
                left ++;
            }
        }

        if(min == Integer.MAX_VALUE) min = 0;

        return min;
    }
}
