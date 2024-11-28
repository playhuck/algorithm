package math;

import java.math.BigInteger;

public class Factorial {

    class Solution {
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
