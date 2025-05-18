package leetcode.array;

import java.util.*;

public class RandomSize {
    class RandomizedSet {

        private Map<Integer, Integer> map;
        private List<Integer> list;
        private Random random;


        public RandomizedSet() {
            this.map = new HashMap<>();
            this.list = new ArrayList<>();
            this.random = new Random();
        }

        public boolean insert(int val) {

            if(!this.map.containsKey(val)) {
                list.add(val);
                this.map.put(val, this.list.size() - 1);

                return true;
            }

            return false;

        }

        public boolean remove(int val) {

            if(!this.map.containsKey(val)) {
                return false;
            }

            int indexToRemove = this.map.get(val);
            int lastElement = this.list.get(this.list.size() - 1);

            // 마지막 요소를 삭제할 위치로 이동
            this.list.set(indexToRemove, lastElement);

            // 맵에서 마지막 요소의 인덱스 갱신
            this.map.put(lastElement, indexToRemove);

            // 리스트에서 마지막 요소 제거
            this.list.remove(this.list.size() - 1);

            // 맵에서 삭제할 값 제거
            this.map.remove(val);

            return true;

        }

        public int getRandom() {

            return this.list.get(random.nextInt(this.list.size()));

        }
    }
}
