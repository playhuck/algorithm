import javax.swing.tree.TreeNode;
import java.awt.List;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

//        System.out.println(countGoodRectangles(
//                new int[][]{{5,8},{3,9},{5,12},{16,5}}
//        ));
//        System.out.println(new RecentCounter().ping(
//                new String[]{"RecentCounter", "ping", "ping", "ping", "ping"}
//        ));
//        System.out.println(inorderTraversal(
//                "(()})"
//        ));
//        System.out.println(minNumber(
//                new String[]{"hello","world","leetcode"}, "welldonehoneyr"
//        ));
//        System.out.println(countStudents(
//                new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}
//        ));
//        System.out.println(timeRequiredToBuy(
//                new int[]{5,1,1,1}, 0
//        ));
//        System.out.println(captureForts(
//                new int[]{-1,-1,0,1,0,0,1,-1,1,0}
//        ));
    }

    /*
        단일 연결 리스트의 head가 주어질 때, 이것이 *회문(palindrome)*이면 true를, 그렇지 않으면 false를 반환하세요.
        [참고: 회문이란 앞에서부터 읽으나 뒤에서부터 읽으나 같은 값이 되는 것을 말합니다. 예를 들어 1->2->2->1은 회문입니다.]
     */
    public boolean isPalindrome(ListNode head) {

        Stack<Integer> stack = new Stack<>();

        ListNode cur = head;

        while (cur.next != null) {
            stack.push(cur.val);
            cur = cur.next;
        }

        stack.push(cur.val);

        cur = head;

        while (cur.next != null) {

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