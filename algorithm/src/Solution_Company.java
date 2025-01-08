import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                Arrays.asList(1, 2, 3),
                List.of(4),
                List.of(5, 6, 7),
                List.of(8),
                Arrays.asList(9, 10, 11)
        );
//        merge(new int[]{2,0}, 1, new int[]{1}, 1);
        System.out.println(maxArea(new int[]{8,7,2,1}));
        // {{2,4}, {4,9}, {3,4}, {6,8}, {5,10}}
        // {{3,10}, {1,5}, {2,6}}
    }

    /*
        길이가 n인 정수 배열 height가 주어집니다.
        n개의 수직선이 그려져 있으며, i번째 선의 두 끝점은 (i, 0)과 (i, height[i])입니다.
        x축과 함께 용기를 형성하는 두 선을 찾되, 이 용기가 가장 많은 물을 담을 수 있어야 합니다.
        용기가 담을 수 있는 최대 물의 양을 반환하세요.
        주의 용기를 기울일 수 없습니다.

        Input: height = [1,8,6,2,5,4,8,3,7]
        Output: 49

     */

    public static int maxArea(int[] height) {

        int p2 = height.length - 1;

        int maxFloor = 0;
        for (int i = 1; i < (double) (height.length / 2); i++) {

            if(height[maxFloor] < height[i]) {
                maxFloor = i;
            }
        }

        int maxSide = Integer.MIN_VALUE;

        for (int i = p2; i > maxFloor; i--) {

            int h = height[i];
            if(maxSide == Integer.MIN_VALUE) {
                maxSide = i;
                continue;
            }

            int min = Math.min(h, height[maxFloor]);
            int min2 = Math.min(height[maxSide], height[maxFloor]);

            int area1 = min * (height.length - maxFloor);
            int area2 = min2 * (height.length - maxFloor);

            if(area1 > area2) {
                maxSide = i;
            }


        }

//        int max = Integer.MIN_VALUE;
//
//        while (p2 > 0) {
//
//            for (int i = maxFloor; i < p2; i++) {
//
//                int h = height[i];
//
//                int min = Math.min(h, height[p2]);
//
//                max = Math.max(max, min * (p2 - i));
//
//            }
//
//            p2 --;
//        }

        return height[maxFloor] * maxSide;
    }
}