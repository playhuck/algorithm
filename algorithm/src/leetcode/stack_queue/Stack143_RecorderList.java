package leetcode.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Stack143_RecorderList {
    /*
        단일 연결 리스트의 head가 주어집니다. 리스트는 다음과 같이 표현될 수 있습니다:
        L0 → L1 → … → Ln - 1 → Ln
        리스트를 다음과 같은 형태로 재정렬하세요:
        L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
        리스트의 노드에 있는 값들을 수정해서는 안 됩니다. 노드 자체만 변경할 수 있습니다.

        [1,2,3,4] -> [1,4,2,3]
        [1,2,3,4,5] -> [1,5,2,4,3]
     */

    public void reorderList(ListNode head) {

        Deque<ListNode> deque = new ArrayDeque<>();

        if(Objects.isNull(head)){
            return;
        }

        if(Objects.isNull(head.next)){
            return;
        }

        for(ListNode cur = head; cur != null; cur = cur.next){
            if(Objects.equals(cur, head)){
                continue;
            }
            deque.push(cur);
        }

        ListNode cur = head;

        boolean pop = false;

        while (!deque.isEmpty()) {

            cur.next = pop ? deque.removeLast() : deque.removeFirst();
            cur = cur.next;
            pop = !pop;

        }

        cur.next = null;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
