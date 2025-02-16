package leetcode.two_pointer;

public class TP283 {
    public void moveZeroes(int[] nums) {

        int p1 = 0;
        int p2 = 0;

        while(p2 < nums.length) {

            if(nums[p2] != 0) {
                int tmp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2] = tmp;
                p1 ++;
            }
            p2 ++;
        }
    }
}
