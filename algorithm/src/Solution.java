import com.sun.source.tree.Tree;
import stack_queue.Stack144_BinaryTreePreorderTraversal;

import javax.swing.tree.TreeNode;
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
//        System.out.println(simplifyPath(
//                "/home/../../.."
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
        단일 연결 리스트의 head가 주어집니다. 리스트는 다음과 같이 표현될 수 있습니다:
        L0 → L1 → … → Ln - 1 → Ln
        리스트를 다음과 같은 형태로 재정렬하세요:
        L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
        리스트의 노드에 있는 값들을 수정해서는 안 됩니다. 노드 자체만 변경할 수 있습니다.

        [1,2,3,4] -> [1,4,2,3]
        [1,2,3,4,5] -> [1,5,2,4,3]
     */

    public void reorderList(ListNode head) {

        Deque<ListNode> deque = new ArrayDeque<>();

        if(Objects.isNull(head)){
            return;
        }

        if(Objects.isNull(head.next)){
            return;
        }

        for(ListNode cur = head; cur != null; cur = cur.next){
            if(Objects.equals(cur, head)){
                continue;
            }
            deque.push(cur);
        }

        ListNode cur = head;

        boolean pop = true;

        while (cur != null) {

            if(deque.isEmpty()){
                break;
            }

            if(pop) {
                cur.next = deque.pop();
                cur = cur.next;
                pop = false;
            } else {
                cur.next = deque.poll();
                cur = cur.next;
                pop = true;
            }
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