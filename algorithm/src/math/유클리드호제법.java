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

        public int gcd(int p, int q) {

            if(p < q) {
                int tmp = p;
                p = q;
                q = tmp;
            }

            while (q > 1) {

                int rest = p % q;
                if(rest == 0) {
                    return q;
                }
                p = q;
                q = rest;

            }

            return q;
        }
    }

}
