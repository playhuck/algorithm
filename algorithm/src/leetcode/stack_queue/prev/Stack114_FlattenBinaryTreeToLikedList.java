package leetcode.stack_queue.prev;

import java.util.Objects;
import java.util.Stack;

public class Stack114_FlattenBinaryTreeToLikedList {
    /*
        "연결 리스트"는 동일한 TreeNode 클래스를 사용해야 하며,
        여기서 right 자식 포인터는 리스트의 다음 노드를 가리키고 left 자식 포인터는 항상 null이어야 합니다.
        "연결 리스트"는 이진 트리의 전위 순회와 동일한 순서여야 합니다.
     */

    public void flatten(TreeNode root) {

        if (Objects.isNull(root)) {
            return;
        } else if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return;
        } else {

            TreeNode curr = root;

            Stack<TreeNode> stack = new Stack<>();

            while (true) {

                System.out.println(curr.val);

                if (Objects.nonNull(curr.right)) {
                    stack.push(curr.right);
                }

                if (Objects.nonNull(curr.left)) {

                    curr.right = curr.left;
                    curr.left = null;

                    curr = curr.right;

                    continue;

                }

                if (!stack.isEmpty()) {
                    curr.right = stack.pop();
                    curr = curr.right;
                } else {
                    if (Objects.isNull(curr.right)) {
                        break;
                    } else {
                        curr = curr.right;
                    }
                }

            }
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
