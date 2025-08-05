package leetcode.binary_tree.hard;

import java.util.*;

public class BT124 {

    /*
        이진 트리에서의 **경로(path)**는 순서대로 인접한 두 노드가 간선으로 연결된 일련의 노드들을 의미합니다.
        한 노드는 경로에서 최대 한 번만 나타날 수 있습니다. 경로는 반드시 루트를 지나지 않아도 됩니다.

        경로의 **경로 합(path sum)**은 경로에 있는 노드들의 값의 합입니다.
        이진 트리의 root가 주어졌을 때, 비어 있지 않은(non-empty) 모든 경로의 합 중 최댓값을 반환하세요.

        - 일단 모든 리프노드는 가능성을 가지고 있다.
        - 리프 노드에서 출발한 값은 위로 올라갔다 내려갈 수만 있다.
        - 리프 노드에서 출발한 값이 부모를 타고 올라가는 선택지 1번
        - 리프 노드에서 출밣한 값이 부모를 타고 올라갔다 내려오는 선택지 2번
            - 내려와서 left child right child 없으면 그 노드에서 덧샘하고 종료하고 우선순위 큐에 넣기
     */

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;

        return max;
    }

    public int maxPathSum2(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;

        helper(root);

        return max;
    }

    public int helper(TreeNode root) {

        if(root == null) return 0;

        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        max = Math.max(max, root.val + left + right);

        return root.val + Math.max(left, right);
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
