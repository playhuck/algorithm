package leetcode.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Map128_LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        if(nums.length == 0) return 0;

        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();

        int max = Integer.MIN_VALUE;

        for(int num : nums) {

            if(map.containsKey(num - 1)) {

                int befSequence = map.get(num - 1);
                map.put(num, befSequence + 1);
                max = Math.max(befSequence + 1, max);
            } else {
                map.put(num, 1);
                if(max == Integer.MIN_VALUE) max = 1;
            }
        }

        return max;

    }

    public int longestConsecutive2(int[] nums) {

        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;

        Arrays.sort(nums);

        int max = Integer.MIN_VALUE;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int bef = nums[i - 1];

            if(cur > bef + 1) {
                max = Math.max(count, max);
                count = 1;
            } else {

                if(cur == bef) continue;
                count++;
            }
        }

        max = Math.max(count, max);

        return max;

    }

    public int longestConsecutive3(int[] nums) {

        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;

        Arrays.sort(nums);

        int max = Integer.MIN_VALUE;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int bef = nums[i - 1];

            if(cur > bef + 1) {
                max = Math.max(count, max);
                count = 1;
            } else {

                if(cur == bef) continue;
                count++;
            }
        }

        max = Math.max(count, max);

        return max;

    }

}
