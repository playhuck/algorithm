package binary_tree;

import java.util.Objects;
import java.util.Stack;

public class BT101 {
    /*
        이진 트리의 root가 주어질 때, 트리가 자기 자신의 거울 이미지인지 (즉, 중심을 기준으로 대칭인지) 확인하세요.

     */

    public static boolean isSymmetric(TreeNode root) {

        if(root == null) return true;
        if(Objects.isNull(root.left) && Objects.isNull(root.right)) return true;
        if(Objects.isNull(root.left)) return false;
        if(Objects.isNull(root.right)) return false;

        /*
            left와 right가 있다는 가정 한쪽은 왼쪽부터, 한쪽은 오른쪽부터 돌면서 일치하는지 찾음
         */

        Stack<TreeNode> leftSideStack = new Stack<>();
        Stack<TreeNode> rightSideStack = new Stack<>();

        leftSideStack.push(root.left);
        rightSideStack.push(root.right);

        while(!leftSideStack.isEmpty() && !rightSideStack.isEmpty()) {

            TreeNode leftSide = leftSideStack.pop();
            TreeNode rightSide = rightSideStack.pop();

            if(Objects.nonNull(leftSide) && Objects.isNull(rightSide)) {
                return false;
            }

            if(Objects.isNull(leftSide) && Objects.nonNull(rightSide)) {
                return false;
            }

            if(Objects.nonNull(leftSide)) {
                if(!Objects.equals(leftSide.val, rightSide.val)) {
                    return false;
                }
                if(Objects.nonNull(leftSide.left)) {
                    leftSideStack.push(leftSide.left);
                }
                if(Objects.nonNull(rightSide.right)) {
                    rightSideStack.push(rightSide.right);
                }
                if(Objects.nonNull(leftSide.right)) {
                    rightSideStack.push(leftSide.right);
                }
                if(Objects.nonNull(rightSide.left)) {
                    leftSideStack.push(rightSide.left);
                }
            }

        }

        return leftSideStack.isEmpty() && rightSideStack.isEmpty();

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
