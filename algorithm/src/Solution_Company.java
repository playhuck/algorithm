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
        이진 트리의 root가 주어질 때, 유효한 이진 탐색 트리(BST)인지 판단하세요.
        유효한 BST는 다음과 같이 정의됩니다:

        노드의 왼쪽 서브트리는 해당 노드의 키보다 작은 키를 가진 노드들만 포함합니다.
        노드의 오른쪽 서브트리는 해당 노드의 키보다 큰 키를 가진 노드들만 포함합니다.
        왼쪽과 오른쪽 서브트리 모두 이진 탐색 트리여야 합니다.
     */

    public boolean isValidBST(TreeNode root) {

        if(root == null) return true;

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return isValidBST(node.left, min, node.val) &&
                isValidBST(node.right, node.val, max);
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