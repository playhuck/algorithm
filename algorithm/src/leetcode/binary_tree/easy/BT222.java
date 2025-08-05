package leetcode.binary_tree.easy;

public class BT222 {

    /*
        완전(complete) 이진 트리의 root가 주어졌을 때, 트리 내의 전체 노드 개수를 반환하세요.

        위키피디아에 따르면, 완전 이진 트리는 마지막 레벨을 제외한 모든 레벨이 완전히 채워져 있으며,
        마지막 레벨의 노드들은 가능한 한 가장 왼쪽에 위치합니다. 마지막 레벨 h에는 1개에서 2h
        개 사이의 노드가 포함될 수 있습니다.

        이 문제의 시간 복잡도가 O(n) 미만인 알고리즘을 설계하세요.
     */

    int sum = 0;

    public int countNodes(TreeNode root) {

        helper(root);

        return sum;
    }

    public void helper(TreeNode root) {

        if(root == null) return;

        sum += 1;

        helper(root.left);
        helper(root.right);
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
