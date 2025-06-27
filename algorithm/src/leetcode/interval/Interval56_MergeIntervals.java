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

        순서대로 정렬이 안되있을 수도 있다. -> 정렬 필요
     */
    public int[][] merge(int[][] intervals) {

        // 1. 0번쨰 인덱스 작은 순서대로 정렬
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for(int i = 0; i < intervals.length; i++){

        }
    }

    public int[][] merge2(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (current[1] >= next[0]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                merged.add(current);
                current = next;
            }
        }

        merged.add(current);

        return merged.toArray(new int[merged.size()][]);
    }

}
