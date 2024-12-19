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
//        System.out.println(Arrays.toString(maxSubsequence(
//                new int[]{0,0,3,3}, 2
//        )));
//        System.out.println(findDiagonalOrder(
//                new int[]{{1,2,3},{4,5,6},{7,8,9}}
//        ));
        List<List<Integer>> numsList = Arrays.asList(
                Arrays.asList(1,2,3,4,5),
                Arrays.asList(6,7),
                List.of(8),
                Arrays.asList(9,10,11),
                Arrays.asList(12,13,14,15,16)
        );
        System.out.println(Arrays.toString(findDiagonalOrder(numsList)));
    }

    /*
        2차원 정수 배열 nums가 주어질 때,
        아래 이미지에 보이는 것처럼 nums의 모든 원소를 대각선 순서로 반환하세요.

        Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
        Output: [1,4,2,7,5,3,8,6,9]

        [0,0]

        //

        [1,0] +1
        [0,1] -1 +1

        //

        [2,0] +2
        [1,1] -1 +2
        [0,2] -2 +2

        //

        [3,0] +3
        [2,1] -1 +1
        [1,2] -2 +2
        [0,3] -3 +4

        //

        [4,0]
        [3,1]
        [2,2]
        [1,3]
        [0,4]
        ...

        [4,1]
        [3,2]
        [2,3]
        [1,4]

        [4,2]
        [3,3]
        [2,4]

        ..

        //

        직사각형이니
        row => 제일 큰 배열의 크기
        column => 제일 큰 배열의 제일 큰 크기만큼
        [max, max]가 될 때 까지
     */

    public static int[] findDiagonalOrder(List<List<Integer>> nums) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());;

        int max = Integer.MIN_VALUE;
        int length = 0;

        for (List<Integer> num : nums) {

            if(num.size() > max) {
                max = num.size();
            }
            length += num.size();

        }

        int[] res = new int[length];

        int row = 0;
        int currRow = 0;
        int currCol = 0;

        int index = 0;
        int lastIndex = 2;

        boolean rowStream = true;

        while (currRow != max -1 || currCol != max - 1) {

            if(rowStream) {

                if(currRow == 4 && currCol == 0) {
                    System.out.println("Hello");
                    System.out.println(res.length);
                    nums.get(currRow).get(currCol);
                }

                if (currRow < max - 1 && currCol < nums.get(currRow).size() - 1) {
                    res[index] = nums.get(currRow).get(currCol);
                    index++;
                }

                if(currRow == 0) {

                    if(currCol == max - 1){
                        currRow = max - 1;
                        currCol = 1;
                        rowStream = false;
                        continue;
                    }

                    row ++;

                    currRow = row;
                    currCol = 0;
                } else {
                    currRow = currRow - 1;
                    currCol = currCol + 1;
                }

            } else {

                System.out.println(currRow + " " + currCol + "h");

                if (currRow < max - 1 && currCol < nums.get(currRow).size() - 1) {
                    res[index] = nums.get(currRow).get(currCol);
                    index++;
                }

                if(currCol == max - 1) {
                    currRow = max - 1;
                    currCol = lastIndex;

                    lastIndex ++;
                } else {
                    currRow = currRow - 1;
                    currCol = currCol + 1;
                }
            }
        }

        return res;
    }

}