package leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class 소인수분해 {

    /*
        이 알고리즘의 시간 복잡도는 O(√n)입니다.
        Math.sqrt(n)까지만 검사하면 충분한 이유는, 합성수는 반드시 √n 이하의 소인수를 가지기 때문입니다.
        큰 수의 경우 long 타입을 사용하는 것이 좋을 수 있습니다.
        매우 큰 수의 경우 BigInteger 클래스를 사용해야 할 수 있습니다.
     */
    public static List<Integer> getPrimeFactors(int number) {
        List<Integer> factors = new ArrayList<>();

        // 음수 처리
        if (number < 0) {
            number = Math.abs(number);
            factors.add(-1);
        }

        // 2로 나눌 수 있을 때까지 나누기
        while (number % 2 == 0) {
            factors.add(2);
            number = number / 2;
        }

        // 3부터 시작하여 홀수로 나누기
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                factors.add(i);
                number = number / i;
            }
        }

        // 마지막 남은 수가 1보다 크면 (소수인 경우) 추가
        if (number > 1) {
            factors.add(number);
        }

        return factors;
    }
}
