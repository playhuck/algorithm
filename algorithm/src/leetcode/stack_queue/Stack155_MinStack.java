package leetcode.stack_queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Stack;

public class Stack155_MinStack {

    class MinStack {

        private final LinkedList<Integer> stack;
        private final HashMap<Integer, Integer> minMap;
        private final HashMap<Integer, Integer> minCount;
        private int min;

        /*
            최소 원소를 가져오려면, 현재 최소 원소가 그 다음 최소원소의 값을 알고 있는 map을 계산하면 될듯?
         */

        public MinStack() {
            stack = new LinkedList<>();
            minMap = new HashMap<>();
            minCount = new HashMap<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int val) {
            stack.push(val);

            if(min == Integer.MAX_VALUE) {
                min = val;
                minMap.put(min, min);
                minCount.put(min, minCount.getOrDefault(min, 0) + 1);
            } else {
                if(val <= min) {
                    minMap.put(val, min);
                    min = val;
                    minCount.put(min, minCount.getOrDefault(min, 0) + 1);
                }
            }
        }

        public void pop() {
            if(stack.isEmpty()) return;
            int pop = stack.pop();

            if(pop == min) {
                if(minCount.get(min) > 1) {
                    minCount.put(min, minCount.get(min) - 1);
                } else {
                    min = minMap.get(min);
                    minMap.remove(pop);
                }
            }
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
