package leetcode.binary_tree.prev;

import java.util.ArrayList;
import java.util.List;

public class RE_BT96 {
    /*
        정수 n이 주어질 때, 1부터 n까지의 유일한 값을 가진 정확히
        n개의 노드로 구성된 구조적으로 유일한 **이진 탐색 트리(BST)**의 개수를 반환하세요.
        [참고: 구조적으로 유일하다는 것은 트리의 모양이 서로 다른 것을 의미합니다.]
     */

    public List<TreeNode> generateTrees(int n) {

        if (n == 0) return new ArrayList<>();

        return generate(1, n);

    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtrees = generate(start, i-1);
            List<TreeNode> rightSubtrees = generate(i+1, end);
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        return result;
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
