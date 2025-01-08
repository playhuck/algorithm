package two_pointer;

public class TP202 {
     /*
        숫자 n이 행복수인지 판단하는 알고리즘을 작성하세요.
        행복수는 다음 과정으로 정의되는 숫자입니다:

        임의의 양의 정수로 시작하여, 그 숫자를 각 자릿수의 제곱의 합으로 대체합니다.
        숫자가 1이 될 때까지(1에서 멈춤), 또는 1을 포함하지 않는 무한 순환에 빠질 때까지 이 과정을 반복합니다.
        이 과정이 1로 끝나는 숫자들이 행복수입니다.

        n이 행복수라면 true를, 아니라면 false를 반환하세요.

        Input: n = 19
        Output: true
        Explanation:
        12 + 92 = 82
        82 + 22 = 68
        62 + 82 = 100
        12 + 02 + 02 = 1

     */

    public class Solution {
        public static boolean isHappy(int n) {

            int target = n;

            int count = 0;

            while (target != 1) {

                int sum = 0;
                if(count == 10) break;

                while (target > 0) {

                    sum += ((target % 10) * (target % 10));

                    target = (target / 10);
                }

                target = sum;
                count++;
            }

            return target == 1;

        }
    }
}
