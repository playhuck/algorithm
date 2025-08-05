package leetcode.binary_tree.mid;

import java.util.*;

public class BT114 {

    /*
        이진 트리의 root가 주어졌을 때, 트리를 "연결 리스트(linked list)"로 평탄화(flatten)하세요.
        "연결 리스트"는 동일한 TreeNode 클래스를 사용해야 합니다. 여기서 right 자식 포인터는 리스트의 다음 노드를 가리키고,
        left 자식 포인터는 항상 null이어야 합니다.
        "연결 리스트"는 이진 트리의 전위 순회(pre-order traversal)와 동일한 순서여야 합니다.
     */

    public void flatten(TreeNode root) {

        if(root == null) return;

        Deque<TreeNode> que = new ArrayDeque<>();

        flatten(root, que);

        TreeNode prev = que.removeFirst();

        while (!que.isEmpty()) {

            TreeNode cur = que.removeFirst();

            prev.left = null;
            prev.right = cur;

            prev = cur;
        }

        prev.left = null;

    }

    public void flatten(TreeNode root, Deque<TreeNode> que) {

        if(root == null) return;

        que.addLast(root);

        flatten(root.left, que);
        flatten(root.right, que);
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
