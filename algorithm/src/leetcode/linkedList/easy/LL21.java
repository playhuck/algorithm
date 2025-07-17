package leetcode.linkedList.easy;

public class LL21 {

    /*
        두 개의 정렬된 연결 리스트 list1과 list2의 헤드(시작점)가 주어집니다.
        두 리스트를 하나의 정렬된 리스트로 병합하세요.
        이 병합된 리스트는 첫 번째와 두 번째 리스트의 노드들을 이어 붙여서 만들어져야 합니다.
        병합된 연결 리스트의 헤드를 반환하세요.

        제한사항:
        두 리스트의 노드 수는 각각 0개에서 50개 사이입니다.
        노드의 값(Node.val)은 -100에서 100 사이입니다.
        list1과 list2는 모두 오름차순으로 정렬되어 있습니다.
     */

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = new ListNode();
        ListNode cur = head;

        while (list1 != null || list2 != null) {

            cur.next = new ListNode();
            cur = cur.next;

            if(list1 == null) {
                cur.val = list2.val;
                list2 = list2.next;
                continue;
            }

            if(list2 == null) {
                cur.val = list1.val;
                list1 = list1.next;
                continue;
            }

            if(list1.val < list2.val) {
                cur.val = list1.val;
                list1 = list1.next;
            } else if(list1.val > list2.val) {
                cur.val = list2.val;
                list2 = list2.next;
            } else {
                cur.val = list1.val;
                list1 = list1.next;

                cur.next = new ListNode();
                cur = cur.next;

                cur.val = list2.val;
                list2 = list2.next;
            }

        }

        return head.next;

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
