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

        if(s.length() < t.length()) return "";

        StringBuilder ans = new StringBuilder();

        Map<Character, Integer> tMap = new HashMap<>();
        for(char c : t.toCharArray()){

            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sMap = new HashMap<>();
        for(int right = 0; right < s.length(); right++){

            char c = s.charAt(right);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);

        }

        int left;

        for(int x = 0; x < s.length(); x++){

            char c = s.charAt(x);

            if(tMap.containsKey(c)){

                int tCount = tMap.get(c);
                int sCount = sMap.get(c);
                if(sCount > tCount) {
                    sMap.put(c, sMap.get(c) - 1);
                } else {
                    /*
                        여기까지 줄이면 더이상 줄일 수 없는 선이 됨
                        그럼 여기부터 ~ 특정 지점까지 어떻게 줄일 것인가
                        오른쪽도 제거하면 될듯?
                        더이상 사이즈를 좁힐 수 없는 체크포인트에 다다랐음
                        x인덱스 위치와 더이상 줄일 수 없는 y인덱스 위치를 알고 있음
                     */
                    for(int y = s.length() - 1; y >= x; y --) {

                        char c2 = s.charAt(y);

                        if(tMap.containsKey(c2)){

                            int tCount2 = tMap.get(c2);
                            int sCount2 = sMap.get(c2);
                            if(sCount2 > tCount2) {
                                sMap.put(c2, sMap.get(c2) - 1);
                            } else {

                                left = x;

                                while(ans.length() < (y - x + 1) && left <= y) {

                                    ans.append(s.charAt(left));

                                    left ++;

                                }
                            }
                        } else {
                            sMap.put(c2, sMap.get(c2) + 1);
                        }

                    }
                    break;
                }

            } else {
                sMap.put(c, sMap.get(c) - 1);
            }

        }

        return ans.toString();

    }
}
