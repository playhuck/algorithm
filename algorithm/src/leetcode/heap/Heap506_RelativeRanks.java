package leetcode.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Heap506_RelativeRanks {
     /*
        크기가 n인 정수 배열 score가 주어지며,
        score[i]는 대회에서 i번째 선수의 점수입니다.
        모든 점수는 고유함이 보장됩니다.
        선수들은 그들의 점수를 기반으로 순위가 매겨지며, 1등 선수는 가장 높은 점수를,
        2등 선수는 2번째로 높은 점수를 가지는 식입니다. 각 선수의 순위는 다음과 같이 결정됩니다:

        1등 선수의 순위는 "Gold Medal"입니다.
        2등 선수의 순위는 "Silver Medal"입니다.
        3등 선수의 순위는 "Bronze Medal"입니다.
        4등부터 n등까지의 선수들의 순위는 그들의 등수 숫자입니다 (즉, x등 선수의 순위는 "x"입니다).

        크기가 n인 배열 answer를 반환하세요. 여기서 answer[i]는 i번째 선수의 순위입니다.
     */

    public static String[] findRelativeRanks(int[] score) {

        int len = score.length;

        String[] list = new String[len];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {

            int greater = 0;
            int less = 0;

            for (int k : score) {

                if (score[i] > k) {
                    greater++;
                } else {
                    less ++;
                }
            }

            if(greater == len - 1) {
                list[i] = "Gold Medal";
            } else if (greater == len - 2) {
                list[i] = "Silver Medal";
            } else if (greater == len - 3) {
                list[i] = "Bronze Medal";
            } else {
                list[i] = String.valueOf(less);
            }

        }

        return list;
    }

    public String[] findRelativeRanks2(int[] score) {

        int len = score.length;

        String[] list = new String[len];

        Integer[] copyScore = new Integer[len];
        for (int i = 0; i < len; i++) {
            copyScore[i] = score[i];
        }

        Arrays.sort(copyScore, Collections.reverseOrder());

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < copyScore.length; i++) {
            map.put(copyScore[i], i);
        }

        for (int i = 0; i < len; i++) {

            if(map.get(score[i]) == 0) {
                list[i] = "Gold Medal";
            } else if(map.get(score[i]) == 1) {
                list[i] = "Silver Medal";
            } else if(map.get(score[i]) == 2) {
                list[i] = "Bronze Medal";
            } else {
                list[i] = String.valueOf(map.get(score[i]) + 1);
            }
        }

        return list;
    }
}
