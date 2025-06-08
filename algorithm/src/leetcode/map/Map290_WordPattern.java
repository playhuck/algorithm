package leetcode.map;

import java.util.HashMap;
import java.util.Map;

public class Map290_WordPattern {

    public boolean wordPattern(String pattern, String s) {

        if(pattern.length()!=s.length()) return false;

        Map<Character, String> pMap = new HashMap<>();
        Map<String, Character> sMap = new HashMap<>();

        String[] strings = s.split(" ");

        for(int x = 0; x<pattern.length(); x++){

            char c = pattern.charAt(x);
            String str = strings[x];

            if(pMap.containsKey(c)){

                if(!pMap.get(c).equals(str)) return false;
            } else pMap.put(c, str);

            if(sMap.containsKey(str)){

                if(!sMap.get(str).equals(c)) return false;
            } else sMap.put(str, c);
        }

        return true;

    }

}
