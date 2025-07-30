package leetcode.binary_tree.easy;

public class BT226 {

    /*
        주어진 이진 트리의 root(루트 노드)를 가지고,
        해당 트리를 반전(invert)시키고, 그 (반전된) 루트 노드를 반환하시오.
     */
    public TreeNode invertTree(TreeNode root) {

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
