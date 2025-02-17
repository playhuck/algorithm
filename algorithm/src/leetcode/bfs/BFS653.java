package leetcode.bfs;

import java.util.ArrayList;
import java.util.List;

public class BFS653 {
    /*
        이진 탐색 트리의 root와 정수 k가 주어질 때,
        BST 안에 두 원소의 합이 k와 같은 경우가 있으면 true를, 그렇지 않으면 false를 반환하세요.
     */

    public boolean findTarget(TreeNode root, int k) {

        List<Integer> list = new ArrayList<>();

        recursion(root, list);

        boolean isFindTarget = false;


        for (int i = 0; i < list.size(); i++) {

            int cur = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {

                int next = list.get(j);
                if ((cur + next) == k) {
                    return true;
                }
            }
        }

        return isFindTarget;

    }

    public void recursion(TreeNode node, List<Integer> list) {
        if (node == null) return;

        list.add(node.val);

        recursion(node.left, list);
        recursion(node.right, list);

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
