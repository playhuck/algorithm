package leetcode.dfs;

import java.util.Objects;

public class DFS226 {
    /*
        이진 트리의 root가 주어질 때, 트리를 뒤집고 그 루트를 반환하세요.
     */

    public TreeNode invertTree(TreeNode root) {

        if(root == null) return null;
        if(Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return root;
        }

        reverse(root);

        return root;

    }

    public void reverse(TreeNode node) {

        if(node == null) return;

        TreeNode tmp = Objects.isNull(node.left) ? null : node.left;
        node.left = Objects.isNull(node.right) ? null : node.right;
        node.right = tmp;

        reverse(node.left);
        reverse(node.right);
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
