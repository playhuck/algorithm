package leetcode.heap;

import java.util.List;
import java.util.PriorityQueue;

public class Heap1424_DiagonalTraverse2 {
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
    int[] findDiagonalOrder(List<List<Integer>> nums) {

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {

            int sumCompare = (a[0] + a[1]) - (b[0] + b[1]);
            if (sumCompare != 0) {
                return sumCompare;
            }
            return b[0] - a[0];
        });

        int len = 0;

        for (int i = 0; i < nums.size(); i++) {

            List<Integer> num = nums.get(i);

            len += num.size();

            for (int j = 0; j < num.size(); j++) {

                queue.add(new int[]{i, j});
            }
        }

        int[] res = new int[len];

        int i = 0;

        while (!queue.isEmpty()) {

            int[] val = queue.poll();

            res[i] = nums.get(val[0]).get(val[1]);
            i ++;
        }

        return res;
    }
}
