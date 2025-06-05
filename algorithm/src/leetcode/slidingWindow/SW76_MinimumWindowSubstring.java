package leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SW76_MinimumWindowSubstring {
    /*
        길이가 각각 m과 n인 두 문자열 s와 t가 주어질 때,
        t의 모든 문자(중복 포함)가 윈도우에 포함되도록 하는 s의 최소 윈도우 부분 문자열을 반환하세요.
        그러한 부분 문자열이 없으면 빈 문자열 ""을 반환하세요.
        테스트 케이스는 답이 유일하도록 생성됩니다.

        t의 모든 문자가 포함되도록 하는 가장 작은 substring을 찾는 것
     */
    public String minWindow(String s, String t) {

        // ========== 1. 예외 처리 ==========
        if(s.length() < t.length()) return "";

        // ========== 2. 초기화 ==========
        String ans = "";  // 최종 답 (최소 윈도우)

        // 2-1. t의 각 문자별 필요 개수 저장
        Map<Character, Integer> tMap = new HashMap<>();
        for(char c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // 2-2. 현재 윈도우의 각 문자별 개수 저장
        Map<Character, Integer> sMap = new HashMap<>();
        
        // 2-3. 슬라이딩 윈도우 변수들
        int left = 0;     // 윈도우 시작점
        int count = 0;    // 조건을 만족한 문자 종류 개수
        
        // ========== 3. 슬라이딩 윈도우 메인 로직 ==========
        /*
            패턴: right 확장 → 조건 확인 → 조건 만족시 left 축소
            count: t의 모든 문자 종류가 충분히 포함되었는지 추적
        */
        for(int right = 0; right < s.length(); right++){

            char c = s.charAt(right);

            // ========== 4. 윈도우 확장 (right 이동) ==========
            if(tMap.containsKey(c)) {
                // 4-1. t에 포함된 문자라면 윈도우에 추가
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
                
                // 4-2. 이 문자가 필요한 개수를 만족했는지 확인
                if(Objects.equals(sMap.get(c), tMap.get(c))){
                    count++;  // 만족한 문자 종류 +1
                }

                // ========== 5. 조건 만족 확인 및 윈도우 축소 ==========
                /*
                    count == tMap.size() 의미:
                    - t의 모든 문자 종류가 필요한 개수만큼 윈도우에 포함됨
                    - 즉, 유효한 윈도우를 찾음
                */
                while (count == tMap.size() && left <= right) {
                    
                    // 5-1. 현재 윈도우가 더 작은 답인지 확인 및 갱신
                    String thisSubstring = s.substring(left, right + 1);
                    if(ans.isBlank()) {
                        ans = thisSubstring;  // 첫 번째 유효한 윈도우
                    }
                    if(ans.length() > thisSubstring.length()) {
                        ans = thisSubstring;  // 더 짧은 윈도우 발견
                    }

                    // 5-2. 윈도우 축소 (left 이동)
                    char c2 = s.charAt(left);

                    /*
                        left 위치의 문자를 윈도우에서 제거
                        만약 이 문자가 t에 필요한 문자라면:
                        - 제거 후 필요한 개수 미달시 count 감소
                        - sMap에서 개수 차감
                    */
                    if(tMap.containsKey(c2)) {
                        // 제거하기 전에 정확히 필요한 개수였다면
                        if (sMap.get(c2).equals(tMap.get(c2))) {
                            count--;  // 이제 이 문자는 부족해짐
                        }
                        sMap.put(c2, sMap.get(c2) - 1);  // 개수 차감
                    }
                    
                    left++;  // 윈도우 시작점 오른쪽으로 이동
                    
                    /*
                        while문 조건 재검사:
                        - count < tMap.size()가 되면 루프 종료
                        - 즉, 조건을 만족하지 않으면 축소 중단
                    */
                }
            }
            // t에 포함되지 않은 문자는 무시 (sMap에 저장하지 않음)
        }

        // ========== 6. 결과 반환 ==========
        return ans;  // 최소 윈도우 또는 빈 문자열
    }
}

/*
========== 알고리즘 흐름 요약 ==========

1. 준비: t의 문자 빈도를 tMap에 저장
2. 확장: right를 늘려가며 윈도우에 문자 추가
3. 추적: count로 조건 만족 여부 실시간 확인
4. 축소: 조건 만족시 left를 늘려가며 최소 윈도우 탐색
5. 갱신: 축소할 때마다 더 짧은 윈도우 발견시 답 갱신
6. 반복: 모든 위치를 탐색할 때까지 2-5 반복

핵심: "확장으로 조건 만족 → 축소로 최적화" 패턴
*/