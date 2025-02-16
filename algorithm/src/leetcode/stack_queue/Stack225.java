package leetcode.stack_queue;

import java.util.ArrayList;
import java.util.List;

public class Stack225 {

    static class MyStack {

        List<Integer> stack = new ArrayList<>();

        public MyStack() {

        }

        public void push(int x) {
            this.stack.add(x);
        }

        public int pop() {
            return this.stack.remove(this.stack.size() - 1);
        }

        public int top() {
            return this.stack.get(this.stack.size() - 1);
        }

        public boolean empty() {
            return this.stack.isEmpty();
        }
    }
}
