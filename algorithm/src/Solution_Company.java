import binary_tree.BT104;
import stack_queue.Stack144_BinaryTreePreorderTraversal;
import stack_queue.Stack94_BinaryTreeInOrderTraversal;

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
                Arrays.asList(1, 2, 3),
                List.of(4),
                List.of(5, 6, 7),
                List.of(8),
                Arrays.asList(9, 10, 11)
        );
//        System.out.println((smallestChair(new int[][]{{2, 4}, {4, 9}, {3, 4}, {6, 8}, {5, 10}}, 4)));
        // {{2,4}, {4,9}, {3,4}, {6,8}, {5,10}}
        // {{3,10}, {1,5}, {2,6}}
    }

    /*
        n개의 유일한 노드(값이 1부터 n까지)를 가진 구조적으로 유일한 모든 **이진 탐색 트리(BST)**를 반환하세요.
        답은 어떤 순서로든 반환할 수 있습니다.
        [참고: 구조적으로 유일하다는 것은 노드들의 배치 방식이 서로 다른 것을 의미합니다.]

        1~n까지의 숫자에서 각 숫자를 루트노드로 삼고 재귀호출
        현재 값보다 큰 값이 있다면 오른쪽 시작값, 종료 값 root + 1 ~ n
        현재 값보다 작은 값이 있다면 왼쪽 시작값 1 ~ root - 1
     */

    public List<TreeNode> generateTrees(int n) {

        if (n == 0) return new ArrayList<>();

        return generate(1, n);

    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> result = new ArrayList<>();

        // 베이스 케이스: 범위가 유효하지 않을 때
        if (start > end) {
            result.add(null);  // null도 하나의 유효한 서브트리
            return result;
        }

        for (int i = start; i <= end; i++) {
            // i를 루트로 하는 트리를 만들 예정
            // 여기에 로직 추가
            List<TreeNode> leftSubtrees = generate(start, i-1);
            List<TreeNode> rightSubtrees = generate(i+1, end);

            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);  // 현재 i를 루트로 하는 새 노드
                    root.left = left;                 // 왼쪽 서브트리 연결
                    root.right = right;               // 오른쪽 서브트리 연결
                    result.add(root);                 // 만들어진 트리를 결과 목록에 추가
                }
            }
        }

        // 여기에 로직을 추가할 예정
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}