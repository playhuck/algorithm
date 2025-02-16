import java.util.*;

public class LeetCode {

    public static void main(String[] args) {

//        System.out.println(countGoodRectangles(
//                new int[][]{{5,8},{3,9},{5,12},{16,5}}
//        ));
//        System.out.println(new RecentCounter().ping(
//                new String[]{"RecentCounter", "ping", "ping", "ping", "ping"}
//        ));
//        System.out.println(simplifyPath(
//                "/home/../../.."
//        ));
//        System.out.println(minNumber(
//                new String[]{"hello","world","leetcode"}, "welldonehoneyr"
//        ));
//        System.out.println(countStudents(
//                new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}
//        ));
//        System.out.println(timeRequiredToBuy(
//                new int[]{5,1,1,1}, 0
//        ));
        System.out.println(splitPainting(
                new int[][]{
                        {1, 4, 5},
                        {4, 7, 7},
                        {1, 7, 9}
                }
        ));
    }

    /*
        길고 얇은 그림이 수직선으로 표현될 수 있습니다.
        이 그림은 여러 개의 겹치는 구간으로 칠해졌으며, 각 구간은 고유한 색으로 칠해졌습니다.
        2차원 정수 배열 segments가 주어지며, segments[i] = [starti, endi, colori]는
        색상이 colori인 반개구간 [starti, endi)를 나타냅니다.

        그림에서 겹치는 구간의 색상들은 칠해질 때 혼합되었습니다. 두 개 이상의 색상이 혼합되면,
        혼합된 색상들의 집합으로 표현될 수 있는 새로운 색상이 형성됩니다.

        예를 들어, 색상 2, 4, 6이 혼합되면, 결과로 생기는 혼합 색상은 {2,4,6}입니다.
        단순화를 위해, 전체 집합이 아닌 집합 원소들의 합만 출력해야 합니다.

        당신은 이러한 혼합 색상들의 겹치지 않는 반개구간들의 최소 개수로 그림을 설명하고자 합니다.
        이 구간들은 2차원 배열 painting으로 표현될 수 있으며,
        painting[j] = [leftj, rightj, mixj]는 혼합 색상 합이 mixj인 반개구간 [leftj, rightj)를 설명합니다.

        예를 들어, segments = [[1,4,5],[1,7,7]]로 만들어진 그림은
        painting = [[1,4,12],[4,7,7]]로 설명될 수 있습니다. 이는:
        [1,4)는 첫 번째와 두 번째 구간 모두에서 {5,7}(합이 12)으로 칠해졌기 때문입니다.
        [4,7)는 두 번째 구간에서만 {7}로 칠해졌기 때문입니다.
        완성된 그림을 설명하는 2차원 배열 painting을 반환하세요(칠해지지 않은 부분은 제외).
        구간들은 어떤 순서로든 반환할 수 있습니다.

        반개구간 [a, b)는 점 a를 포함하고 점 b를 포함하지 않는 수직선 상의 구간입니다.
     */

    public static List<List<Long>> splitPainting(int[][] segments) {

        List<Segment> segmentList = new ArrayList<>();
        for (int[] segment : segments) {

            segmentList.add(new Segment(segment[0], segment[1], segment[2], true));
            segmentList.add(new Segment(segment[1], segment[0], segment[2], false));
        }

        segmentList.sort((a,b) -> {
            if (a.position != b.position) {
                return Long.compare(a.position, b.position);
            }
            return Long.compare(a.opposite, b.opposite);
        });

        /*
            start만 계속 나온다는 것은 겹친다.
            end가 나오면 1차 분절
         */

        List<List<Long>> res = new ArrayList<>();

        Segment curr = segmentList.get(0);
        long color = segmentList.get(0).color;

        for (int i = 1; i < segmentList.size(); i++) {

            Segment segment = segmentList.get(i);

            System.out.println("Segment : " + segment.position + " " + segment.opposite + " " + segment.color + " " + segment.isStart);
            System.out.println("curr : " +curr.position + " " + curr.opposite + " " + curr.color + " " + curr.isStart);

            if(segment.isStart) {

                /*
                    종료되서 이전에 종료되서 넘어온 경우
                 */
                if(curr.opposite <= segment.position) {
                    curr = segment;
                    color = segment.color;
                    continue;
                }

                if(curr.position == segment.position) {
                    color = color + segment.color;
                    if(segment.opposite > curr.opposite) {
                        curr.color = segment.color;
                    }
                }

            } else {

                if(segment.position == curr.opposite) {
                    res.add(Arrays.asList(curr.position, curr.opposite, color));
                    curr = segment;
                    continue;
                }

            }
        }

        return res;

    }

    public static class Segment {

        private long position;
        private long opposite;
        private long color;
        private boolean isStart;

        public Segment(long position, long opposite, long color, boolean isStart) {
            this.position = position;
            this.opposite = opposite;
            this.color = color;
            this.isStart = isStart;
        }
    }

}