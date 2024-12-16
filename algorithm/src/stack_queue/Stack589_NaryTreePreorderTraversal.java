package stack_queue;

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

            /*
                1. 리스트가 빈 값이 아닐 때, 아래가 존재한다면 아래로 내려갑니다.
                2. 만약 아래가 null이라면 현제 내 배열의 다음값을 선택합니다.
                3. 다음 값이 존재한다면, 현재 값은 children의 다음 인덱스입니다.
                4. 다음 값이 없다면 pop하여 올라갑니다.
                5. 만약 배열이 비어있다면 pop하여 올라갑니다.
             */

            if (curr.val != Integer.MIN_VALUE) {
                System.out.println("CURR VAL : " + curr.val);
                preOrder.add(curr.val);
                curr.val = Integer.MIN_VALUE;
            }

            System.out.println("CURR CHILDREN : " + curr.children.size());
            System.out.println("ROOT CHILDREN : " + root.children.size());

            if (!curr.children.isEmpty() && Objects.nonNull(root.children)) {

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
