package leetcode.array;

public class JumpGame {
    
    public boolean canJump(int[] nums) {

        int len = nums.length;
        int goal = len - 1;

        if(len == 1) {

            return true;
        }

        for(int i = len - 2; i >= 0; i -- ) {
            if(i + nums[i] >= goal) {
                goal = i;
            }
        }

        return goal == 0;

    }

    public boolean canJump2(int[] nums) {

        int len = nums.length;
        int max = 0;

        if(len == 1) {

            return true;
        }

        for(int i = 0; i < len; i ++ ) {

            if(i + nums[i] < max) {
                return false;
            }

            max = Math.max(max, i + nums[i]);

            if(max >= len - 1) return false;
        }

        return true;

    }

}
