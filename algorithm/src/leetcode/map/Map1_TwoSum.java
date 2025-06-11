package leetcode.map;

import java.util.*;

public class Map1_TwoSum {
    public int[] twoSum(int[] nums, int target) {

        int len = nums.length;

        for(int x = 0; x < len; x ++) {

            int numX = nums[x];

            for(int y = x + 1; y < len; y ++) {

                int numY = nums[y];
                int sum = numX + numY;

                if(sum == target) {
                    return new int[]{x, y};
                }
            }
        }

        return new int[]{0, 1};

    }

    public int[] twoSum2(int[] nums, int target) {

        int len = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        /*
            int n = target - nums[i]
            해서 n과 같은 값이 나오면 i와 n을 리턴함
         */

        for(int x = 0; x < len; x ++) {

            int diff = target - nums[x];
            if(map.containsKey(nums[x])) {
                return new int[]{map.get(nums[x]), x};
            }

            map.put(diff, x);

        }

        return new int[]{0, 1};

    }
}
