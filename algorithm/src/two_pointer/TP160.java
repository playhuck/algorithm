package two_pointer;

import java.util.HashMap;
import java.util.Map;

public class TP160 {
    /*
        두 단일 연결 리스트의 head인 headA와 headB가 주어질 때, 두 리스트가 교차하는 노드를 반환하세요.
        두 연결 리스트가 전혀 교차하지 않는다면 null을 반환하세요.
        예를 들어, 다음 두 연결 리스트는 노드 c1에서 교차하기 시작합니다:
        테스트 케이스들은 전체 연결 구조에 어떤 순환도 없도록 생성됩니다.
        참고로 연결 리스트들은 함수가 반환된 후에도 원래의 구조를 유지해야 합니다.
        커스텀 저지:
        저지에 대한 입력은 다음과 같이 주어집니다(이 입력들은 당신의 프로그램에 주어지지 않습니다):

        intersectVal - 교차가 발생하는 노드의 값. 교차하는 노드가 없다면 0입니다.
        listA - 첫 번째 연결 리스트.
        listB - 두 번째 연결 리스트.
        skipA - 교차하는 노드에 도달하기 위해 listA에서 건너뛰어야 하는 노드의 수(head에서 시작).
        skipB - 교차하는 노드에 도달하기 위해 listB에서 건너뛰어야 하는 노드의 수(head에서 시작).

        저지는 이러한 입력들을 기반으로 연결 구조를 생성하고 두 head인 headA와 headB를 당신의 프로그램에 전달할 것입니다.
        교차하는 노드를 정확히 반환하면 당신의 해결책은 승인될 것입니다.
     */

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            Map<ListNode,Integer> map = new HashMap<>();

            ListNode cur1 = headA;
            ListNode cur2 = headB;

            ListNode intersectionNode = null;

            while (cur1 != null || cur2 != null) {

                if (cur1 != null) {
                    if(map.containsKey(cur1)){
                        intersectionNode = cur1;
                        break;
                    }
                    map.put(cur1, map.getOrDefault(cur1, 0) + 1);
                    cur1 = cur1.next;
                }

                if (cur2 != null) {
                    if(map.containsKey(cur2)){
                        intersectionNode = cur2;
                        break;
                    }
                    map.put(cur2, map.getOrDefault(cur2, 0) + 1);
                    cur2 = cur2.next;
                }
            }

            return intersectionNode;

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
