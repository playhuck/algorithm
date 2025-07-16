package leetcode.stack_queue.prev;

import java.util.Objects;
import java.util.Stack;

public class Stack234_PalindromeLikedList {
    /*
            단일 연결 리스트의 head가 주어질 때, 이것이 *회문(palindrome)*이면 true를, 그렇지 않으면 false를 반환하세요.
            [참고: 회문이란 앞에서부터 읽으나 뒤에서부터 읽으나 같은 값이 되는 것을 말합니다. 예를 들어 1->2->2->1은 회문입니다.]
         */
    public boolean isPalindrome(ListNode head) {

        Stack<Integer> stack = new Stack<>();

        ListNode cur = head;

        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }

        cur = head;

        while (cur != null) {

            int stackLastVal = stack.peek();
            if(Objects.equals(stackLastVal, cur.val)) {
                stack.pop();
            }

            cur = cur.next;
        }

        return stack.isEmpty();
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
