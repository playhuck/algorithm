package leetcode.array;

import java.util.*;

public class H_Index {

    /*
        H-Index는 [3,0,6,1,5] 일 때
        1번째 논문이 3번 인용
        3번째 논문이 6번 인용일 때, 인용된 횟수와, n 번째 논문의 최대 값의 교차 점을 찾는 값 입니다.
     */
    public int hIndex(int[] citations) {

        if(citations.length == 1) {
            if(citations[0] == 0) return 0;
            else return 1;
        };

        List<Integer> cList = new ArrayList<>(Arrays.stream(citations).boxed().toList());
        Collections.sort(cList);
        Collections.reverse(cList);

        int prev = Integer.MAX_VALUE; // 이전 인용 값
        int prevCount = 0; // 이전 인용 횟수
        int h = Integer.MIN_VALUE; // 이전 인용에 대한 두 값을 비교한 최소 값 (hIndex)

        for(int c : cList) {

            prevCount++;

            if(c <= prev) {
                prev = c;

                h = Math.max(h, Math.min(prev, prevCount));
            }

        }

        return h;
    }

    public int hIndex2(int[] citations) {

        if(citations.length == 1) {
            if(citations[0] == 0) return 0;
            else return 1;
        };

        // 1. 오름차순 정렬
        Arrays.sort(citations);

        // 2. 배열 뒤집기
        for (int i = 0; i < citations.length / 2; i++) {
            int temp = citations[i];
            citations[i] = citations[citations.length - 1 - i];
            citations[citations.length - 1 - i] = temp;
        }

        int prev = Integer.MAX_VALUE; // 이전 인용 값
        int prevCount = 0; // 이전 인용 횟수
        int h = Integer.MIN_VALUE; // 이전 인용에 대한 두 값을 비교한 최소 값 (hIndex)

        for(int c : citations) {

            prevCount++;

            if(c <= prev) {
                prev = c;

                h = Math.max(h, Math.min(prev, prevCount));
            }

        }

        return h;
    }

}
