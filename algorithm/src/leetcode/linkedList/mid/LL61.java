package leetcode.linkedList.mid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LL61 {

    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || k == 0) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy,slow = dummy;

        int i;

        for(i = 0; fast.next != null; i ++) {
            fast = fast.next;
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
