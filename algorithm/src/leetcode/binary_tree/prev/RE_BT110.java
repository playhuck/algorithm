package leetcode.binary_tree.prev;

public class RE_BT110 {
    /*
        이진 트리가 주어질 때, 이것이 높이 균형 트리인지 판단하세요.
        [참고: 높이 균형 이진 트리는 모든 노드에 대해 왼쪽과 오른쪽 하위 트리의 높이 차이가 최대 1인 이진 트리입니다.]

        왼쪽과 오른쪽 높이를 구함
     */

    public boolean isBalanced(TreeNode root) {

        if(root == null) return true;

        if(Math.abs(height(root.left) - height(root.right)) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);

    }

    public int height(TreeNode node) {

        if(node == null) return 0;

        return 1 + Math.max(height(node.left), height(node.right));
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
