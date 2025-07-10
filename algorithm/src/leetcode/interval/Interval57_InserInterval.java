package leetcode.interval;

import java.util.*;

public class Interval57_InserInterval {

    /*
        주어진 배열 intervals는 겹치지 않는 구간들을 담고 있으며,
        각 intervals[i] = [starti, endi]는 i번째 구간의 시작점과 끝점을 나타냅니다.
        또한 intervals 배열은 starti를 기준으로 오름차순 정렬되어 있습니다. 새로운 구간 newInterval = [start, end]도 주어집니다.

        newInterval을 intervals에 삽입하여, intervals가 여전히 starti를 기준으로 오름차순 정렬되어 있고,
        겹치는 구간이 없는 상태(필요하다면 겹치는 구간들을 병합하세요)를 유지하도록 만드세요.

        삽입 후의 intervals를 반환하세요.

        참고: intervals를 제자리(in-place)에서 수정할 필요는 없습니다. 새 배열을 만들어 반환해도 됩니다.
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals.length == 0) return new int[][]{newInterval};

        List<List<Integer>> list = new ArrayList<>(intervals.length + 1);
        for(int[] interval : intervals) {

            list.add(Arrays.stream(interval).boxed().toList());
        }
        list.add(Arrays.stream(newInterval).boxed().toList());
        list.sort(Comparator.comparingInt(l -> l.get(0)));

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        /*
            1. for 루프의 최소값이 max보다 크다면 갱신
            2. 마지막에 min과 max 추가
         */
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> inter : list) {

            if(min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) {
                min = inter.get(0);
                max = inter.get(1);
            }

            int lMin = inter.get(0);
            int lMax = inter.get(1);

            if(lMin == min) {

                max = Math.max(max, lMax);
            } else {

                if(lMin > max) {
                    List<Integer> sub = new ArrayList<>();
                    sub.add(min); sub.add(max);
                    ans.add(sub);

                    min = lMin;
                    max = lMax;
                } else {

                    max = Math.max(max, lMax);
                }
            }
        }

        List<Integer> sub = new ArrayList<>();
        sub.add(min);
        sub.add(max);
        ans.add(sub);

        int[][] ansArr = new int[ans.size()][2];
        for(int i = 0; i < ans.size(); i++) {
            ansArr[i][0] = ans.get(i).get(0);
            ansArr[i][1] = ans.get(i).get(1);
        }

        return ansArr;

    }

    public int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
