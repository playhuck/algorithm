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
        System.out.println(Arrays.toString(KthLargest(
                new int[]{10, 3, 8, 9, 4}
        )));
    }

    /*
        당신은 대학 입학 사무실의 일원이며 지원자들의 시험 점수 중 k번째로 높은 점수를 실시간으로 추적해야 합니다.
        이는 새로운 지원자들이 점수를 제출할 때마다 면접과 입학을 위한 커트라인을 동적으로 결정하는 데 도움이 됩니다.
        당신은 주어진 정수 k에 대해, 시험 점수들의 스트림을 관리하고 새로운 점수가 제출된 후 k번째로 높은 시험 점수를 지속적으로 반환하는 클래스를 구현해야 합니다.
        더 구체적으로, 우리는 모든 점수들의 정렬된 리스트에서 k번째로 높은 점수를 찾고 있습니다.
        KthLargest 클래스를 다음과 같이 구현하세요:

        KthLargest(int k, int[] nums) 정수 k와 시험 점수들의 스트림 nums로 객체를 초기화합니다.
        int add(int val) 새로운 시험 점수 val을 스트림에 추가하고, 지금까지의 시험 점수 풀에서 k번째로 큰 원소를 반환합니다.
     */

    static class KthLargest {

        int k;
        int front;
        int rear;
        PriorityQueue<Integer> nums;

        /*
            k는 주어진 배열 안에서 k 번째로 높은 점수
            add 했을 때 새로운 시험 점수를 strean에 추가하고, 지금까지 시험 점수 중 k 번째로 큰 원소 반환

            3번 째
            2 4 5 8 => 2 3 4 5 8 => 4 => 2 3 5 8
         */

        public KthLargest(int k, int[] nums) {

            PriorityQueue<Integer> queue = new PriorityQueue<>(Arrays.stream(nums).boxed().toList());

            this.k = k;

            Arrays.sort(nums);

            this.nums = queue;
            this.front = 0;
            this.rear = queue.size() - 1;

        }

        public int add(int val) {

            int kth = 0;

            int valAddedIndex = 0;


        }
    }

}