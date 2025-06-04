package leetcode.slidingWindow;

import java.util.*;

public class SW3_LongestSubstringWithoutRepeatingCharacters {

    /*
        문자열 s가 주어질 때, 중복 문자가 없는 가장 긴 부분 문자열의 길이를 구하세요.
        문자가 연속되야 합니다.
     */
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0) return 0;

        Set<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;
        
        for(int right = 0; right < s.length(); right++) {
            
            char cur = s.charAt(right);
            
            // 중복 문자가 있으면 윈도우 축소
            while(set.contains(cur)) {
                set.remove(s.charAt(left));
                left++;
            }
            
            // 현재 문자 추가
            set.add(cur);
            
            // 현재 윈도우 길이로 최대값 갱신
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}