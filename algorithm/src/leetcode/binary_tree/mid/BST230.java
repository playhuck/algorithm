package leetcode.binary_tree.mid;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class BST230 {

    /*
        이진 탐색 트리(BST)의 root와 정수 k가 주어졌을 때,
        트리 노드들의 값 중에서 k번째로 작은 값을 반환하세요. (여기서 k는 1부터 시작하는 인덱스입니다.)
     */

    public int kthSmallest(TreeNode root, int k) {

        Deque<TreeNode> deque = new ArrayDeque<>();

        TreeNode cur = root;

        while (true) {

            while (cur != null) {

                deque.addLast(cur);
                cur = cur.left;
            }

            cur = deque.removeLast();
            k --;

            if (k == 0) {
                return cur.val;
            }

            cur = cur.right;
        }
    }

    public int kthSmallest2(TreeNode root, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        helper(root, queue);

        if(queue.isEmpty()) return -1;

        int ans = 0;

        while (k > 0) {

            ans = queue.poll();
            k --;

        }

        return ans;

    }

    public void helper(TreeNode node, PriorityQueue<Integer> queue) {

        if(node == null) return;

        queue.add(node.val);

        helper(node.left, queue);
        helper(node.right, queue);
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
