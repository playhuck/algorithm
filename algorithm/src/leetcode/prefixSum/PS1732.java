package leetcode.prefixSum;

public class PS1732 {
    public int largestAltitude(int[] gain) {

        int[] sums = new int[gain.length + 1];
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < sums.length; i ++) {

            if(i == 0) {
                sums[i] = 0;
            } else {

                sum = sum + gain[i - 1];
                sums[i] = sum;
            }

            max = Math.max(max, sum);
        }

        return max;

    }
}
