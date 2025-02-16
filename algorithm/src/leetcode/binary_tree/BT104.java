package leetcode.binary_tree;

import java.util.Objects;
import java.util.Stack;

public class BT104 {
    /*
        이진 트리의 root가 주어질 때, 최대 깊이를 반환하세요.
        이진 트리의 최대 깊이는 루트 노드에서 가장 먼 리프 노드까지의 경로를 따라 있는 노드의 수입니다.

     */

    public static int maxDepth(TreeNode root) {

        int depth = 0;
        int currDepth;
        if (root == null) {
            return depth;
        } else {
            depth = 1;
            currDepth = 1;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (root.right != null || root.left != null) {

            while (curr.left != null) {
                stack.push(curr);
                curr = curr.left;
                currDepth ++;
                depth = Math.max(currDepth, depth);
            }

            if(Objects.isNull(curr.right)) {
                if(!stack.isEmpty()) {
                    final TreeNode prev = curr;
                    curr = stack.pop();
                    currDepth --;
                    if (Objects.equals(curr.left, prev)) {
                        curr.left = null;
                    } else if (Objects.equals(curr.right, prev)) {
                        curr.right = null;
                    }
                }
            } else {
                stack.push(curr);
                curr = curr.right;
                currDepth ++;
                depth = Math.max(currDepth, depth);
            }

        }

        return depth;

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
