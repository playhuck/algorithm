import java.math.BigInteger;
import java.net.Inet4Address;
import java.sql.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

//        System.out.println((Arrays.toString(solution.solution(
//                new String[]{"3 - 4 = -3", "5 + 6 = 11"}
//        ))));
        System.out.println((solution.solution(
                new int[][]{{-5, 5}, {2, 8}, {6, 7}}
        )));
//        System.out.println((Arrays.toString(solution.solution(
//                new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}}
//        ))));
//        System.out.println(Arrays.toString(solution.solution(new int[]{1, 2, 3, 4, 5, 6}, 4)));
//          System.out.println(solution.solution(new int[]{0, 0, 2, 2}));
//        System.out.println(Arrays.toString(solution.solution(new String[]{"right", "right", "right", "right", "right", "left"}, new int[]{9, 5})));
//        System.out.println(Arrays.toString(new String[]{solution.solution(
//                new String[]{"meosseugi", "1234"},
//                new String[][]{{"rardss", "123"}, {"yyoom", "1234"}, {"meosseugi", "1234"}})}));
//        System.out.println(solution.solution(7, 20));
//        System.out.println(Arrays.toString(solution.solution("abc1Addfggg4556b", 6)));
//        System.out.println(solution.solution("+ 13x + 7 + x + x + 1 + 2 +"));
//        System.out.println(solution.solution(1081));
//        System.out.println(Arrays.toString(solution.solution(123, 48, 1343, 18)));
//        System.out.println(solution.solution("allpe", "apple"));
//        System.out.println(solution.solution(40));

    }

    static class Solution {
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

                if(event.isStart) {
                    activeLines ++;
                    if(activeLines == 2) {
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
    }
}
