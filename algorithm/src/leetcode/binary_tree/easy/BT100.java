package leetcode.binary_tree.easy;

import java.util.Objects;
import java.util.Stack;

public class BT100 {

    /*
        두 이진 트리 p와 q의 루트 노드(root)가 주어졌을 때,
        두 트리가 서로 같은지 아닌지 확인하는 함수를 작성하시오.
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        return recursion(p, q);
    }

    public boolean recursion(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if(p == null) return false;
        if(q == null) return false;

        if(p.val != q.val) return false;

        return recursion(p.left, q.left) && recursion(p.right, q.right);
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
