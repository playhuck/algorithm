package leetcode.linkedList.prev;

import java.util.HashMap;
import java.util.Map;

public class LL2130 {

      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public int pairSum(ListNode head) {

        if(head == null || head.next == null) {
            return 0;
        }

        int size = 0;
        ListNode cur = head;

        while(cur != null) {

            size ++;
            cur = cur.next;
        }

        cur = head;

        // 여기서 i는 0 <= i <= (n / 2) - 1;
        // i가 저 조건에 해당할 때 까지  n-1-i

        int i = 0;
        int max = Integer.MIN_VALUE;

        Map<Integer, Integer> map = new HashMap<>();

        while(cur != null) {

            if(i >= 0 && i <= (size / 2) - 1) {
                map.put(size - 1 - i, cur.val);
            } else {
                if(map.containsKey(i)) {
                    max = Math.max(max, cur.val + map.get(i));
                }
            }

            cur = cur.next;
            i ++;

        }

        return max;

    }
}
