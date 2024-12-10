package stack_queue;

import java.util.ArrayList;
import java.util.List;

public class Queue232 {

    static class MyQueue {

        List<Integer> queue = new ArrayList<>();

        public MyQueue() {

        }

        public void push(int x) {
            this.queue.add(x);
        }

        public int pop() {
            return this.queue.remove(0);
        }

        public int peek() {
            return this.queue.get(0);
        }

        public boolean empty() {
            return this.queue.isEmpty();
        }
    }

}
