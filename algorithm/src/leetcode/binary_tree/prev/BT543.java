package leetcode.binary_tree.prev;

public class BT543 {
    /*
        이진 트리의 root가 주어질 때, 트리의 지름의 길이를 반환하세요.
        이진 트리의 지름은 트리에서 임의의 두 노드 사이의 가장 긴 경로의 길이입니다.
        이 경로는 root를 지날 수도 있고 지나지 않을 수도 있습니다.
        두 노드 사이 경로의 길이는 그들 사이의 간선의 개수로 나타냅니다.
     */

    private Integer max = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {

        recursion(root);

        return max;

    }

    public int recursion(TreeNode node) {

        if(node == null) return 0;
        int left = recursion(node.left);
        int right = recursion(node.right);

        max = Math.max(max, left + right);
        return 1 + Math.max(left, right);
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
