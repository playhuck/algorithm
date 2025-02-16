package leetcode.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Sort2500_DeleteGreatestValueInEachRow {
    /*
        양의 정수로 구성된 m x n 행렬 grid가 주어집니다.
        grid가 비어질 때까지 다음 연산을 수행하세요:

        각 행에서 가장 큰 값을 가진 원소를 삭제합니다. 그러한 원소가 여러 개 있다면, 그 중 아무거나 삭제합니다.
        삭제된 원소들 중 최대값을 정답에 더합니다.

        참고: 각 연산 후에 열의 수가 1씩 감소합니다.
        위에서 설명한 연산들을 수행한 후의 정답을 반환하세요.

        Input: grid = [[1,2,4],[3,3,1]]
        Output: 8

     */

    public static int deleteGreatestValue(int[][] grid) {

        List<PriorityQueue<Integer>> queue = new ArrayList<>();

        int i = 0;

        while (i < grid.length) {

            PriorityQueue<Integer> queue2 = new PriorityQueue<>(Comparator.reverseOrder());

            for (int j = 0; j < grid[i].length; j++) {
                queue2.add(grid[i][j]);
            }

            queue.add(queue2);
            i++;
        }

        int val = 0;
        int i2 = 0;
        int max = Integer.MIN_VALUE;

        while (!queue.get(queue.size() - 1).isEmpty()) {

            int n = queue.get(i2).poll();
            if(n > max){
                max = n;
            }
            i2 ++;

            if(i2 == queue.size()){
                i2 = 0;
                val += max;
                max = Integer.MIN_VALUE;
            }
        }

        return val;

    }
}
