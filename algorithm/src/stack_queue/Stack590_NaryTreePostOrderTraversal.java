package stack_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Stack590_NaryTreePostOrderTraversal {
    /*
        n진 트리의 root가 주어질 때, 해당 노드들의 값을 후위 순회한 결과를 반환하세요.
        N진 트리의 입력 직렬화는 레벨 순서 순회로 표현됩니다. 각 자식 그룹은 null 값으로 구분됩니다 (예시 참조)
     */
    public List<Integer> postorder(Node root) {

        List<Integer> postOrder = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        if(Objects.isNull(root)){
            return postOrder;
        }

        if(Objects.isNull(root.children)){
            postOrder.add(root.val);
            return postOrder;
        }

        Node cur = root;

        while (!root.children.isEmpty()) {

            if (!cur.children.isEmpty()) {
                stack.push(cur);
                cur = cur.children.get(0);
            } else {

                if(cur.val != Integer.MIN_VALUE){
                    postOrder.add(cur.val);
                }

                if(!stack.isEmpty()){
                    cur = stack.pop();
                    if(!cur.children.isEmpty()){
                        cur.children.remove(0);
                    }
                }
            }
        }

        postOrder.add(root.val);

        return postOrder;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
