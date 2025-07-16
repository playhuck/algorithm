package leetcode.linkedList.mid;

import java.util.List;
import java.util.Objects;

public class LL2 {

    /*
        비어 있지 않은 두 개의 연결 리스트가 주어지는데,
        이들은 두 개의 음이 아닌 정수를 나타냅니다.
        숫자들은 역순으로 저장되어 있으며, 각 노드는 하나의 숫자를 담고 있습니다.
        이 두 숫자를 더하여 그 합을 연결 리스트로 반환하세요.

        두 숫자 모두 0 자체를 제외하고는 선행하는 0을 포함하지 않는다고 가정할 수 있습니다.

        각 연결 리스트의 노드 수는 [1, 100] 범위 내에 있습니다.
        Node.val (노드의 값)은 0 이상 9 이하입니다.
        리스트가 선행하는 0이 없는 숫자를 나타낸다는 것이 보장됩니다.
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode cur = l1;
        ListNode cur2 = l2;

        while (cur != null && l2 != null) {


        }

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
