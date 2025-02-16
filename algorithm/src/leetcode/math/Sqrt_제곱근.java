package leetcode.math;

public class Sqrt_제곱근 {

    class Solution {
        public int solution(int n) {

            double v = Math.sqrt(n);

            return v == Math.floor(v) ? 1 : 2;
        }
    }

}
