package leetcode.binary_tree.easy;

import java.util.Objects;
import java.util.Stack;

public class BT101 {

    /*
        이진 트리의 root가 주어졌을 때,
        이 트리가 자체적으로 거울처럼 대칭인지(즉, 중앙을 기준으로 대칭) 확인하세요.
     */

    public boolean isSymmetric(BT226.TreeNode root) {

        Stack<Integer> l = new Stack<>();
        Stack<Integer> r = new Stack<>();

        recursionLeft(root.left, l);
        recursionRight(root.right, r);

        if(l.size() != r.size()) return false;

        while (!l.isEmpty() && !r.isEmpty()) {

            if(!Objects.equals(l.pop(), r.pop())) return false;
        }

        return true;

    }

    public void recursionLeft(BT226.TreeNode node, Stack<Integer> stack) {

        if(node == null) {
            stack.push(Integer.MAX_VALUE);
            return;
        }

        stack.push(node.val);

        recursionLeft(node.left, stack);
        recursionLeft(node.right, stack);

    }

    public void recursionRight(BT226.TreeNode node, Stack<Integer> stack) {

        if(node == null) {
            stack.push(Integer.MAX_VALUE);
            return;
        }

        stack.push(node.val);

        recursionRight(node.right, stack);
        recursionRight(node.left, stack);
    }
}
