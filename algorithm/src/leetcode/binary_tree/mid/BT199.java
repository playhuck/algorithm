package leetcode.binary_tree.mid;

import java.util.*;

public class BT199 {

    /*
        이진 트리의 root가 주어졌을 때,
        당신이 트리의 오른쪽에 서 있다고 상상해 보세요.
        이때 위에서 아래로 볼 수 있는 노드들의 값을 순서대로 반환하세요.
     */

    /*
        너비우선 탐색으로 List에 너비마다 다 넣고,
        모든 리스트의 마지막 인덱스 꺼내기
     */
    public List<Integer> rightSideView(TreeNode root) {

        if(root == null) return new ArrayList<>();

        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();

        deque.addFirst(root);

        while (!deque.isEmpty()) {

            TreeNode cur = null;
            int size = deque.size();

            for(int i = 0; i < size; i ++) {

                cur = deque.removeFirst();

                if(cur.left != null) deque.addLast(cur.left);
                if(cur.right != null) deque.addLast(cur.right);

            }

            ans.add(cur.val);

        }

        return ans;

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
