package leetcode.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Sort2465_NumberOfDistinctAverages {
    /*
        0부터 시작하는 짝수 길이의 정수 배열 nums가 주어집니다.
        nums가 비어있지 않은 한, 다음을 반복적으로 수행해야 합니다:

        nums에서 최소값을 찾아 제거합니다.
        nums에서 최대값을 찾아 제거합니다.
        제거된 두 수의 평균을 계산합니다.

        두 수 a와 b의 평균은 (a + b) / 2입니다.

        예를 들어, 2와 3의 평균은 (2 + 3) / 2 = 2.5입니다.

        위 과정을 사용하여 계산된 서로 다른 평균들의 개수를 반환하세요.
        참고: 최소값이나 최대값이 여러 개일 경우, 그 중 어느 것을 제거해도 됩니다.
     */

    public static int distinctAverages(int[] nums) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Map<Float, Integer> distinct = new HashMap<>();

        while (!map.isEmpty()) {

            int max = map.lastKey();
            int min = map.firstKey();

            float average = (float) (max + min) / 2;

            distinct.put(average, distinct.getOrDefault(average, 0) + 1);

            if(map.get(max) > 1) {
                map.put(max, map.get(max) - 1);
            } else {
                map.remove(max);
            }

            if(map.get(min) > 1) {
                map.put(min, map.get(min) - 1);
            } else {
                map.remove(min);
            }

        }

        return distinct.size();

    }
}
