package binary_tree;

import java.util.Objects;

public class BT111 {
    /*
        이진 트리가 주어질 때, 최소 깊이를 찾으세요.
        최소 깊이는 루트 노드에서 가장 가까운 리프 노드까지의 최단 경로를 따라 있는 노드의 수입니다.
        참고: 리프는 자식이 없는 노드입니다.
     */

    public int minDepth(TreeNode root) {

        if(root == null) return 0;

        int left = height(root.left) + 1;
        int right = height(root.right) + 1;

        if(left == 1) return right;
        if(right == 1) return left;

        return Math.min(left, right);

    }

    public int height(TreeNode node) {

        if(node == null) return 0;

        if(Objects.isNull(node.left) && Objects.nonNull(node.right)) {
            return 1 + height(node.right);
        } else if(Objects.nonNull(node.left) && Objects.isNull(node.right)) {
            return 1 + height(node.left);
        } else {
            return 1 + Math.max(height(node.left), height(node.right));
        }

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
