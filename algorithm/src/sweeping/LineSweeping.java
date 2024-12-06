package sweeping;

/*
    선분 3개가 평행하게 놓여 있습니다. 세 선분의 시작과 끝 좌표가 [[start, end], [start, end], [start, end]] 형태로
    들어있는 2차원 배열 lines가 매개변수로 주어질 때, 두 개 이상의 선분이 겹치는 부분의 길이를 return 하도록 solution 함수를 완성해보세요.

    lines가 [[0, 2], [-3, -1], [-2, 1]]일 때 그림으로 나타내면 다음과 같습니다.

    line_2.png

    선분이 두 개 이상 겹친 곳은 [-2, -1], [0, 1]로 길이 2만큼 겹쳐있습니다.

    제한사항
    lines의 길이 = 3
    lines의 원소의 길이 = 2
    모든 선분은 길이가 1 이상입니다.
    lines의 원소는 [a, b] 형태이며, a, b는 각각 선분의 양 끝점 입니다.
    -100 ≤ a < b ≤ 100

 */

import java.util.ArrayList;
import java.util.List;

public class LineSweeping {
    class Solution {

        static class Event {
            int point;   // 좌표
            boolean isStart;  // true=시작점, false=끝점
            int index;   // 선분 번호

            public Event(int i, boolean b, int i1) {
                point = i;
                isStart = b;
                index = i1;
            }
        }

        public int solution(int[][] lines) {

            List<Event> events = new ArrayList<>();
            for (int i = 0; i < lines.length; i++) {
                events.add(new Event(lines[i][0], true, i));   // 시작점
                events.add(new Event(lines[i][1], false, i));  // 끝점
            }

            events.sort((a, b) -> {

                if (a.point != b.point) return a.point - b.point;
                else return a.isStart ? 1 : -1;
            });

            int activeLines = 0;
            int start = 0;
            int totalLength = 0;

            for (Event event : events) {

                if (event.isStart) {
                    activeLines++;
                    if (activeLines == 2) {
                        start = event.point;
                    }
                } else {
                    activeLines--;
                    if (activeLines == 1) {  // 겹치는 구간이 끝날 때
                        if (event.point > start) {  // 유효한 겹치는 구간인 경우
                            totalLength += event.point - start;
                        }
                    }
                }
            }

            return totalLength;
        }
    }
}
