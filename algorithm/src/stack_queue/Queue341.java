package stack_queue;

import java.util.*;

public class Queue341 {

    public static void main(String[] args) {

        List<NestedInteger> deepestList = List.of(
                new NestedInteger(6)
        );
        List<NestedInteger> middleList = Arrays.asList(
                new NestedInteger(4),
                new NestedInteger(deepestList)
        );
        List<NestedInteger> test3 = Arrays.asList(
                new NestedInteger(1),
                new NestedInteger(middleList)
        );

        NestedIterator queue341 = new NestedIterator(test3);
    }
    /*
        중첩된 정수 리스트 nestedList가 주어집니다. 각 요소는 정수이거나, 정수 또는 다른 리스트를 포함할 수 있는 리스트입니다. 이를 평탄화하는 반복자(iterator)를 구현하세요.
        NestedIterator 클래스를 다음과 같이 구현하세요:

        NestedIterator(List<NestedInteger> nestedList) 중첩 리스트 nestedList로 반복자를 초기화합니다.
        int next() 중첩 리스트의 다음 정수를 반환합니다.
        boolean hasNext() 중첩 리스트에 아직 정수가 남아있으면 true를, 그렇지 않으면 false를 반환합니다.

        여러분의 코드는 다음과 같은 의사 코드로 테스트됩니다:
        initialize iterator with nestedList
        res = []
        while iterator.hasNext()
            append iterator.next() to the end of res
        return res
        만약 res가 예상되는 평탄화된 리스트와 일치하면, 여러분의 코드는 올바른 것으로 판단됩니다.
     */
    public static class NestedIterator implements Iterator<Integer> {

        List<Integer> nestedIntegerList = new ArrayList<>();
        Integer position;

        public NestedIterator(List<NestedInteger> nestedList) {

            this.flatNestedIntegerList(nestedList);
            this.position = 0;

            for (Integer nestedInteger : nestedIntegerList) {
                System.out.println(nestedInteger);
            }
        }

        @Override
        public Integer next() {

            final int nestedInteger = nestedIntegerList.get(position);

            position ++;

            return nestedInteger;
        }

        @Override
        public boolean hasNext() {

            return position < nestedIntegerList.size();
        }

        /*
            [[1,2] ,2, [3,4]]
         */
        public void flatNestedIntegerList(List<NestedInteger> nestedList) {

            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    nestedIntegerList.add(nestedInteger.getInteger());
                } else {
                    flatNestedIntegerList(nestedInteger.getList());
                }
            }
        }

    }

    public static class NestedInteger {
        public Integer value;
        public List<NestedInteger> list;

        public NestedInteger(Integer value) {
            this.value = value;
        }

        public NestedInteger(List<NestedInteger> nestedList) {
            this.list = nestedList;
        }

        public boolean isInteger(){
            return Objects.nonNull(this.value);
        }

        public int getInteger(){
            return this.value;
        }

        public void setInteger(int v){
            this.value = v;
        }

        public void add(NestedInteger ni){
            list.add(ni);
        }

        public List<NestedInteger> getList(){
            return list;
        }

    }
}
