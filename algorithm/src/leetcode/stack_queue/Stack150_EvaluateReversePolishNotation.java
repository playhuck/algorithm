package leetcode.stack_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class Stack150_EvaluateReversePolishNotation {

    /*
        **역폴란드 표기법(Reverse Polish Notation)**으로
        * 작성된 산술 표현식을 나타내는 문자열 배열 tokens가 주어집니다.
        이 표현식을 계산하고, 그 값을 나타내는 정수를 반환하세요.
        참고:

        유효한 연산자는 +, -, *, / 입니다.
        각 피연산자는 정수이거나 다른 표현식일 수 있습니다.
        두 정수 사이의 나눗셈은 항상 0을 향해 잘립니다 (truncates toward zero).
        0으로 나누는 경우는 없습니다.
        입력은 역폴란드 표기법의 유효한 산술 표현식입니다.
        정답과 모든 중간 계산 결과는 32비트 정수로 표현될 수 있습니다.
     */

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        Map<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();
        operations.put("+", (a, b) -> a + b);
        operations.put("-", (a, b) -> a - b);
        operations.put("*", (a, b) -> a * b);
        operations.put("/", (a, b) -> {

            if( a == 0 || b == 0) {
                return 0;
            } else {
                return a / b;
            }
        });


        for(String token : tokens) {

            if(operations.containsKey(token)) {

                int op2 = stack.pop();
                int op1 = stack.pop();

                int ans = operations.get(token).apply(op1, op2);
                stack.push(ans);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.peek();
    }

}
