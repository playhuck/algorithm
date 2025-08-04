package leetcode.binary_tree.easy;

import java.util.Objects;
import java.util.Stack;

public class BT226 {

    /*
        주어진 이진 트리의 root(루트 노드)를 가지고,
        해당 트리를 반전(invert)시키고, 그 (반전된) 루트 노드를 반환하시오.

        왼쪽우선 탐색 -> 오른쪽 우선 배치

        그냥 왼쪽거 따로 수집, 오른쪽 거 따로 수집
     */
    public TreeNode invertTree(TreeNode root) {

        if(root == null) return null;

        recursive(root);

        return root;

    }

    public void recursive(TreeNode node) {

        if(node == null) return;

        TreeNode right = node.right;
        node.right = node.left;
        node.left = right;

        recursive(node.left);
        recursive(node.right);
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
