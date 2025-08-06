package leetcode.graph.mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph133 {

    /*
        연결된 무방향 그래프의 한 노드에 대한 참조(reference)가 주어집니다.
        이 그래프의 깊은 복사(deep copy), 즉 복제본을 반환하세요.

        그래프의 각 노드는 val (정수)와 이웃 노드들의 리스트(List[Node])를 포함합니다.

        class Node {
            public int val;
            public List<Node> neighbors;
        }
        테스트 케이스 형식
        간결성을 위해, 각 노드의 값은 노드의 인덱스와 동일합니다(1부터 시작).
        예를 들어, 첫 번째 노드의 val은 1, 두 번째 노드의 val은 2, 이런 식입니다.
        그래프는 인접 리스트(adjacency list) 형식으로 테스트 케이스에 표현됩니다.

        인접 리스트는 유한 그래프를 표현하는 데 사용되는 정렬되지 않은 리스트들의 모음입니다.
        각 리스트는 그래프에서 한 노드의 이웃 노드들의 집합을 설명합니다.

        주어진 노드는 항상 val이 1인 첫 번째 노드가 될 것입니다.
        여러분은 복제된 그래프에 대한 참조로서, 주어진 노드의 복사본을 반환해야 합니다.
     */

    /*
        val, Node
     */
    Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {

        return helper(node);

    }

    public Node helper(Node node) {

        if(node == null) return null;

        Node newNode = new Node(node.val);
        if(!map.containsKey(newNode.val)) {
            map.put(newNode.val, newNode);
        }

        for(Node n : node.neighbors) {

            if(!map.containsKey(n.val)) {
                Node newNode2 = helper(n);
                newNode.neighbors.add(newNode2);
            } else {
                newNode.neighbors.add(map.get(n.val));
            }
        }

        return newNode;

    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
