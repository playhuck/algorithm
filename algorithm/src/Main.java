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
//                new int[][]{{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}}
//        ))));
        System.out.println(Arrays.toString(solution.solution(new int[]{1, 2, 3, 4, 5, 6}, 4)));
//                System.out.println(Arrays.toString(solution.solution(new String[]{"right", "right", "right", "right", "right", "left"}, new int[]{9, 5})));
//        System.out.println(Arrays.toString(new String[]{solution.solution(
//                new String[]{"meosseugi", "1234"},
//                new String[][]{{"rardss", "123"}, {"yyoom", "1234"}, {"meosseugi", "1234"}})}));
//        System.out.println(solution.solution(7, 20));
//        System.out.println(Arrays.toString(solution.solution("abc1Addfggg4556b", 6)));
//        System.out.println(solution.solution("onefourzerosixseven"));
//          System.out.println(solution.solution(1081));
//        System.out.println(Arrays.toString(solution.solution(123, 48, 1343, 18)));
//                System.out.println(solution.solution("allpe", "apple"));
//                        System.out.println(solution.solution(40));

    }

    static class Solution {
        public int[] solution(int[] numlist, int n) {

            int[] answer = new int[numlist.length];

            if (n == numlist[0]) {
                return numlist;
            }

            Map<Integer, Integer> numMap = new LinkedHashMap<>();

            for (Integer i : numlist) {
                numMap.put(i, Math.abs(i - n));
            }

            return numMap.entrySet().stream()
                    .sorted((a, b) -> {
                        int comparison = a.getValue().compareTo(b.getValue());
                        return comparison != 0 ? comparison : b.getKey().compareTo(a.getKey());
                    })
                    .mapToInt(Map.Entry::getKey)
                    .toArray();
        }
    }
}
