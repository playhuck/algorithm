package leetcode.map;

import java.util.HashMap;
import java.util.Map;

public class Map219_ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0, numsLength = nums.length; i < numsLength; i++) {

            int num = nums[i];

            if (map.containsKey(num)) {

                if (Math.abs(map.get(num) - i) <= k) return true;
                else map.put(num, i);

            } else {

                map.put(num, i);
            }
        }

        return false;
    }

}
