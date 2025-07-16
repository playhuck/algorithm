package leetcode.stack_queue.prev;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Stack589_NaryTreePreorderTraversal {
    /*
       n진 트리의 root가 주어질 때, 해당 노드들의 값을 전위 순회한 결과를 반환하세요.
       N진 트리의 입력 직렬화는 레벨 순서 순회로 표현됩니다.
       각 자식 그룹은 null 값으로 구분됩니다 (예시 참조)
    */
    /*
        n진 트리의 root가 주어질 때, 해당 노드들의 값을 전위 순회한 결과를 반환하세요.
        N진 트리의 입력 직렬화는 레벨 순서 순회로 표현됩니다.
        각 자식 그룹은 null 값으로 구분됩니다 (예시 참조)
     */
    public List<Integer> preorder(Node root) {

        List<Integer> preOrder = new ArrayList<>();
        Stack<Node> stacks = new Stack<>();

        Node curr = root;

        if(Objects.isNull(root)){
            return preOrder;
        }

        if(Objects.isNull(root.children) || root.children.isEmpty()){
            preOrder.add(curr.val);
            return preOrder;
        }

        while (!root.children.isEmpty()) {

            if (curr.val != Integer.MIN_VALUE) {
                preOrder.add(curr.val);
                curr.val = Integer.MIN_VALUE;
            }

            if (!curr.children.isEmpty()) {

                if (Objects.nonNull(curr.children.get(0))) {
                    stacks.push(curr);
                    curr = curr.children.get(0);
                } else {

                    curr = stacks.pop();
                    if(!curr.children.isEmpty()) {
                        curr.children.remove(0);
                    }

                }
            } else {
                if (!stacks.isEmpty()) {
                    curr = stacks.pop();
                    if(!curr.children.isEmpty()) {
                        curr.children.remove(0);
                    }
                }
            }

        }

        return preOrder;
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
