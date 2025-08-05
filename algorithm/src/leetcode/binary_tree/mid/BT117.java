package leetcode.binary_tree.mid;

import java.util.*;

public class BT117 {

    /*
        이진 트리가 주어졌습니다.
        각 next 포인터가 다음 오른쪽 노드를 가리키도록 채우세요.
        만약 다음 오른쪽 노드가 없으면, next 포인터는 NULL로 설정되어야 합니다.
        초기에 모든 next 포인터는 NULL로 설정되어 있습니다.

        상수(constant) 크기의 추가 공간만 사용해야 합니다.
        재귀적 접근 방식은 허용됩니다.
        이 문제에서는 재귀 호출 스택이 차지하는 공간은 추가 공간으로 간주하지 않아도 됩니다.
     */

    /*
        모든 노드의 next 포인터가 다음 오른쪽 노드를 가리키도록 하세요

        같은 깊이의 노드를 저장하는 Map이있고 이 Map이 순서에 따라 저장된다면 Map<Integer, List<Node>>
        이 순서에 저장된 값에 따라 다음으로 이어주면 됩니다.
     */
    public Node connect(Node root) {

        if(root == null) return null;

        Queue<Node> que = new LinkedList<>();

        que.offer(root);

        while (!que.isEmpty()) {

            int levelSize = que.size();

            Node prev = null;

            for(int i = 0; i < levelSize; i++) {

                Node cur = que.poll();

                if(prev != null) {
                    prev.next = cur;
                }

                prev = cur;

                if(cur.left != null) que.offer(cur.left);
                if(cur.right != null) que.offer(cur.right);
            }
        }

        return root;

    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
