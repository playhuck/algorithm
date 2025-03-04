package leetcode.dfs;

public class DFS1372 {

      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    private int max = Integer.MIN_VALUE;

    public int longestZigZag(TreeNode root) {

        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;

        recursion(root.left, 1, true);
        recursion(root.right, 1, false);

        return max;

    }

    public void recursion(TreeNode node, int count, boolean isLeft) {

        if(node == null) return;

        max = Math.max(count, max);

        recursion(node.right, isLeft ? count + 1 : 1, false);
        recursion(node.left, isLeft ? 1 : count + 1, true);

    }

}
