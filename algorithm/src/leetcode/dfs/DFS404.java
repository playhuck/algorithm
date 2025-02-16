package leetcode.dfs;

import java.util.HashMap;
import java.util.Map;

public class DFS404 {
    /*
        이진 트리의 `root`가 주어질 때, *모든 왼쪽 잎의 합*을 반환하세요.

        **잎**은 자식이 없는 노드입니다. **왼쪽 잎**은 다른 노드의 왼쪽 자식인 잎입니다.
     */

    public int sumOfLeftLeaves(TreeNode root) {

        Map<String, Integer> map = new HashMap<>();
        map.put("sum", 0);

        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return 0;
        } else {
            sum(root.left, map, true);
            sum(root.right, map, false);
        }

        return map.get("sum");

    }

    public void sum(TreeNode node, Map<String, Integer> sums, boolean isLeft) {

        if(node == null) {
            return;
        }

        if(node.left == null && node.right == null && isLeft) {
            sums.put("sum", sums.get("sum") + node.val);
            return;
        }

        sum(node.left, sums, true);
        sum(node.right, sums, false);

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
