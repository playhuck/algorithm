package leetcode.binary_tree.mid;

import java.util.ArrayDeque;
import java.util.Deque;

public class BST98 {
    
    /*
        이진 트리의 root가 주어졌을 때, 이 트리가 **유효한 이진 탐색 트리(BST)**인지 판별하세요.
        유효한 BST는 다음과 같이 정의됩니다.
        어떤 노드의 왼쪽 서브트리에 있는 모든 노드의 키(값)는 그 노드의 키보다 엄격하게 작아야 합니다.
        어떤 노드의 오른쪽 서브트리에 있는 모든 노드의 키는 그 노드의 키보다 엄격하게 커야 합니다.
        왼쪽과 오른쪽 서브트리 또한 모두 이진 탐색 트리여야 합니다.

     */

    public boolean isValidBST(TreeNode root) {
        
        if(root == null) return true;

        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    /*
        CUR VAL :32  MAX : 9223372036854775807 MIN : -9223372036854775808
        CUR VAL :26  MAX : 32 MIN : -9223372036854775808
        CUR VAL :19  MAX : 26 MIN : -9223372036854775808
        CUR VAL :27  MAX : 26 MIN : 19
        CUR VAL :47  MAX : 9223372036854775807 MIN : 32
        CUR VAL :56  MAX : 9223372036854775807 MIN : 47
     */
    public boolean helper(TreeNode node, int max, int min) {

        if(node == null) return true;

        if(node.val >= max || node.val <= min) return false;

        boolean l = helper(node.left, node.val, min);
        boolean r = helper(node.right, node.val, max);

        return l && r;
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
