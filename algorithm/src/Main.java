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

        System.out.println((solution.solution(
                new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}}
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

    /*
        1일 때 [i,j-1], [i, j+1], [i - 1, j], [i -1, j -1], [i -1, j +1], [i + 1, j] [i + 1, j -1], [i + 1, j + 1], [i, j]
        단 여기서,
            - i가 0보다 작아지면 안되고
            - j가 0보다 작아지면 안되고, j가 length 보다 작아야한다.
            - 포함되는 건 Map에다 String으로 i + j로 박아버린다. 1이 나오면 +1 해버린다.
     */

    static class Solution {
        public int solution(int[][] board) {
            int answer = 0;

            Map<String, Integer> bombMap = new HashMap<>();
            int oneCount = 0;

            int[][] directions = {
                    {0, -1},  // 좌
                    {0, 1},   // 우
                    {-1, 0},  // 상
                    {-1, -1}, // 좌상
                    {-1, 1},  // 우상
                    {1, 0},   // 하
                    {1, -1},  // 좌하
                    {1, 1},   // 우하
            };

            for (int i = 0; i < board.length; i++) {

                for (int j = 0; j < board[0].length; j++) {

                    answer ++;

                    if(board[i][j] == 1) {

                        oneCount ++;
                        for (int[] dir : directions) {
                            int x = i + dir[0];
                            int y = j + dir[1];

                            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length) {

                                if(!bombMap.containsKey(x + "-" + y) && board[x][y] != 1) {
                                    bombMap.put(x + "-" + y, board[x][y]);
                                }
                            }
                        }
                    }

                }
            }

            int surviveCount = answer - bombMap.size() - oneCount;

            return Math.max(surviveCount, 0);
        }
    }
}
