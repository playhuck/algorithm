package leetcode.binary_tree.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BT637 {

    /*
        이진 트리의 root가 주어졌을 때, 각 레벨에 있는 노드들의 평균값을 배열 형태로 반환하세요.
        실제 정답과의 오차가 10 −5 이내인 답은 정답으로 인정됩니다.
     */

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> list = new ArrayList<>();

        if(root == null) return list;

        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.addLast(root);

        while (!deque.isEmpty()) {

            TreeNode cur;
            int size = deque.size();
            float sum = 0;

            for (int i = 0; i < size; i++) {

                cur = deque.removeFirst();

                sum += cur.val;

                if(cur.left != null) deque.addLast(cur.left);
                if(cur.right != null) deque.addLast(cur.right);

            }

            list.add((double) (sum / size));

        }

        return list;

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
