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
                        /*
                            value들을 먼저 비교합니다
                            결과값: a가 작으면 음수, 같으면 0, a가 크면 양수
                         */
                        int comparison = a.getValue().compareTo(b.getValue());
                        /*
                            value가 다르면(comparison != 0) comparison 값을 반환해 value 기준 정렬
                            value가 같으면(comparison == 0) key들을 비교
                            b.getKey()가 앞에 있어서 key는 내림차순 정렬
                         */
                        return comparison != 0 ? comparison : b.getKey().compareTo(a.getKey());
                    })
                    .mapToInt(Map.Entry::getKey)
                    .toArray();
        }
    }

}
