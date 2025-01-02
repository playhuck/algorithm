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
        이진 트리의 root와 정수 targetSum이 주어질 때, 트리에 루트에서 리프까지의 경로가 있어서
        그 경로를 따라 모든 값을 더했을 때 targetSum과 같다면 true를 반환하세요.
        리프는 자식이 없는 노드입니다.
     */

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null) return false;
        if(Objects.isNull(root.left) && Objects.isNull(root.right)) return targetSum == root.val;

        Map<TreeNode, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> leafs = new ArrayList<>();

        TreeNode curr = root;
        int sum = 0;

        while (root.left != null || root.right != null) {

            while (Objects.nonNull(curr.left)) {
                stack.push(curr);
                map.put(curr, map.getOrDefault(curr, 0) + 1);
                sum += curr.val;
                curr = curr.left;
            }

            if (Objects.nonNull(curr.right)) {
                stack.push(curr);
                map.put(curr, map.getOrDefault(curr, 0) + 1);
                sum = sum + curr.val;
                curr = curr.right;
            } else {
                if (!stack.isEmpty()) {
                    final TreeNode prev = curr;
                    if(!map.containsKey(prev)) {
                        leafs.add(sum + prev.val);
                    }
                    curr = stack.pop();
                    sum = sum - curr.val;
                    if (Objects.equals(curr.left, prev)) {
                        curr.left = null;
                    } else if (Objects.equals(curr.right, prev)) {
                        curr.right = null;
                    }
                }
            }
        }

        for(Integer leaf : leafs) {
            System.out.println(leaf);
            if(leaf == targetSum) return true;
        }

        return false;
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