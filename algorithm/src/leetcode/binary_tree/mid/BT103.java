package leetcode.binary_tree.mid;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BT103 {

    /*
        이진 트리의 root가 주어졌을 때,
        노드들의 값을 **지그재그 레벨 순서 순회(zigzag level order traversal)**하여 반환하세요.
        즉, 한 레벨은 왼쪽에서 오른쪽으로, 다음 레벨은 오른쪽에서 왼쪽으로,
        이렇게 레벨마다 순회 방향을 번갈아 가면서 순회하는 것을 의미합니다.
     */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if(root == null) return list;

        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.addLast(root);
        boolean isLeft = true;

        while (!deque.isEmpty()) {

            TreeNode cur;
            int size = deque.size();
            List<Integer> l2 = new ArrayList<>();
            Deque<TreeNode> newDeque = new ArrayDeque<>();

            // 그냥 저장
            // 오른쪽부터 저장
            // 위에서 오른쪽부터 저장했으니 오른쪽에서 시작하기 때문에, 오른쪽의 하위 값은

            for(int i = 0; i < size; i++) {

                cur = isLeft ? deque.removeLast() : deque.removeFirst();

                l2.add(cur.val);

                /*
                    오른쪽 뒤부터 시작, 역순 저장 addLast -> 뒤부터 제거 (저장 순서는, right, left)
                    왼쪽이 앞부터 시작, 역순 저장 addFirst-> 앞부터 제거 (저장 순서는, left, right)
                 */
                if(isLeft) {
                    if (cur.left != null) newDeque.addFirst(cur.left);
                    if (cur.right != null) newDeque.addFirst(cur.right);
                } else {
                    if (cur.right != null) newDeque.addLast(cur.right);
                    if (cur.left != null) newDeque.addLast(cur.left);
                }

            }

            isLeft = !isLeft;
            list.add(l2);
            deque = newDeque;

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
