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
//        System.out.println((solution.solution(
//                new int[][]{{1, 1}, {2,2}, {3,3}, {4,4}}
//        )));
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
          System.out.println(solution.solution(7, 22));
//        System.out.println(solution.solution(40));

    }

    static class Solution {

        /*
            유한소수가 되기 위한 분수의 조건은 다음과 같습니다. 기약분수로 나타내었을 때, 분모의 소인수가 2와 5만 존재해야 합니다.
            분자와 분모의 최대공약수로 약분하면 기약분수를 만들 수 있습니다.
            정수도 유한소수로 분류합니다.
         */
        public int solution(int a, int b) {

            int max = Math.max(a, b);
            int min = Math.min(a, b);

            while (min > 1) {

                int r = max % min;

                if(r == 0) {
                    break;
                }

                max = min;
                min = r;
            }

            int denominator = b / min;

            List<Integer> factors = new ArrayList<>();

            while (denominator % 2 == 0) {
                denominator /= 2;
                factors.add(2);
            }

            for (int i = 3; i <= Math.sqrt(b); i+=2) {

                while (denominator % i == 0) {
                    denominator /= i;
                    factors.add(i);
                }
            }

            if (denominator > 1) {
                factors.add(denominator);
            }

            Pattern pattern = Pattern.compile("[25]+");

            for(Integer factor : factors) {

                if(!pattern.matcher(String.valueOf(factor)).matches()) {
                    return 2;
                }
            }

            return 1;
        }
    }
}
