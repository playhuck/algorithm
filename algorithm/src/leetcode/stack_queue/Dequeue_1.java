package leetcode.stack_queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Dequeue_1 {

    public int solution(String A, String B) {

        if(A.equals(B)) {
            return 0;
        }
        int answer = 0;
        int count = 0;
        boolean isEqual = false;

        String[] strings = A.split("");

        Deque<String> stack = new ArrayDeque<>(Arrays.asList(strings));

        while (strings.length > count) {

            String last = stack.pollLast();

            stack.addFirst(last);

            answer ++;
            count ++;

            if(String.join("", stack).equals(B)) {
                isEqual = true;
                break;
            };
        }

        return isEqual ? answer : -1;
    }

}
