import com.sun.source.tree.Tree;
import stack_queue.Stack144_BinaryTreePreorderTraversal;

import javax.swing.tree.TreeNode;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solution {

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
//        System.out.println(kWeakestRows(
//                new int[]{10,3,8,9,4}
//        ));
    }

    /*
        m x n 크기의 이진 행렬 mat가 주어지며,
        이는 1(군인을 나타냄)과 0(시민을 나타냄)으로 구성되어 있습니다.
        군인들은 시민들의 앞에 위치해 있습니다. 즉, 각 행에서 모든 1은 모든 0의 왼쪽에 나타납니다.

        행 i는 다음 중 하나가 참일 때 행 j보다 더 약하다고 합니다:

        행 i의 군인 수가 행 j의 군인 수보다 적은 경우
        두 행의 군인 수가 같고 i < j인 경우
        행렬에서 가장 약한 것부터 가장 강한 순서로 정렬된 k개의 가장 약한 행의 인덱스를 반환하세요.
        Input: mat =
        [[1,1,0,0,0],
         [1,1,1,1,0],
         [1,0,0,0,0],
         [1,1,0,0,0],
         [1,1,1,1,1]],
        k = 3
        Output: [2,0,3]
     */

    public static int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if(a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        for (int i = 0; i < mat.length; i++) {

            int[] row = mat[i];
            int count = 0;

            for(Integer n : row){

                if(n == 1) {
                    count++;
                } else {
                    break;
                }
            }

            queue.add(new int[]{i, count});
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            int[] row = queue.poll();
            res[i] = Objects.requireNonNull(row)[0];
        }

        return res;

    }

}