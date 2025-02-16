package leetcode.greedy;

public class Greedy334 {
    public boolean increasingTriplet(int[] nums) {
        boolean result = false;

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 1; i ++) {

            boolean isFind = false;
            for(int j = i + 1; j < nums.length; j ++) {

                if(nums[i] < nums[j]) {
                    isFind = true;
                    break;
                }
            }

            if(isFind && (nums[i] > min)) {
                return true;
            }

            min = Math.min(min, nums[i]);
        }

        return result;

    }

    public boolean increasingTriplet2(int[] nums) {
        boolean result = false;

        int len = nums.length;

        int min = Integer.MAX_VALUE;
        int[] minArr = new int[len];
        int max = Integer.MIN_VALUE;
        int[] maxArr = new int[len];

        for(int i = 0; i < len ; i ++) {

            int left = nums[i];
            int right = nums[len - 1 - i];

            min = Math.min(min, left);
            max = Math.max(max, right);

            minArr[i] = min;
            maxArr[len - 1 - i] = max;
        }

        for(int i = 0; i < len; i ++) {

            int currMin = minArr[i];
            int currMax = maxArr[i];

            if(nums[i] > currMin && nums[i] < currMax) {
                return true;
            }
        }
        return result;
    }
}
