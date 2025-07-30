package leetcode.linkedList.mid;

import java.util.Objects;

public class LL92 {

    /*
        주어진 단일 연결 리스트(Singly Linked List)의 head(헤드 노드)와
        두 개의 정수 left, right (left <= right 조건을 만족함)를 가지고,
        리스트의 left 위치부터 right 위치까지의 노드들을 역순으로 변환(reverse)하고, 그 역순 변환된 리스트를 반환하시오.
     */

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head == null) return null;
        ListNode dummy = new ListNode(0);

        dummy.next = head;

        ListNode pre = dummy;

        for(int i = 0; i < left - 1; i ++) {
            pre = pre.next;
        }

        ListNode start = pre.next;
        ListNode then = start.next;

        for(int i = 0; i < right - left; i ++) {

            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        return dummy.next;

    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {

        if(head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        for(int i =0; i < left - 1; i ++) {
            pre = pre.next;
        }

        ListNode start = pre.next; // left

        if(Objects.isNull(pre.next)) return head;
        ListNode cur = start.next; // left 다음 값

        for(int i = 0; i < right - left; i ++) {

            start.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = start.next;

        }

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
