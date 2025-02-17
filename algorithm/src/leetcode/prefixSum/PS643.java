package leetcode.prefixSum;

public class PS643 {
    public double findMaxAverage(int[] nums, int k) {

        System.out.println(nums.length + " " + k);

        int len = nums.length;
        if(len == 1) {
            return (double) nums[0];
        }
        int[] sums = new int[len];

        int sum = 0;
        for(int i = 0; i < nums.length; i ++) {

            sum = nums[i] + sum;
            sums[i] = sum;
        }

        double max = (double) Integer.MIN_VALUE;

        for(int i = 0; i <= len - k; i ++) {

            if(i == 0) {

                double average = (double) (sums[i + (k - 1)]) / k;

                max = Math.max(average, max);
            } else {

                double average = ((double) sums[i + (k - 1)] - sums[i - 1] ) / k;
                max = Math.max( average, max) ;
            }
        }

        return max;
    }
}
