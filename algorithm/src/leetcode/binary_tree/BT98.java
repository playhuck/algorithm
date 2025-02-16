package leetcode.binary_tree;

public class BT98 {
    /*
        이진 트리의 root가 주어질 때, 유효한 이진 탐색 트리(BST)인지 판단하세요.
        유효한 BST는 다음과 같이 정의됩니다:

        노드의 왼쪽 서브트리는 해당 노드의 키보다 작은 키를 가진 노드들만 포함합니다.
        노드의 오른쪽 서브트리는 해당 노드의 키보다 큰 키를 가진 노드들만 포함합니다.
        왼쪽과 오른쪽 서브트리 모두 이진 탐색 트리여야 합니다.
     */

    public boolean isValidBST(TreeNode root) {

        if(root == null) return true;

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return isValidBST(node.left, min, node.val) &&
                isValidBST(node.right, node.val, max);
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
