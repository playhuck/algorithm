package leetcode.array;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRoman {
    public String intToRoman(int num) {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        // while 문으로 1의 자리로 계속 %하면 될듯?

        int n = 10;
        int cal = num;
        StringBuilder output = new StringBuilder();

        while( cal > 0) {

            if(num == 0) break;

            int mod = cal % n;
            if(map.containsKey(mod)) {
                output.insert(0, map.get(mod));
            } else {

                int cal2 = mod;

                StringBuilder s = new StringBuilder();
                for(Map.Entry<Integer, String> entry : map.entrySet()) {

                    if(cal2 == 0) break;

                    if(entry.getKey() - cal2 > 0) continue;
                    else {

                        while(cal2 - entry.getKey() >= 0) {
                            s.append(entry.getValue());
                            cal2 = cal2 - entry.getKey();
                        }

                    }
                }
                output.insert(0, s.toString());

            }

            n *= 10;
            cal = cal - mod;
        }

        return output.toString();

    }
}
