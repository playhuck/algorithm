package leetcode.slidingWindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SW3_LongestSubstringWithoutRepeatingCharacters {

    /*
        문자열 s가 주어질 때, 중복 문자가 없는 가장 긴 부분 문자열의 길이를 구하세요.
        문자가 연속되야 합니다.
     */
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0) return 0;

        Set<String> set = new HashSet<>();
        String[] strings = s.split("");

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < s.length(); i++) {

            String cur = strings[i];

            System.out.println(set.contains(" "));
            if(set.contains(cur)) {
                max = Math.max(max, set.size());
                set.clear();
                set.add(cur);
            } else {
                set.add(cur);
            };
        }

        return max;
    }
}
