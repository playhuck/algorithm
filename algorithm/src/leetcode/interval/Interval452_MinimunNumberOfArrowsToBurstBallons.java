package leetcode.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Interval452_MinimunNumberOfArrowsToBurstBallons {

    /*
        XY 평면을 나타내는 평평한 벽에 구형 풍선 몇 개가 테이프로 붙어 있습니다.
        풍선들은 2차원 정수 배열 points로 표현되며, points[i] = [xstart, xend]는
        풍선의 수평 직경이 xstart와 xend 사이에 걸쳐 있음을 나타냅니다. 풍선들의 정확한 Y 좌표는 알 수 없습니다.

        화살은 X축을 따라 다른 지점에서 직선으로 수직 위로 (양의 Y 방향으로) 쏠 수 있습니다.
        xstart와 xend를 가진 풍선은 x 지점에서 쏜 화살에 의해 xstart <= x <= xend인 경우 터집니다.
        쏠 수 있는 화살의 수에는 제한이 없습니다. 쏜 화살은 무한히 위로 날아가 경로에 있는 모든 풍선을 터뜨립니다.

        주어진 배열 points가 있을 때, 모든 풍선을 터뜨리기 위해 쏴야 하는 최소 화살의 수를 반환하세요.
     */
    public int findMinArrowShots(int[][] points) {

        if(points.length == 0) return 0;

        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));

        List<List<Integer>> list = new ArrayList<>(points.length);

        int min = points[0][0];
        int max = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int[] p = points[i];

            int lMin = p[0];
            int lMax = p[1];

            if (lMin > max) {
                List<Integer> l = new ArrayList<>(2);
                l.add(min); l.add(max);
                list.add(l);
                min = lMin;max = lMax;
            }

        }

        List<Integer> l = new ArrayList<>(2);
        l.add(min); l.add(max);
        list.add(l);

        return list.size();

    }

    public int findMinArrowShots2(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int currentEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > currentEnd) {
                arrows++;
                currentEnd = points[i][1];
            }

        }

        return arrows;
    }
}
