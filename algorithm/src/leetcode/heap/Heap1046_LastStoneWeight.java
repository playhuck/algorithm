package leetcode.heap;

import java.util.*;

public class Heap1046_LastStoneWeight {
    /*
        정수 배열 stones가 주어지며, stones[i]는 i번째 돌의 무게입니다.
        우리는 돌들로 게임을 하고 있습니다. 각 턴마다, 우리는 가장 무거운 두 돌을 선택하여 서로 부딪힙니다.
        가장 무거운 두 돌의 무게가 x와 y이고 x <= y라고 가정합니다. 이 충돌의 결과는 다음과 같습니다:

        만약 x == y이면, 두 돌 모두 파괴되고,
        만약 x != y이면, 무게가 x인 돌은 파괴되고, 무게가 y인 돌은 새로운 무게 y - x를 갖게 됩니다.

        게임이 끝날 때, 최대 하나의 돌만 남습니다.
        마지막으로 남은 돌의 무게를 반환하세요. 만약 남은 돌이 없다면, 0을 반환하세요.
     */


    public static int lastStoneWeight(int[] stones) {

        Integer[] integers = Arrays.stream(stones).boxed().toArray(Integer[]::new);

        Arrays.sort(integers, Collections.reverseOrder());

        if (stones.length == 1) {
            return stones[0];
        }

        if (integers.length <= 2) {
            if (Objects.equals(integers[0], integers[1])) {
                return 0;
            } else {
                return integers[0] - integers[1];
            }
        }

        List<Integer> stonesList = new ArrayList<>(Arrays.stream(integers).toList());

        while (stonesList.size() >= 2) {

            final int y = stonesList.get(0);
            final int x = stonesList.get(1);

            if(y == x) {
                stonesList.remove(0);
                stonesList.remove(0);
            } else {
                stonesList.remove(0);
                stonesList.remove(0);
                stonesList.add(y - x);
            }

            stonesList.sort(Collections.reverseOrder());

        }

        return !stonesList.isEmpty() ? stonesList.get(0) : 0;
    }

    int lastStoneWeight2(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() > 1) {

            int y = pq.poll();
            int x = pq.poll();
            int n = Math.abs(x - y);

            if(x == y) {
                continue;
            } else {

                pq.add(n);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }

}
