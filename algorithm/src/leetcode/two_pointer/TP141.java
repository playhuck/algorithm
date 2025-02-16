package leetcode.two_pointer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TP141 {
    /*
        연결 리스트의 head인 head가 주어질 때, 연결 리스트에 순환이 있는지 판단하세요.

        연결 리스트에서 next 포인터를 계속 따라가다 보면 다시 도달할 수 있는 노드가 있다면 순환이 있는 것입니다.
        내부적으로 pos는 꼬리의 next 포인터가 연결된 노드의 인덱스를 나타내는 데 사용됩니다. pos는 매개변수로 전달되지 않습니다.

        연결 리스트에 순환이 있다면 true를, 그렇지 않다면 false를 반환하세요.

        Input: head = [3,2,0,-4], pos = 1
        Output: true
     */

    public class Solution {
        public boolean hasCycle(ListNode head) {

            if(head == null || head.next == null) return false;

            List<String> l =  new ArrayList<>();
            boolean hasCycle = false;

            ListNode curr = head;
            Pattern reg = Pattern.compile("[aeiou]");
            while (curr.next != null) {

                if(curr.val == Integer.MIN_VALUE){
                    hasCycle = true;
                    break;
                }

                curr.val = Integer.MIN_VALUE;
                curr = curr.next;
            }

            return hasCycle;

        }
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
