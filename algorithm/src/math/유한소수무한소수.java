package math;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class 유한소수무한소수 {
    /*
           유한소수가 되기 위한 분수의 조건은 다음과 같습니다. 기약분수로 나타내었을 때, 분모의 소인수가 2와 5만 존재해야 합니다.
           분자와 분모의 최대공약수로 약분하면 기약분수를 만들 수 있습니다.
           정수도 유한소수로 분류합니다.
        */
    public int solution(int a, int b) {

        int max = Math.max(a, b);
        int min = Math.min(a, b);

        /*
            유클리드 호제법 시행, 최대 공약수를 찾습니다.
         */
        while (min > 1) {

            int r = max % min;

            if(r == 0) {
                break;
            }

            max = min;
            min = r;
        }

        /*
            최대공약수로 약분된 분모
         */
        int denominator = b / min;

        /*
            소인수 리스트
         */
        List<Integer> factors = new ArrayList<>();

        /*
            소인수 분해 스타트
         */
        while (denominator % 2 == 0) {
            denominator /= 2;
            factors.add(2);
        }

        /*
            분모의 제곱근보다 소인수는 작다.
         */
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

        /*
            2,5면 유한소수
            아니면 무한소수
         */

        for(Integer factor : factors) {

            if(!pattern.matcher(String.valueOf(factor)).matches()) {
                return 2;
            }
        }

        return 1;
    }
}
