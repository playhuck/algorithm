package leetcode.binary_tree.mid;

import java.util.*;

public class BT102 {

    /*
        이진 트리의 root가 주어졌을 때,
        노드들의 값을 **레벨 순서 순회(level order traversal)**하여 반환하세요.
        즉, 왼쪽에서 오른쪽으로, 레벨별로 순회하는 것을 의미합니다.
     */

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if(root == null) return list;

        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.addLast(root);

        while (!deque.isEmpty()) {

            TreeNode cur;
            int size = deque.size();
            List<Integer> l2 = new ArrayList<>();

            for(int i = 0; i < size; i++) {

                cur = deque.removeFirst();

                l2.add(cur.val);

                if(cur.left != null) deque.addLast(cur.left);
                if(cur.right != null) deque.addLast(cur.right);
            }

            list.add(l2);

        }

        return list;

    }

      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
