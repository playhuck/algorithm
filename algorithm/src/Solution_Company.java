import java.util.*;

public class Solution_Company {

    public static void main(String[] args) {

//        System.out.println(countGoodRectangles(
//                new int[][]{{5,8},{3,9},{5,12},{16,5}}
//        ));
//        System.out.println(new RecentCounter().ping(
//                new String[]{"RecentCounter", "ping", "ping", "ping", "ping"}
//        ));
//        System.out.println(simplifyPath(
//                "/home/../../.."
//        ));
//        System.out.println(minNumber(
//                new String[]{"hello","world","leetcode"}, "welldonehoneyr"
//        ));
//        System.out.println(countStudents(
//                new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}
//        ));
//        System.out.println(timeRequiredToBuy(
//                new int[]{5,1,1,1}, 0
//        ));
//        System.out.println(Arrays.toString(maxRowSubsequence(
//                new int[]{0,0,3,3}, 2
//        )));
//        System.out.println(findDiagonalOrder(
//                new int[]{{1,2,3},{4,5,6},{7,8,9}}
//        ));
        List<List<Integer>> numsList = Arrays.asList(
                Arrays.asList(1,2,3),
                List.of(4),
                List.of(5,6,7),
                List.of(8),
                Arrays.asList(9,10,11)
        );
        System.out.println((smallestChair(new int[][]{{2,4}, {4,9}, {3,4}, {6,8}, {5,10}}, 4)));
        // {{2,4}, {4,9}, {3,4}, {6,8}, {5,10}}
        // {{3,10}, {1,5}, {2,6}}
    }

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

        /*
            small 리스트를 map에 저장하고,추가할 때마다 small리스트 자리를 채우면 되지 않을까?
            가장 작은 small 자리를 기억해 뒀다가 종료시간이 더 크거나 같은 값이 나오면 small을 채우고 map을 탐색하면서
            다시 제일 작은 small
         */

        Map<Integer, Integer> timeMap = new HashMap<>();

        int[] minPoll = queue.poll();
        int[] min = new int[]{minPoll[0], minPoll[1]};
        int sequence = 0;

        while (!queue.isEmpty()) {

            int[] poll = queue.poll();

            if(poll[1] > min[1] && poll[1] == min[1]) {}


        }

        return visitChair;

    }
}