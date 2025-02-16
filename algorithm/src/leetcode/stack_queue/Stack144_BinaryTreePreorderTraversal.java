package leetcode.stack_queue;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Stack144_BinaryTreePreorderTraversal {
    /*
       이진 트리의 root가 주어질 때, 해당 노드들의 값을 전위 순회한 결과를 반환하세요.
       1. 왼쪽부터 탐색, 만약 하위 노드가 있다면, 그 노드를 다음 탐색 노드에 추가
       2. 모든 스택이 비어지면 종료

       //

       추가 조건, 맨 처음에 리프노드를 넣습니다. 다음 탐색 stack이 0이되면 종료
    */
    public List<Integer> preorderTraversal(TreeNode root) {

        Stack<Integer> preOrderTraversalStack = new Stack<>();
        Stack<TreeNode> nextSearchStack = new Stack<>();

        nextSearchStack.push(root);

        while (!nextSearchStack.isEmpty()) {

            TreeNode currentNode = nextSearchStack.pop();
            if (Objects.nonNull(currentNode)) {
                preOrderTraversalStack.push(currentNode.val);
                if (Objects.nonNull(currentNode.right)) {
                    nextSearchStack.push(currentNode.right);
                }
                if (Objects.nonNull(currentNode.left)) {
                    nextSearchStack.push(currentNode.left);
                }
            }
        }

        return preOrderTraversalStack.stream().toList();
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
