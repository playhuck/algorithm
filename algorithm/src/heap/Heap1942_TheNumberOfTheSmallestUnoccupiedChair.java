package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap1942_TheNumberOfTheSmallestUnoccupiedChair {
    /*
        0부터 n - 1까지 번호가 매겨진 n명의 친구들이 참석하는 파티가 있습니다.
        이 파티에는 0부터 무한대까지 번호가 매겨진 무한한 수의 의자가 있습니다.
        친구가 파티에 도착하면, 그들은 비어있는 의자 중 가장 작은 번호의 의자에 앉습니다.

        예를 들어, 한 친구가 도착했을 때 의자 0, 1, 5가 이미 점유되어 있다면, 그 친구는 2번 의자에 앉을 것입니다.

        친구가 파티를 떠날 때, 그들의 의자는 떠나는 순간에 비어있게 됩니다.
        만약 다른 친구가 같은 순간에 도착한다면, 그들은 그 의자에 앉을 수 있습니다.
        0부터 시작하는 2차원 정수 배열 times가 주어지며, times[i] = [arrivali, leavingi]는 각각 i번째 친구의 도착 시간과 떠나는 시간을 나타냅니다.
        또한 정수 targetFriend가 주어집니다. 모든 도착 시간은 서로 다릅니다.
        targetFriend 번호를 가진 친구가 앉게 될 의자 번호를 반환하세요.
     */

    public static int smallestChair(int[][] times, int targetFriend) {

        if(times.length == 0) {
            return 0;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int[] target = times[targetFriend];

        for (int[] time : times) {

            queue.add(new int[]{time[0], time[1]});

        }
        int visitChair = Integer.MIN_VALUE;

        int[][] visited = new int[times.length][3];

        while (!queue.isEmpty()) {

            int[] poll = queue.poll();

            for (int i = 0; i < visited.length; i++) {

                if (visited[i][2] == 0) {
                    visited[i][0] = poll[0];
                    visited[i][1] = poll[1];
                    visited[i][2] = 1;
                    if (Arrays.equals(target, poll)) {
                        visitChair = i;
                    }
                    break;
                } else if (poll[0] > visited[i][0] && visited[i][1] < poll[0]) {

                    visited[i][0] = poll[0];
                    visited[i][1] = poll[1];
                    visited[i][2] = 1;
                    if (Arrays.equals(target, poll)) {
                        visitChair = i;
                    }
                    break;
                }

            }

            if(visitChair != Integer.MIN_VALUE) {
                break;
            }

        }

        return visitChair;

    }
}
