package leetcode.map;

import java.util.HashMap;
import java.util.Map;

public class Map383_RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> map = new HashMap<>();
        for(char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        /*
            magazine으로 ransomNote를 만들 수 있으면 ok
            ransomNote에 키 없는거 발견하면 false;
            -1하는데 magazine에 숫자 부족하면 false;
         */

        for(char c : ransomNote.toCharArray()) {

            if(!map.containsKey(c)) {
                return false;
            }

            if(map.get(c) == 0) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }

        return !map.isEmpty();

    }

}
