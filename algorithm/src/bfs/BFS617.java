package bfs;

import java.util.Objects;

public class BFS617 {
    /*
        두 개의 이진 트리 root1과 root2가 주어집니다.
        하나의 트리를 다른 트리 위에 올려놓는다고 상상해보면, 두 트리의 일부 노드들은 겹치고 일부는 겹치지 않습니다.
        당신은 두 트리를 새로운 이진 트리로 병합해야 합니다. 병합 규칙은 다음과 같습니다: 두 노드가 겹치면 노드 값들을 더해서 병합된 노드의 새로운 값으로 사용합니다.
        그렇지 않다면, null이 아닌 노드가 새 트리의 노드로 사용됩니다.
        병합된 트리를 반환하세요.
        참고: 병합 과정은 반드시 두 트리의 루트 노드들부터 시작해야 합니다.
     */

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if(root1 == null && root2 == null) return null;

        TreeNode newRoot = new TreeNode();

        recursion(root1, newRoot);
        recursion(root2, newRoot);

        return newRoot;
    }

    public void recursion(TreeNode node, TreeNode newNode) {

        if (node == null) {
            return;
        }

        newNode.val = newNode.val == Integer.MIN_VALUE ? node.val : newNode.val + node.val;

        if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
            if(Objects.nonNull(newNode.left) && newNode.left.val == Integer.MIN_VALUE) {
                newNode.left = null;
            }

            if(Objects.nonNull(newNode.right) && newNode.right.val == Integer.MIN_VALUE) {
                newNode.right = null;
            }
            return;
        }

        if(Objects.isNull(node.left)) {
            newNode.right = Objects.isNull(newNode.right) ? new TreeNode(Integer.MIN_VALUE) : newNode.right;
            recursion(node.right, newNode.right);
        } else if(Objects.isNull(node.right)) {
            newNode.left = Objects.isNull(newNode.left) ? new TreeNode(Integer.MIN_VALUE) : newNode.left;
            recursion(node.left, newNode.left);
        } else {

            newNode.right = Objects.isNull(newNode.right) ? new TreeNode(Integer.MIN_VALUE) : newNode.right;
            newNode.left = Objects.isNull(newNode.left) ? new TreeNode(Integer.MIN_VALUE) : newNode.left;

            recursion(node.left, newNode.left);
            recursion(node.right, newNode.right);
        }

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
