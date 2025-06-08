package leetcode.map;

import java.util.*;
import java.util.stream.Collectors;

public class Map205_IsomorphicStrings {

    // 각 언어가 여러개씩 등장하는데 대응되는 단어랑 개수가 다 일치하면 true
    // 대응되는 위치까지 일치해야 합니다.
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) return false;

        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        // 여기서 대응되는 숛자가 같아야 OK
        // 대응되는 문자가 같을 때

        for (int x = 0; x < s.length(); x++) {
            char ch1 = s.charAt(x);
            char ch2 = t.charAt(x);

            if(sMap.containsKey(ch1)) {

                if(sMap.get(ch1) != ch2) return false;
            } else sMap.put(ch1, ch2);

            if(tMap.containsKey(ch2)) {
                if(tMap.get(ch2) != ch1) return false;
            } else tMap.put(ch2, ch1);
        }

        return true;

    }
}
