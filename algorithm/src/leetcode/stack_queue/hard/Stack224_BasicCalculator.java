package leetcode.stack_queue.hard;

import java.util.*;

public class Stack224_BasicCalculator {
    /*
        유효한 표현식을 나타내는 문자열 s가 주어졌을 때,
        이를 평가하는 기본 계산기를 구현하고, 그 평가 결과를 반환하세요.

        참고: 문자열을 수학 표현식으로 평가하는 eval()과 같은 내장 함수를 사용할 수 없습니다.
     */

    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int sign = 1;
        int cur = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if(Character.isDigit(c)){
                cur = cur * 10 + c - '0';
            } else if (c == '+') {

                ans += sign * cur;
                sign = 1;
                cur = 0;
            } else if (c == '-') {

                ans += sign * cur;
                sign = -1;
                cur = 0;
            } else if( c == ')') {

                ans += sign * cur;
                int prevSign = stack.pop();
                int preAns = stack.pop();
                ans = preAns + ( ans * prevSign );
                cur = 0;

            } else if ( c== '('){

                stack.push(ans);
                stack.push(sign);

                ans = 0;
                sign = 1;
                cur = 0;

            }

        }

        if(cur != 0) {
            ans += sign * cur;
        }

        return ans;

    }
}
