package leetcode.linkedList.mid;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

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

       ListNode cur = new ListNode();
       ListNode node = cur;

       int total = 0, carry = 0;

       while (l1 != null || l2 != null || carry != 0) {

           total = carry;
           if(l1 != null){
               total += l1.val;
               l1 = l1.next;
           }

           if(l2 != null){
               total += l2.val;
               l2 = l2.next;
           }

           int num = total % 10;
           carry = total / 10;
           node.next = new ListNode(num);
           node = node.next;
       }

       return cur.next;

    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode cur = l1;
        ListNode cur2 = l2;

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        do {

            if(cur != null) {
                s1.insert(0, cur.val);
                cur = cur.next;
            }

            if(cur2 != null) {
                s2.insert(0, cur2.val);
                cur2 = cur2.next;
            }

        } while (cur != null || cur2 != null);

        BigInteger cur1Big = s1.toString().isEmpty() ? BigInteger.ZERO : new BigInteger(s1.toString());
        BigInteger cur2Big = s2.toString().isEmpty() ? BigInteger.ZERO : new BigInteger(s2.toString());

        BigInteger sum = cur1Big.add(cur2Big);
        List<Integer> list = new ArrayList<>();
        String sumStr = sum.toString();

        for(int i = sumStr.length() - 1; i >= 0; i--) {
            list.add(sumStr.charAt(i) - '0');
        }
        if(list.isEmpty()) return null;
        ListNode newNode = new ListNode();
        newNode.val = list.get(0);
        if(list.size() == 1){
            return newNode;
        }
        Collections.reverse(list);

        ListNode n = newNode;
        for (int i = 1; i < list.size(); i++) {

            ListNode nextNode = new ListNode(list.get(i));
            n.next = nextNode;
            n = nextNode;
        }

        return newNode;

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
