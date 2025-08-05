package leetcode.binary_tree.easy;

public class BT112 {

    /*
        이진 트리의 root와 정수 targetSum이 주어졌을 때,
        트리에 루트(root)부터 리프(leaf)까지의 경로 중,
        경로에 있는 모든 노드의 값을 더한 합이 targetSum과 같아지는 경로가 하나라도 있으면 true를 반환하세요.

        **리프(leaf)**는 자식이 없는 노드입니다.

        1. 리프노드의 값을 반환해야 합니다.
        2. 리프노드는 left, right 둘 다 없는 값 입니다.
     */

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null) return false;

        return hasPathSum(root, targetSum, 0);
    }

    public boolean hasPathSum(TreeNode root, int targetSum, int curSum) {

        if(root.left == null && root.right == null) {

            if(curSum + root.val == targetSum) return true;
            else return false;
        }

        boolean l = false;
        boolean r = false;

        if(root.left != null) l = hasPathSum(root.left, targetSum, curSum + root.val);
        if(root.right != null) r = hasPathSum(root.right, targetSum, curSum + root.val);

        return l || r;
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
