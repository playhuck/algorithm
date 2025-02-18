package leetcode.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Map1207 {
    public boolean uniqueOccurrences(int[] arr) {

        Arrays.sort(arr);

        if(arr.length == 1) return true;

        if(arr.length == 2) {
            return arr[0] == arr[1];
        }

        int equal = 0;

        Map<Integer, Integer> map = new HashMap<>();

        List<Integer> value = map.values();

        for(int i = 0; i < arr.length - 1; i ++) {

            if(arr[i] == arr[i + 1]) {
                equal ++;
            } else {
                if(map.containsKey(equal)){
                    return false;
                } else {
                    map.put(equal, 1);
                    equal = 0;
                }
            }
        }

        if(map.containsKey(equal)) return false;

        return true;

    }
}
