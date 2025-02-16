package leetcode.stack_queue;

import java.util.ArrayList;
import java.util.List;

public class Queue933 {
    static class RecentCounter {

        List<Integer> queue = new ArrayList<>();

        public RecentCounter() {
        }

        public int ping(int t) {

            queue.add(t);

            int last = queue.get(queue.size() - 1);

            int counter = 0;

            for(Integer i : queue) {

                if(i >= last - 3000 && i <= last) {
                    counter++;
                }
            }

            return counter;
        }
    }

    class RecentCounter2 {

        List<Integer> queue = new ArrayList<>();

        public RecentCounter2() {
        }

        public int ping(int t) {

            this.queue.add(t);

            int start = t - 3000;

            int counter = 0;

            for(Integer i : queue) {

                if(i >= start && i <= t) {
                    counter++;
                }
            }

            if(counter != queue.size()) {
                queue.remove(0);
            }

            return counter;

        }
    }
}
