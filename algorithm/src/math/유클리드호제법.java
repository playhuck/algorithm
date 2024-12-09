package math;

public class 유클리드호제법 {

    class Solution {
        public int[] solution(int numer1, int denom1, int numer2, int denom2) {
            int[] answer;

            int sum = (numer1 * denom2) + (numer2 * denom1);
            int deno = denom1 * denom2;
            int g = gcd(sum, deno);

            answer = new int[]{sum / g, deno / g};

            return answer;
        }

        public int gcd(int a, int b) {

            // 1. 큰 수가 a에 오도록 정렬
            if(a < b) {
                int tma = a;
                a = b;
                b = tma;
            }

            // 2. b가 1보다 큰 동안 반복
            while (b > 1) {
                // 3. a(큰수)를 b(작은 수)로 나눈 나머지 계산
                int rest = a % b;

                // 4. 나머지가 0이면 b가 최대공약수
                if(rest == 0) {
                    return b;
                }

                // 5. a(큰 수)에 b(작은 수)를 대입, b(작은 수)에 나머지(rest)를 대입
                a = b;
                b = rest;
            }

            // 6. 최종적으로 남은 b가 최대공약수
            return b;
        }
    }

}
