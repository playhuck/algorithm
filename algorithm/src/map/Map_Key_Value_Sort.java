package map;

import java.util.LinkedHashMap;
import java.util.Map;

public class Map_Key_Value_Sort {

    class Solution {
        public int[] solution(int[] numlist, int n) {

            int[] answer = new int[numlist.length];

            if (n == numlist[0]) {
                return numlist;
            }

            Map<Integer, Integer> numMap = new LinkedHashMap<>();

            for (Integer i : numlist) {
                numMap.put(i, Math.abs(i - n));
            }

            return numMap.entrySet().stream()
                    .sorted((a, b) -> {
                        int comparison = a.getValue().compareTo(b.getValue());
                        return comparison != 0 ? comparison : b.getKey().compareTo(a.getKey());
                    })
                    .mapToInt(Map.Entry::getKey)
                    .toArray();
        }
    }

}
