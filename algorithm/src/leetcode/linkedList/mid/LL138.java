package leetcode.linkedList.mid;

import java.util.HashMap;
import java.util.Map;

public class LL138 {
    /*
        길이가 n인 연결 리스트가 주어지는데, 각 노드는 일반적인 next 포인터 외에 추가적인 random 포인터를 가지고 있습니다.
        이 random 포인터는 리스트 내의 어떤 노드를 가리킬 수도 있고, null일 수도 있습니다.
        이 리스트의 **깊은 복사본(deep copy)**을 만드세요.
        깊은 복사본은 정확히 n개의 완전히 새로운 노드들로 구성되어야 합니다.
        각 새 노드는 해당 원본 노드의 값과 동일한 값을 가져야 합니다.
        새 노드의 next 포인터와 random 포인터는 모두 복사된 리스트 내의 새로운 노드를 가리켜야 하며,
        원본 리스트와 복사된 리스트의 포인터 관계가 동일한 리스트 상태를 나타내야 합니다.
        새로운 리스트의 어떤 포인터도 원본 리스트의 노드를 가리켜서는 안 됩니다.
        예를 들어, 원본 리스트에 X와 Y라는 두 노드가 있고 X.random이 Y를 가리킨다면,
        복사된 리스트의 해당 노드 x와 y에서 x.random도 y를 가리켜야 합니다.
        복사된 연결 리스트의 헤드(시작점)를 반환하세요.
        연결 리스트는 입력/출력에서 n개의 노드 리스트로 표현됩니다. 각 노드는 [val, random_index] 쌍으로 표현되며:
        val: 노드의 Node.val을 나타내는 정수
        random_index: random 포인터가 가리키는 노드의 인덱스(0부터 n-1까지), 어떤 노드도 가리키지 않으면 null입니다.
        주의사항: 여러분의 코드는 원본 연결 리스트의 헤드만 주어집니다.

        제한사항:
        0 <= n <= 1000
        -10^4 <= Node.val <= 10^4
        Node.random은 null이거나 연결 리스트 내의 어떤 노드를 가리킵니다.
     */

    /*
        next와 random은 new Node인 완전 똑같은 복사본 만들기
     */
    public Node copyRandomList(Node head) {

        Map<Node, Node> map = new HashMap<>();

        Node n = head;

        while (n != null) {

            map.put(n, new Node(n.val));
            n = n.next;
        }

        n = head;

        while (n != null) {

            map.get(n).next = map.get(n.next);
            map.get(n).random = map.get(n.random);
            n = n.next;
        }

        return map.get(head);

    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
