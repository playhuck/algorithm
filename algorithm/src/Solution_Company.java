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
        System.out.println(Arrays.toString(productExceptSelf(
                new int[]{1,2,3,4}
        )));
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
//        System.out.println((smallestChair(new int[][]{{2,4}, {4,9}, {3,4}, {6,8}, {5,10}}, 4)));
        // {{2,4}, {4,9}, {3,4}, {6,8}, {5,10}}
        // {{3,10}, {1,5}, {2,6}}
    }

    /*
        m x n 크기의 문자 격자 board와 문자열 word가 주어질 때,
        word가 격자에 존재한다면 true를 반환하세요.
        단어는 인접한 셀들의 문자들로 구성될 수 있으며,
        인접한 셀은 가로나 세로로 이웃한 것을 의미합니다.
        같은 문자 셀은 한 번 이상 사용할 수 없습니다.
     */

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, 1);

        int curr = 1;
        // 왼쪽부터 누적 곱
        for(int i = 0; i < n; i++) {
            answer[i] *= curr;
            System.out.println("CURR: " + curr + " " + "NUMS: " + nums[i] + " " + "ANSWER: " + answer[i]);
            curr *= nums[i];
        }

        curr = 1;
        // 오른쪽부터 누적 곱
        for(int i = n - 1; i >= 0; i--) {
            answer[i] *= curr;
            System.out.println("CURR: " + curr + " " + "NUMS: " + nums[i] + " " + "ANSWER: " + answer[i]);
            curr *= nums[i];
        }

        return answer;
    }
}