package leetcode.linkedList.mid;

public class LL82 {

    /*
        정렬된(sorted) 연결 리스트의 head(헤드 노드)가 주어졌을 때,
        중복되는 숫자를 가진 모든 노드를 삭제하고, 원래 리스트에서 고유한(distinct) 숫자만을 남겨 반환하시오.
        반환되는 연결 리스트 역시 정렬된 상태여야 합니다.
     */

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null) return null;

        ListNode dummy = new ListNode(0);

        return dummy.next;

    }


    public ListNode deleteDuplicates2(ListNode head) {

        if(head == null) return null;

        ListNode dummy = new ListNode(0);
        ListNode left = dummy; ListNode right = head;

        left.next = right;

        while (right != null) {

            while (right.next != null && right.val == right.next.val) {
                right = right.next;
            }

            if(left.next != right) {
                left.next = right.next;
                right = right.next;
            } else {
                left = left.next;
                right = right.next;
            }
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
