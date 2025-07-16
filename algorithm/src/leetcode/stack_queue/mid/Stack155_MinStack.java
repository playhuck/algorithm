package leetcode.stack_queue.mid;

import java.util.LinkedList;

public class Stack155_MinStack {

    /*
        MinStack 클래스를 구현해야 합니다:
        MinStack(): 스택 객체를 초기화합니다.
        void push(int val): 원소 val을 스택에 푸시(push)합니다.
        void pop(): 스택의 맨 위 원소를 제거합니다.
        int top(): 스택의 맨 위 원소를 가져옵니다.
        int getMin(): 스택 내의 최소 원소를 검색합니다.
        각 함수에 대해 O(1) 시간 복잡도로 구현해야 합니다.

        stack내의 개수 저장
        min 관리
        핵심은 최소 값이 변경됐을 때 어떻게 추적하느냐
        숫자가 1개(최소 값이 1개만 있을 때)
        메모이 제이션쓰면 안됨?
        object 만들어서
        중간 값이 들어오면?
     */

    class MinStack {

        private final LinkedList<Integer> stack;
        private int min;

        public MinStack() {
            stack = new LinkedList<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int val) {

            if(val <= min) {
                stack.push(min);
                min = val;
            }

            stack.push(val);

        }

        public void pop() {
            if(stack.isEmpty()) return;
            if(min == stack.pop()) min = stack.pop();


        }

        public int top() {
            if(stack.isEmpty()) return -1;
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }

}
