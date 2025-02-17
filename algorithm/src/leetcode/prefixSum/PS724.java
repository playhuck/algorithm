package leetcode.prefixSum;

public class PS724 {
    public int pivotIndex(int[] nums) {

        int len = nums.length;
        if(len == 1) {
            return 0;
        }

        int leftSum = 0;
        int rightSum = 0;

        int[] leftSums = new int[len];
        int[] rightSums = new int[len];

        for(int i = 0; i < len; i ++) {

            leftSum = leftSum + nums[i];
            leftSums[i] = leftSum;

            rightSum = rightSum + nums[len - 1 - i];
            rightSums[len - 1 - i] = rightSum;
        }

        int l = 0;

        // 왼쪽이나 오른쪽이 없다면 0으로 취급한다.

        while(l < len) {

            int lSum;
            if(l > 0) {
                lSum = leftSums[l - 1];
            } else {
                lSum = 0;
            }

            int rSum;
            if(l < len - 1) {
                rSum = rightSums[l + 1];
            } else {
                rSum = 0;
            }

            if(lSum == rSum) {
                return l;
            }

            l ++;
        }


        return -1;

    }
}
