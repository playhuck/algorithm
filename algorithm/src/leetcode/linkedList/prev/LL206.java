package leetcode.linkedList.prev;

import java.util.Stack;

public class LL206 {
    public ListNode reverseList(ListNode head) {

        if(head == null) {
            return head;
        }

        Stack<ListNode> stack = new Stack<>();

        ListNode cur = head;

        while(cur.next != null) {

            stack.push(cur);
            cur = cur.next;
        }

        ListNode result = new ListNode(cur.val);
        ListNode cur2 = result;

        while(stack.size() > 0) {

            ListNode tmp = stack.pop();
            cur2.next = tmp;
            cur2 = cur2.next;
            if(stack.size() == 0) {
                tmp.next = null;
            }

        }

        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
}
