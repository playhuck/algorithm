package leetcode.dfs;

public class DFS1448 {

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

    private int left = Integer.MIN_VALUE;
    private int right = Integer.MIN_VALUE;
    private int output = 0;

    public int goodNodes(TreeNode root) {

        /*
            각 왼쪽 오른쪽 트리 별로 최대값만들어서 트리 별로, 현재 가장 높은 값과 내가 같거나 크다면 output에 추가
        */

        if(root == null) {
            return 0;
        }

        left = root.val;
        right = root.val;
        output ++;

        recursion(root.left, this.left);
        recursion(root.right, this.right);

        return output;

    }

    public void recursion(TreeNode node, int max) {

        if(node == null) {
            return;
        }

        if(node.val >= max) {
            max = node.val;
            this.output ++;
        }

        if(node.left != null) {
            recursion(node.left, max);
        }

        if(node.right != null) {
            recursion(node.right, max);
        }
    }
}
