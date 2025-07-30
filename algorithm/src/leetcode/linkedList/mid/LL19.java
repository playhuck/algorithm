package leetcode.linkedList.mid;

import java.util.HashMap;
import java.util.Map;

public class LL19 {

    /*
        주어진 연결 리스트의 head(헤드 노드)를 가지고,
        리스트의 끝에서부터 n번째 노드를 제거하고,
        (노드가 제거된) 해당 리스트의 헤드 노드를 반환하시오.
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) return head;

        return head;

    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {

        if (head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode left = dummy;
        ListNode right = dummy;

        for(int i = 0; i < n + 1; i ++) right = right.next;

        while (right.next != null) {

            left = left.next;
            right = right.next;

        }

        left.next = right;

        return dummy.next;

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
