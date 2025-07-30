package leetcode.linkedList.hard;

public class LL25 {

    /*
        주어진 연결 리스트의 head(헤드 노드)와 양의 정수 k (k는 연결 리스트의 길이보다 작거나 같음)를 가지고,
        리스트의 노드들을 **k개씩 묶어 역순으로 변환(reverse)**하고, 그 변환된 리스트를 반환하시오.

        만약 남은 노드의 개수가 k의 배수가 아닌 경우, 마지막에 남은 노드들은 그대로 유지되어야 합니다.

        리스트 노드의 값(value)은 변경해서는 안 되며, 오직 노드 자체(연결 관계)만 변경해야 합니다.
     */

    /*
            오름차순으로 정렬된 노드는 아닙니다.
            일단 시작점 잡고,
                - 시작점으로부터 k개 넘어갔을 때
                - 시작점으로부터 k개가 안됐을 때(null인지 Check)
                - 재귀로 deepth가 3이 됐을 때 return하고 return된 값을 이어주는 방식으로 만들어 줘야 할 것 같네요
    */
    public ListNode reverseKGroup(ListNode head, int k) {

        return head;
    }
    public ListNode reverseKGroup2(ListNode head, int k) {

        if(head == null) return null;

        ListNode cur = head;
        int count = 0;

        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }

        if(count == k) {

            // count가 k일 때 현재 값을 다음으로 넘김
            // 기본적으로 뒤집는 문제기 때문에 뒤집는 파티션안의 마지막 값인 cur이 head가 됨
            // cur.next를 뽑고 count를 ++ 함

            cur = reverseKGroup(cur, k);

            // 실제로 값이 바뀌는 영역 뒤집는 코드는 LL 138과 같다.
            while( count -- > 0) {
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }

            head = cur;
        };

        return head;
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
