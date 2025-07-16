package leetcode.stack_queue.prev;

import java.util.LinkedHashMap;
import java.util.Map;

public class Queue387 {
     /*
        문자열 s가 주어졌을 때, 문자열에서 처음으로 등장하는
        중복되지 않는 문자를 찾아 해당 문자의 인덱스를 반환하세요. 만약 그러한 문자가 존재하지 않는다면, -1을 반환하세요.
     */

    public static int firstUniqChar(String s) {

        Map<Character, Integer> charMap = new LinkedHashMap<>();

        for(Character c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            if(entry.getValue() == 1) {
                return s.indexOf(entry.getKey());
            }
        }

        return -1;
    }
}
