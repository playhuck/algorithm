package leetcode.two_pointer;

import java.util.HashMap;
import java.util.Map;

public class TP51 {
    public int maxOperations(int[] nums, int k) {

        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i ++) {

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(int i = 0; i < nums.length; i ++) {

            int cur = nums[i];
            int cal = Math.abs(k - cur);
            if (cur < k) {
                if(map.containsKey(cal)) {
                    if(map.get(cal) > 0) {
                        if(map.get(cal) == 1 && cal == cur) {
                            continue;
                        } else {
                            if(map.get(cal) > 0 && map.get(cur) > 0) {
                                result ++;
                                map.put(cal, map.get(cal) - 1);
                                map.put(cur, map.get(cur) - 1);
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}
