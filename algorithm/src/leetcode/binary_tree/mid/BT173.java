package leetcode.binary_tree.mid;

import com.sun.source.tree.Tree;

import java.util.*;

public class BT173 {

    /*
        BSTIterator 클래스를 구현하세요. 이 클래스는 이진 탐색 트리(BST)의
        **중위 순회(in-order traversal)**를 위한 이터레이터(반복자)를 나타냅니다.

        BSTIterator(TreeNode root): BSTIterator 클래스의 객체를 초기화합니다.
        생성자의 인자로 BST의 root 노드가 주어집니다. 포인터는 BST의 어떤 요소보다도 작은, 존재하지 않는 숫자로 초기화되어야 합니다.

        boolean hasNext(): 포인터의 오른쪽에 탐색할 다음 숫자가 있으면 true를 반환하고, 그렇지 않으면 false를 반환합니다.

        int next(): 포인터를 오른쪽으로 한 칸 이동시키고, 이동한 위치의 숫자를 반환합니다.
        포인터가 존재하지 않는 가장 작은 숫자로 초기화되기 때문에,
        next()를 처음 호출하면 BST에서 가장 작은 요소가 반환된다는 점에 유의하세요.

        next() 호출은 항상 유효하다고 가정해도 좋습니다.
        즉, next()가 호출될 때 중위 순회에는 항상 다음 숫자가 존재합니다.
     */

    class BSTIterator {

        Deque<TreeNode> queue;

        public BSTIterator(TreeNode root) {

            queue = new ArrayDeque<>();

            recursion(root.left, queue);
            queue.addLast(root);
            recursion(root.right, queue);


        }

        public int next() {

            if (queue.isEmpty()) {
                return -1;
            }

            return queue.removeFirst().val;
        }

        public boolean hasNext() {

            if (queue.isEmpty()) return false;

            return queue.peekFirst().val != Integer.MAX_VALUE;

        }

        public void recursion(TreeNode root, Deque<TreeNode> queue) {

            if (root == null) {
                return;
            }

            recursion(root.left, queue);

            queue.addLast(root);

            recursion(root.right, queue);

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
