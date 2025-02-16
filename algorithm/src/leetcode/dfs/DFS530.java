package leetcode.dfs;

import java.util.Objects;
import java.util.PriorityQueue;

public class DFS530 {
    /*
        이진 탐색 트리(BST)의 root가 주어질 때, 트리에서 서로 다른 두 노드의 값들 간의 최소 절대 차이를 반환하세요.
     */

    public int getMinimumDifference(TreeNode root) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        getMinAbs(root, queue);

        int min = Integer.MAX_VALUE;

        while (queue.size() > 1) {

            int cur = queue.poll();
            int next = queue.peek();
            min = Math.min(min, Math.abs(cur - next));

        }

        return min;
    }

    public void getMinAbs(TreeNode node, PriorityQueue<Integer> queue) {

        if(node == null) {
            return;
        }

        if(node.left == null && node.right == null) {
            queue.add(node.val);
            return;
        }

        queue.add(node.val);

        if(Objects.nonNull(node.left) && Objects.nonNull(node.right)) {
            getMinAbs(node.left, queue);
            getMinAbs(node.right, queue);
        } else getMinAbs(Objects.requireNonNullElseGet(node.left, () -> node.right), queue);
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

     /*
        이진 탐색 트리(BST)의 root가 주어질 때, 트리에서 서로 다른 두 노드의 값들 간의 최소 절대 차이를 반환하세요.
        1. 비교 값 선언
        2. 중위 순회하면서 비교
     */

    private Integer prev = null;
    private Integer min = Integer.MAX_VALUE;

    public int getMinimumDifference2(TreeNode root) {

        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;

        inOrder2(root);

        return min;
    }

    public void inOrder2(TreeNode node) {

        if (node == null) {
            return;
        }

        inOrder2(node.left);

        if(prev!=null) {
            min=Math.min(min, Math.abs(node.val-prev));
        }

        prev = node.val;

        inOrder2(node.right);

    }
}
