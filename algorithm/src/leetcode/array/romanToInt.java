package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class romanToInt {
    public int romanToInt(String s) {

        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        int len = s.length();

        String[] chars = s.split("");

        int output = 0;

        for(int i = 0; i < len; i++) {

            if(i < len - 1 && map.get(chars[i + 1]) > map.get(chars[i])) {
                output += map.get(chars[i] + chars[i + 1]);
            } else {

                if(i > 0 && map.get(chars[i]) > map.get(chars[i - 1])) continue;

                output += map.get(chars[i]);
            }

        }

        return output;
    }
}
