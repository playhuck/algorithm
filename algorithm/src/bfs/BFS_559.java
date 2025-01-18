package bfs;

import java.util.List;
import java.util.Objects;

public class BFS_559 {
    /*
        N진 트리가 주어질 때, 최대 깊이를 찾으세요.
        최대 깊이는 루트 노드에서 가장 먼 리프 노드까지의 가장 긴 경로를 따라 있는 노드의 수입니다.
        N진 트리의 입력 직렬화는 레벨 순서 순회로 표현되며, 각 자식 그룹은 null 값으로 구분됩니다 (예시 참조).
     */

    public int max = 0;

    public int maxDepth(Node root) {

        if (root == null) return 0;
        if (Objects.isNull(root.children)) return 1;

        return 1 + recursion(root);
    }

    public int recursion(Node node) {

        if (node == null) return 0;

        if (node.children.isEmpty()) return 0;

        if (node.children.size() == 1) {
            return 1 + recursion(node.children.get(0));
        }

        return 1 + Math.max(recursion(node.children.get(0)), recursion(node.children.get(1)));
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
