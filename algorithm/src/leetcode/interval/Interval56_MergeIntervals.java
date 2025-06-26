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

        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            // Check if current and next intervals overlap
            if (current[1] >= next[0]) {
                // Merge overlapping intervals
                current[1] = Math.max(current[1], next[1]);
            } else {
                // No overlap, add current to result and move to next
                merged.add(current);
                current = next;
            }
        }

        // Add the last interval
        merged.add(current);

        // Convert List to array
        return merged.toArray(new int[merged.size()][]);

    }

}
