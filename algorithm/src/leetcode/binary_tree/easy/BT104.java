package leetcode.binary_tree.easy;

import java.util.Objects;

public class BT104 {

    /*
        주어진 이진 트리의 root(루트 노드)를 가지고,
        해당 트리의 **최대 깊이(maximum depth)**를 반환하시오.
     */

    public int maxDepth(TreeNode root) {

        return recursion(root);

    }

    public int recursion(TreeNode node) {

        if (node == null) return 0;

        return 1 + Math.max(recursion(node.left), recursion(node.right));
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
