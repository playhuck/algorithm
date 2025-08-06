package leetcode.binary_tree.easy;

import java.util.PriorityQueue;

public class BST530 {

    /*
        이진 탐색 트리(BST)의 root가 주어졌을 때,
        트리 내에 있는 서로 다른 두 노드 값의 최소 절대 차이를 반환하세요.
     */

    int min = Integer.MAX_VALUE;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public int getMinimumDifference(TreeNode root) {

        if(root == null) return 0;

        helper(root);

        if(minHeap.isEmpty()) return 0;

        int n = minHeap.poll();

        while (!minHeap.isEmpty()) {

            int n2 = minHeap.poll();

            min = Math.min(min, Math.abs(n2 - n));

            n = n2;

        }

        return min;
    }

    public void helper(TreeNode node) {

        if(node == null) return ;

        minHeap.add(node.val);

        helper(node.left);
        helper(node.right);

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
