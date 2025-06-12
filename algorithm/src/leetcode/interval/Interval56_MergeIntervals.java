package leetcode.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Interval56_MergeIntervals {

    /*
        각 구간별 겹치는 배열을 모두 병합해야 한다.
        [1, 3], [2, 6] => [1, 6]
        [1, 4], [4, 5] => [1, 5]
        그렇지 않은 배열들도 모두 병합한다.
     */
    public int[][] merge(int[][] intervals) {

        List<List<Integer>> list = new ArrayList<>();

        // 인덱스 0번이 작은 순서대로 정렬 => 이제 순서보장됐으니 순서대로 탐색하면 됨
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        //배열은 1이상
        if(intervals.length == 1) {
            return new int[][]{intervals[0]};
        }

        int len = intervals.length;
        int[] start = intervals[0];

        // start는 항상 큰값 => 그래야 0번째의 작은값을 커버할 수 있음
        for(int x = 1; x < len; x++) {

            int[] cur = intervals[x];
            int[] bef = intervals[x - 1];
            int min = cur[0];
            int max = cur[1];
            int realMax = Math.max(max, start[1]);
            int realMin = Math.min(min, start[0]);

            // 바뀌는 케이스 => 1. 값이 같을 때 start 변경됨 / 2. 작은 값이 큰 값보다 클 때(이전 인덱스 값까지 포함)
            /*
                바뀌는 케이스
                - 값이 같을 때 start 변경됨
                - 작은 값이 큰 값보다 클 때(이전 인덱스 값까지 포함)
                - 배열의 마지막에
             */
            if(min >= start[1]) {
                if(start[1] == min) {
                    list.add(List.of(realMin, realMax));
                    if(x < len - 1) start = intervals[x + 1];
                } else {
                    list.add(List.of(Math.min(start[0], bef[0]), Math.max(start[1], bef[1])));
                    start = cur;
                }
            } else {
                if(x == len - 1) {
                    list.add(List.of(realMin, realMax));
                }
            }

        }

        int[][] ans = new int[list.size()][2];

        for(int x = 0; x < list.size(); x++) {

            ans[x] = list.get(x).stream().mapToInt(Integer::intValue).toArray();
        }

        return ans;

    }

}
