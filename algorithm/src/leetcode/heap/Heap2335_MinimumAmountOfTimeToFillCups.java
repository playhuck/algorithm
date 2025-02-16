package leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap2335_MinimumAmountOfTimeToFillCups {
     /*
        찬물, 온수, 뜨거운 물을 제공하는 정수기가 있습니다.
        매 초마다 다음 중 하나를 선택할 수 있습니다:

        서로 다른 종류의 물 2컵을 채우거나
        아무 종류의 물 1컵을 채우기

        amount[0], amount[1], amount[2]가 각각 채워야 할 찬물, 온수, 뜨거운 물의 컵 수를 나타내는 길이 3의 정수 배열 amount가 주어집니다.
        모든 컵을 채우는데 필요한 최소 시간(초)을 반환하세요.
        추가 설명:

        0 => 찬물 컵 수
        1 => 온수 컵 수
        2 => 뜨거운 물 컵 수

        큰거, 큰거에서 작은거씩 -1 -1 -1 -1

        amount 배열은 0-indexed 입니다
        서로 다른 종류의 물 2컵을 동시에 채울 수 있습니다
        한 번에 한 컵씩 채우는 것도 가능합니다
        Input: amount = [5,4,4]
        Output: 7
     */

    public static int fillCups(int[] amount) {

        if (amount.length == 0) return 0;

        Arrays.sort(amount);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int j : amount) {
            pq.add(j);
        }

        int count = 0;

        while (true) {

            int max = pq.poll(); // poll 꺼내고 삭제
            int sub = pq.poll();

            if (max == 0) {
                break;
            }

            pq.add(max - 1); //
            pq.add(sub - 1);
            count ++;

        }

        return count;
    }
}
