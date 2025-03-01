package leetcode.dfs;

public class DFS437 {
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
    class Solution {

        private int output = 0;

        public int pathSum(TreeNode root, int targetSum) {

            if(root == null) return 0;

            recursion(root, 0, targetSum);
            pathSum(root.left, targetSum);
            pathSum(root.right,  targetSum);

            return this.output;
        }

        public void recursion(TreeNode node, int cur, int targetSum) {

            if(node == null) return;

            int cur2 = cur + node.val;
            if(cur2 == targetSum) {
                this.output ++;
            }

            recursion(node.left, cur2, targetSum);
            recursion(node.right, cur2, targetSum);

        }
    }
}
