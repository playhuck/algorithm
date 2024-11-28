import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

//        System.out.println((solution.solution(new int[]{3, 6})));
//        System.out.println(solution.solution(new int[]{1, 2, 3}, 5));
        System.out.println(solution.solution(30, 29));
//        System.out.println(Arrays.toString(solution.solution("abc1Addfggg4556b", 6)));
//        System.out.println(solution.solution("onefourzerosixseven"));
//        System.out.println(Arrays.toString(solution.solution(123, 48, 1343, 18)));
//                System.out.println(solution.solution("allpe", "apple"));
//                        System.out.println(Arrays.toString(solution.solution(420)));

    }

    static class Solution {
        public int solution(int balls, int share) {

            if(balls == 1) return 1;
            if(share == 1) return balls;
            if(balls == share) return 1;

            BigInteger n = getFactorial(balls);
            BigInteger r = getFactorial(share);
            BigInteger nmr = getFactorial(balls - share);

            return n.divide(r.multiply(nmr)).intValue();
        }

        public BigInteger getFactorial(int n) {
            BigInteger result = BigInteger.ONE;
            for(int i = 2; i <= n; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
            return result;        }
    }
}
