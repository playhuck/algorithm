package leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomSize {
    class RandomizedSet {

        private Map<Integer, Integer> map;

        public RandomizedSet() {
            this.map = new HashMap<>();
        }

        public boolean insert(int val) {

            if(!this.map.containsKey(val)) {
                this.map.put(val, 1);
                return true;
            }

            return false;

        }

        public boolean remove(int val) {

            if(!this.map.containsKey(val)) {
                this.map.remove(val);
                return true;
            }

            return false;

        }

        public int getRandom() {

            if(this.map.size() > 1) {
                Random r = new Random();

                return this.map.get(r.nextInt(this.map.size()));
            }

            throw new Error("에러발생");
        }
    }
}
