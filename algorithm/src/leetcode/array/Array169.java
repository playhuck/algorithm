package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class Array169 {
    class Solution {
        public int majorityElement(int[] nums) {

            int result = Integer.MIN_VALUE;
            int max = Integer.MIN_VALUE;
            Map<Integer, Integer> map = new HashMap<>();

            for(int n : nums) {

                if(map.containsKey(n)) {
                    int get = map.get(n);
                    map.put(n, map.get(n) + 1);
                } else {
                    map.put(n, 1);
                }
            }

            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {

                int key = entry.getKey();
                int value = entry.getValue();

                max = Math.max(value, max);
                if(max == value) result = key;
            }

            return result;
        }
    }
}
