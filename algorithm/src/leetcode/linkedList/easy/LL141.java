package leetcode.linkedList.easy;

import java.util.Objects;

public class LL141 {

    /*
        단방향 연결 리스트의 헤드(head)인 head가 주어졌을 때, 연결 리스트에 **사이클(cycle)**이 있는지 판별하세요.
        연결 리스트에 사이클이 있다는 것은 리스트 내의 어떤 노드가 next 포인터를 계속 따라갔을 때 다시 도달할 수 있음을 의미합니다.
        내부적으로 pos는 tail의 next 포인터가 연결된 노드의 인덱스를 나타내는 데 사용됩니다. pos는 매개변수로 전달되지 않습니다.
        연결 리스트에 사이클이 있다면 true를 반환하고, 그렇지 않다면 false를 반환하세요.

        연결 리스트의 노드 수는 [0, 10^4] 범위 내에 있습니다.

        Node.val (노드의 값)은 -10^5 이상 10^5 이하입니다.

        pos는 -1이거나 연결 리스트 내의 유효한 인덱스입니다.
     */

    public boolean hasCycle(ListNode head) {

        if(Objects.isNull(head) || Objects.isNull(head.next)) return false;

        ListNode cur = head;

        while (cur.next != null) {

            if(cur.next == head) return false;
            ListNode next = cur.next;
            cur.next = head;
            cur = next;

        }

        return true;

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
